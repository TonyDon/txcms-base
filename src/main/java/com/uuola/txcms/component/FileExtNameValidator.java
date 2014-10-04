/*
 * @(#)UploadFileExtConfig.java 2013-12-15
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uuola.commons.StringUtil;


/**
 * <pre>
 * 文件扩展名检查
 * @author tangxiaodong
 * 创建日期: 2013-12-15
 * </pre>
 */
public class FileExtNameValidator {
    
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 图片文件名扩展: |jpg|png|gif|jpeg|
     */
    private String imageExtNames;
    
    /**
     * 通用文件名：|jpg|png|gif|jpeg|doc|docx|xls|xlsx|ppt|pptx|flv|mp4|txt|zip|7z|rar|
     */
    private String commonExtNames;
    
    public FileExtNameValidator(){
        
    }
    
    public String getImageExtNames() {
        return imageExtNames;
    }

    
    public void setImageExtNames(String imageExtNames) {
        this.imageExtNames = imageExtNames;
    }

    
    public String getCommonExtNames() {
        return commonExtNames;
    }

    
    public void setCommonExtNames(String commonExtNames) {
        this.commonExtNames = commonExtNames;
    }

    /**
     * 校验扩展是否合法, 通过返回true
     * @param inputExtName
     * @return
     */
    public boolean checkImageExt(String inputExtName){
        return validate(inputExtName, imageExtNames);
    }
    
    public boolean validate(String inputExtName, String extNames) {
        if (StringUtil.isEmpty(inputExtName)) {
            return false;
        }
        
        if (StringUtil.isNotEmpty(extNames)) {
            return extNames.contains(inputExtName.toLowerCase());
        }
        
        log.error("FileExtNameValidator properties[imageExtNames or commonExtNames] don't be confg!");
        return false;
    }

}
