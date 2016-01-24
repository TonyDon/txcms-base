/*
 * @(#)UploaderAction.java 2013-12-15
 * 
 * Copy Right@ uuola
 */

package com.uuola.txcms.common.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.DateUtil;
import com.uuola.commons.StringUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.constant.CST_CHAR;
import com.uuola.commons.constant.CST_DATE_FORMAT;
import com.uuola.commons.file.FileUtil;
import com.uuola.commons.image.ImageUtil;
import com.uuola.commons.listener.WebContext;
import com.uuola.txcms.component.FileExtNameValidator;
import com.uuola.txcms.constants.CST_ERROR_MSG;
import com.uuola.txweb.framework.utils.ContextUtil;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2013-12-15
 * </pre>
 */
@Controller
@RequestMapping("/uploader")
public class UploaderAction {

    private Logger log = LoggerFactory.getLogger(getClass());

    private final String UPLOAD_ROOT_DIR = "/upfile";

    private final String UPLOAD_DIR_CONFIG = "image|file";

    @Autowired
    private FileExtNameValidator fileExtNameValidator;

    /**
     * 上传图片,常规文件，返回上传后的文件URL资源路径
     * 
     * @param mpFile
     * @return
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "mpfile") MultipartFile mpFile ,
            @RequestParam(value = "dir") String storeDir, 
            @RequestParam(value = "needThumb", defaultValue="false") boolean needThumb) {
        if (null == mpFile || mpFile.getSize() == 0) {
            return getModel(null, CST_ERROR_MSG.UPLOAD_FILE_SIZE_EMPTY, 1);
        }
        if(!UPLOAD_DIR_CONFIG.contains(storeDir)){
            return getModel(null, CST_ERROR_MSG.UPLOAD_DIR_INVALID, 1);
        }
        String extName = FileUtil.getFileExt(mpFile.getOriginalFilename());
        if (!fileExtNameValidator.checkCommonExt(extName)) {
            return getModel(null, CST_ERROR_MSG.EXT_NAME_INVALID, 1);
        }
        String url = null;
        try {
            // 保存文件路径
            String dateDir = DateUtil.formatDate(new Date(), CST_DATE_FORMAT.YYYYsMMsDD);
            String dirPath = CST_CHAR.STR_SLASH.concat(storeDir)
                    .concat(CST_CHAR.STR_SLASH).concat(dateDir)
                    .concat(CST_CHAR.STR_SLASH).concat(KeyGenerator.getRndChr(1));

            String distDir = ContextUtil.getRealPath(UPLOAD_ROOT_DIR).concat(dirPath);
            FileUtil.createNoExistsDirs(distDir);

            // 新文件名
            String fileName = KeyGenerator.getRndChr(8).concat(CST_CHAR.STR_UNDER_LINE)
                    .concat(Long.toHexString(DateUtil.getCurrMsTime()))
                    .concat(CST_CHAR.STR_UNDER_LINE)
                    .concat(Long.toHexString(mpFile.getSize()));
            
            String distName = fileName.concat(CST_CHAR.STR_DOT).concat(extName);
            File dist = new File(distDir, distName);
            mpFile.transferTo(dist);

            // 缩图
            if (needThumb && dist.exists() && dist.canRead() && fileExtNameValidator.checkImageExt(extName)) {
                File w1Image = new File(distDir, fileName.concat(".100.").concat(extName));
                ImageUtil.resize(dist, w1Image, 100, 0, false);
            }

            url = WebContext.getServletContext().getContextPath().concat(UPLOAD_ROOT_DIR).concat(dirPath)
                    .concat(CST_CHAR.STR_SLASH).concat(distName);

        } catch (Exception e) {
            log.error("save()", e);
        }
        
        return getModel(url, null, 0);
    }

    /**
     * 删除单个文件
     * 
     * @param url
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@RequestParam(value = "url") String url) throws FileNotFoundException {
        if (StringUtil.isEmpty(url)) {
            return false;
        }
        url = StringUtil.replace(url.trim(), WebContext.getServletContext().getContextPath(), CST_CHAR.STR_EMPTY);
        String extName = FileUtil.getFileExt(url);
        if (StringUtil.startsNotWith(url, UPLOAD_ROOT_DIR) || url.contains("..")
                || url.toLowerCase().contains("web-inf") || url.toLowerCase().contains("meta-inf")
                || !fileExtNameValidator.checkCommonExt(extName)) {
            return false;
        }

        String path = ContextUtil.getRealPath("/").concat(url);
        File file = new File(path);
        if (file.isDirectory() || !file.exists()) {
            return false;
        }
        
        if (fileExtNameValidator.checkImageExt(extName)) {
            String thumbPath = StringUtil.replace(path, extName, CST_CHAR.STR_EMPTY);
            File w1Thumb = new File(thumbPath.concat("100.").concat(extName));
            if (w1Thumb.exists()) {
                FileUtils.deleteQuietly(w1Thumb);
            }
        }

        return FileUtils.deleteQuietly(file);
    }

    private ModelAndView getModel(String url, String messsge, Integer error) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", url);
        mv.addObject("message", messsge);
        mv.addObject("error", error);
        return mv;
    }
}
