/*
 * @(#)UploaderAction.java 2013-12-15
 * 
 * Copy Right@ uuola
 */

package com.uuola.txcms.common.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;

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
import com.uuola.commons.NumberUtil;
import com.uuola.commons.StringUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.constant.CST_CHAR;
import com.uuola.commons.file.FileUtil;
import com.uuola.commons.image.ImageInfo;
import com.uuola.commons.image.ImageUtil;
import com.uuola.commons.listener.WebContext;
import com.uuola.txcms.component.FileExtNameValidator;
import com.uuola.txcms.component.StoreFileUtil;
import com.uuola.txcms.constants.CST_ERROR_MSG;
import com.uuola.txweb.framework.action.BaseAction;
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
public class UploaderAction extends BaseAction {

    private Logger log = LoggerFactory.getLogger(getClass());

    private final String UPLOAD_ROOT_DIR = "/store";

    private final String UPLOAD_DIR_CONFIG = "image|file";

    @Autowired
    private FileExtNameValidator fileExtNameValidator;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        return this.makeModelView("index");
    }

    /**
     * 上传图片,常规文件，返回上传后的文件URL资源路径
     * 
     * @param mpFile
     * @return
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView store(@RequestParam(value = "mpfile") MultipartFile mpFile ,
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
            Calendar cal = Calendar.getInstance();
            String dirPath = String.format("/%s/%x/%03d/%04d", storeDir, DateUtil.getYear(cal), DateUtil.getDayInYear(cal),
                    NumberUtil.genRndInt(10, 100));

            String distDir = ContextUtil.getRealPath(UPLOAD_ROOT_DIR).concat(dirPath);
            FileUtil.createNoExistsDirs(distDir);

            // 新文件名
            String fileName = KeyGenerator.getRndChr(4).concat(Long.toHexString(DateUtil.getCurrMsTime()))
                    .concat(Long.toHexString(mpFile.getSize()));
            
            String distName = fileName.concat(CST_CHAR.STR_DOT).concat(extName);
            File dist = new File(distDir, distName);
            mpFile.transferTo(dist);
            boolean isImage = fileExtNameValidator.checkImageExt(extName);
            
            // 控制原图最大尺寸进行缩图处理
            if (isImage) {
                ImageInfo imgInfo = ImageUtil.detect(dist);
                // 修正图片扩展名
                if (null != imgInfo && !extName.equalsIgnoreCase(imgInfo.getFormatName())) {
                    extName = imgInfo.getFormatName();
                    distName = fileName.concat(CST_CHAR.STR_DOT).concat(imgInfo.getFormatName());
                    File newFile = new File(distDir, distName);
                    dist.renameTo(newFile);
                    dist = newFile;
                }
                if (null != imgInfo && imgInfo.getWidth() > 640) {
                    // 对原图进行缩图处理
                    ImageUtil.resize(dist, null, 640, 0, false);
                }
            }

            // 缩图
            if (needThumb && dist.exists() && dist.canRead() && isImage) {
                File w1Image = new File(distDir, fileName.concat(".w120.").concat(extName));
                ImageUtil.resize(dist, w1Image, 120, 0, false);
            }

            url = WebContext.getServletContext().getContextPath().concat(UPLOAD_ROOT_DIR).concat(dirPath)
                    .concat(CST_CHAR.STR_SLASH).concat(distName);
            
            url = StoreFileUtil.parseUrl(url);
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
        int domainCtxLen = StoreFileUtil.getStoreFileDomain().length() + WebContext.getServletContext().getContextPath().length();
        url = url.trim().substring(domainCtxLen);
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
            File w1Thumb = new File(thumbPath.concat("w120.").concat(extName));
            if (w1Thumb.exists()) {
                FileUtils.deleteQuietly(w1Thumb);
            }
        }

        return FileUtils.deleteQuietly(file);
    }

    private ModelAndView getModel(String url, String messsge, Integer error) {
        ModelAndView mv = this.makeModelView("store");
        mv.addObject("url", url);
        mv.addObject("message", messsge);
        mv.addObject("error", error);
        return mv;
    }
}
