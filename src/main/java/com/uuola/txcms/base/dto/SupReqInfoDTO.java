/*
 * @(#)SupReqInfoDTO.java 2013-12-15
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dto;

import javax.validation.constraints.NotNull;

import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 * 供求信息DTO
 * @author tangxiaodong
 * 创建日期: 2013-12-15
 * </pre>
 */
public class SupReqInfoDTO extends ValidateDTO {

    private static final long serialVersionUID = -5198705218482844267L;

    @NotNull
    private String title;

    @NotNull
    private Long catId;

    private Long createTime;

    private Long updateTime;

    private Long expireTime;

    private Long userId;

    private Long viewNum;

    private Byte infoType;

    @NotNull
    private String contactTel;

    private String contactMail;

    private String contactAddr;

    private String contactQq;

    private String contactWebsite;

    @NotNull
    private String contactName;

    private String orgName;

    private String infoTag;

    @NotNull
    private String message;

    private Byte publishType;

    private Byte hasImage;
 
    private Byte hasVideo;

    private String imageUrls;

    private String videoUrl;

    private Byte status;

    private Integer dispOrder;

    @NotNull
    private String province;

    private String city;

    private String area;

    
    
    @NotNull
    private String captcha;

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public Long getCatId() {
        return catId;
    }

    
    public void setCatId(Long catId) {
        this.catId = catId;
    }

    
    public Long getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    
    public Long getUpdateTime() {
        return updateTime;
    }

    
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    
    public Long getExpireTime() {
        return expireTime;
    }

    
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    
    public Long getUserId() {
        return userId;
    }

    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public Long getViewNum() {
        return viewNum;
    }

    
    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    
    public Byte getInfoType() {
        return infoType;
    }

    
    public void setInfoType(Byte infoType) {
        this.infoType = infoType;
    }

    
    public String getContactTel() {
        return contactTel;
    }

    
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    
    public String getContactMail() {
        return contactMail;
    }

    
    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    
    public String getContactAddr() {
        return contactAddr;
    }

    
    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr;
    }

    
    public String getContactQq() {
        return contactQq;
    }

    
    public void setContactQq(String contactQq) {
        this.contactQq = contactQq;
    }

    
    public String getContactWebsite() {
        return contactWebsite;
    }

    
    public void setContactWebsite(String contactWebsite) {
        this.contactWebsite = contactWebsite;
    }

    
    public String getContactName() {
        return contactName;
    }

    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    
    public String getOrgName() {
        return orgName;
    }

    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    
    public String getInfoTag() {
        return infoTag;
    }

    
    public void setInfoTag(String infoTag) {
        this.infoTag = infoTag;
    }

    
    public String getMessage() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }

    
    public Byte getPublishType() {
        return publishType;
    }

    
    public void setPublishType(Byte publishType) {
        this.publishType = publishType;
    }

    
    public Byte getHasImage() {
        return hasImage;
    }

    
    public void setHasImage(Byte hasImage) {
        this.hasImage = hasImage;
    }

    
    public Byte getHasVideo() {
        return hasVideo;
    }

    
    public void setHasVideo(Byte hasVideo) {
        this.hasVideo = hasVideo;
    }

    
    public String getImageUrls() {
        return imageUrls;
    }

    
    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    
    public String getVideoUrl() {
        return videoUrl;
    }

    
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    
    public Byte getStatus() {
        return status;
    }

    
    public void setStatus(Byte status) {
        this.status = status;
    }

    
    public Integer getDispOrder() {
        return dispOrder;
    }

    
    public void setDispOrder(Integer dispOrder) {
        this.dispOrder = dispOrder;
    }
    
    public String getCaptcha() {
        return captcha;
    }


    
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }


    
    public String getProvince() {
        return province;
    }


    
    public void setProvince(String province) {
        this.province = province;
    }


    
    public String getCity() {
        return city;
    }


    
    public void setCity(String city) {
        this.city = city;
    }


    
    public String getArea() {
        return area;
    }


    
    public void setArea(String area) {
        this.area = area;
    }
}
