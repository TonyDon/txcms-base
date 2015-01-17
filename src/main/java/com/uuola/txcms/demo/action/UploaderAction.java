/*
 * @(#)UploaderAction.java 2013-12-15
 * 
 * Copy Right@ uuola
 */

package com.uuola.txcms.demo.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    private final String UPLOAD_IMAGE_DIR = "/image";

    @Autowired
    private FileExtNameValidator fileExtNameValidator;

    /**
     * 上传图片文件，返回上传后的图片URL资源路径
     * 
     * @param image
     * @return
     */
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ModelAndView saveImage(@RequestParam(value = "imageFile") MultipartFile image) {
        if (null == image || image.getSize() == 0) {
            return getModel(null, CST_ERROR_MSG.UPLOAD_FILE_SIZE_EMPTY, 1);
        }
        String result = CST_CHAR.STR_EMPTY;
        String extName = FileUtil.getFileExt(image.getOriginalFilename());
        if (!fileExtNameValidator.checkImageExt(extName)) {
            return getModel(null, CST_ERROR_MSG.IMAGE_EXT_NAME_INVALID, 1);
        }
        try {
            // 保存文件路径
            String dateDir = DateUtil.formatDate(new Date(), CST_DATE_FORMAT.YYYY_MM_DD);
            String imgDir = UPLOAD_IMAGE_DIR.concat(CST_CHAR.STR_SLASH).concat(
                    StringUtils.replace(dateDir, CST_CHAR.STR_LINE, CST_CHAR.STR_SLASH).concat(CST_CHAR.STR_SLASH)
                            .concat(KeyGenerator.getRndChr(1)));

            String distImageDir = ContextUtil.getRealPath(UPLOAD_ROOT_DIR).concat(imgDir);
            FileUtil.createNoExistsDirs(distImageDir);

            // 新文件名
            String imageName = KeyGenerator.getRndChr(8).concat(CST_CHAR.STR_UNDER_LINE)
                    .concat(Long.toHexString(DateUtil.getCurrMsTime())).concat(CST_CHAR.STR_UNDER_LINE)
                    .concat(Long.toHexString(image.getSize()));
            extName = CST_CHAR.STR_DOT.concat(extName);
            String distImageName = imageName.concat(extName);
            File distImage = new File(distImageDir, distImageName);
            image.transferTo(distImage);

            // 缩图
            if (distImage.exists() && distImage.canRead()) {
                File w1Image = new File(distImageDir, imageName.concat(".150").concat(extName));
                ImageUtil.resize(distImage, w1Image, 150, 0, false);

                File w2Image = new File(distImageDir, imageName.concat(".350").concat(extName));
                ImageUtil.resize(distImage, w2Image, 350, 0, false);
            }

            result = WebContext.getServletContext().getContextPath().concat(UPLOAD_ROOT_DIR).concat(imgDir)
                    .concat(CST_CHAR.STR_SLASH).concat(distImageName);

        } catch (Exception e) {
            log.error("saveImage()", e);
        }
        return getModel(result, null, 0);
    }

    /**
     * 删除单个图片文件
     * 
     * @param imageUrl
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "/image", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteImage(@RequestParam(value = "imageUrl") String imageUrl) throws FileNotFoundException {
        if (StringUtil.isEmpty(imageUrl)) {
            return false;
        }
        imageUrl = StringUtil.replace(imageUrl.trim(), WebContext.getServletContext().getContextPath(),
                CST_CHAR.STR_EMPTY);
        String extName = FileUtil.getFileExt(imageUrl);
        if (StringUtil.startsNotWith(imageUrl, UPLOAD_ROOT_DIR) || imageUrl.contains("..")
                || imageUrl.toLowerCase().contains("web-inf") || imageUrl.toLowerCase().contains("meta-inf")
                || !fileExtNameValidator.checkImageExt(extName)) {
            return false;
        }

        String imagePath = ContextUtil.getRealPath("/").concat(imageUrl);
        File imageFile = new File(imagePath);
        if (imageFile.isDirectory() || !imageFile.exists()) {
            return false;
        }

        String thumbPath = StringUtil.replace(imagePath, extName, CST_CHAR.STR_EMPTY);
        File w1Thumb = new File(thumbPath.concat("150.").concat(extName));
        if (w1Thumb.exists()) {
            FileUtils.deleteQuietly(w1Thumb);
        }

        File w2Thumb = new File(thumbPath.concat("350.").concat(extName));
        if (w2Thumb.exists()) {
            FileUtils.deleteQuietly(w2Thumb);
        }

        return FileUtils.deleteQuietly(imageFile);
    }

    private ModelAndView getModel(String url, String messsge, Integer error) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", url);
        mv.addObject("message", messsge);
        mv.addObject("error", error);
        return mv;
    }
}
