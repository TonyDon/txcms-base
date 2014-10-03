/*
 * @(#)SupReqInfo.java 2013-11-10
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uuola.txweb.framework.dao.support.BaseEntity;


/**
 * <pre>
 * 供求信息实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="SUP_REQ_INFO")
public class SupReqInfo extends BaseEntity {

    private static final long serialVersionUID = 3683215231090332794L;
    
    @Id
    private Long id;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name="CAT_ID")
    private Long catId;
    
    @Column(name="CREATE_TIME")
    private Long createTime;
    
    @Column(name="UPDATE_TIME")
    private Long updateTime;
    
    @Column(name="EXPIRE_TIME")
    private Long expireTime;
    
    @Column(name="USER_ID")
    private Long userId;
    
    @Column(name="VIEW_NUM")
    private Long viewNum;
    
    @Column(name="INFO_TYPE")
    private Byte infoType;
    
    @Column(name="CONTACT_TEL")
    private String contactTel;
    
    @Column(name="CONTACT_MAIL")
    private String contactMail;
    
    @Column(name="CONTACT_ADDR")
    private String contactAddr;
    
    @Column(name="CONTACT_QQ")
    private String contactQq;
    
    @Column(name="CONTACT_WEBSITE")
    private String contactWebsite;
    
    @Column(name="CONTACT_NAME")
    private String contactName;
    
    @Column(name="ORG_NAME")
    private String orgName;
    
    @Column(name="INFO_TAG")
    private String infoTag;
    
    @Column(name="MESSAGE")
    private String message;
    
    @Column(name="PUBLISH_TYPE")
    private Byte publishType;
    
    @Column(name="HAS_IMAGE")
    private Byte hasImage;
    
    @Column(name="HAS_VIDEO")
    private Byte hasVideo;
    
    @Column(name="IMAGE_URLS")
    private String imageUrls;
    
    @Column(name="VIDEO_URL")
    private String videoUrl;
    
    @Column(name="STATUS")
    private Byte status;
    
    @Column(name="DISP_ORDER")
    private Integer dispOrder;
    
    @Column(name="PROVINCE")
    private String province;
    
    @Column(name="CITY")
    private String city;
    
    @Column(name="AREA")
    private String area;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
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
