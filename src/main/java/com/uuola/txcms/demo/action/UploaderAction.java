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

import com.uuola.commons.DateUtil;
import com.uuola.commons.StringUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.constant.CST_CHAR;
import com.uuola.commons.constant.CST_DATE_FORMAT;
import com.uuola.commons.file.FileUtil;
import com.uuola.commons.image.ImageUtil;
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
     * @param imageFile
     * @return
     */
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @ResponseBody
    public String saveImage(@RequestParam(value = "imageFile")
    MultipartFile imageFile) {
        if(null == imageFile || imageFile.getSize() == 0){
            return CST_ERROR_MSG.UPLOAD_FILE_SIZE_EMPTY;
        }
        String result = CST_CHAR.STR_EMPTY;
        String extName = FileUtil.getFileExt(imageFile.getOriginalFilename());
        if (!fileExtNameValidator.checkImageExt(extName)) {
            return CST_ERROR_MSG.IMAGE_EXT_NAME_INVALID;
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
            String distImageName = KeyGenerator.getRndChr(8).concat(CST_CHAR.STR_UNDER_LINE)
                    .concat(Long.toHexString(DateUtil.getCurrMsTime())).concat(CST_CHAR.STR_UNDER_LINE)
                    .concat(Long.toHexString(imageFile.getSize())).concat(CST_CHAR.STR_DOT).concat(extName);

            File distImage = new File(distImageDir, distImageName);
            imageFile.transferTo(distImage);

            // 缩图
            if (distImage.exists() && distImage.canRead()) {
                File w1Image = new File(distImageDir, distImageName.concat(".w1.thumb"));
                ImageUtil.resize(distImage, w1Image, 150, 0, false);

                File w2Image = new File(distImageDir, distImageName.concat(".w2.thumb"));
                ImageUtil.resize(distImage, w2Image, 350, 0, false);
            }

            result = UPLOAD_ROOT_DIR.concat(imgDir).concat("/").concat(distImageName);
        } catch (Exception e) {
            log.error("saveImage()", e);
        }
        return result;
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
    public boolean deleteImage(@RequestParam(value = "imageUrl")
    String imageUrl) throws FileNotFoundException {
        if (StringUtil.isEmpty(imageUrl)) {
            return false;
        }
        String lowerImageUrl = imageUrl.toLowerCase();
        String imageExtName = FileUtil.getFileExt(lowerImageUrl);
        if (StringUtil.startsNotWith(lowerImageUrl, UPLOAD_ROOT_DIR) || lowerImageUrl.contains("..")
                || lowerImageUrl.contains("web-inf") || lowerImageUrl.contains("meta-inf")
                || !fileExtNameValidator.checkImageExt(imageExtName)) {
            return false;
        }
        String imagePath = ContextUtil.getRealPath("/").concat(imageUrl.trim());
        File imageFile = new File(imagePath);
        if (imageFile.isDirectory()) {
            return false;
        }

        File w1Thumb = new File(imagePath.concat(".w1.thumb"));
        FileUtils.deleteQuietly(w1Thumb);

        File w2Thumb = new File(imagePath.concat(".w2.thumb"));
        FileUtils.deleteQuietly(w2Thumb);

        return FileUtils.deleteQuietly(imageFile);
    }
}