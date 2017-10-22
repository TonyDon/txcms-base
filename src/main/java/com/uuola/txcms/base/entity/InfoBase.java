/*
 * @(#)InfoBase.java 2014-10-28
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * <pre>
 * 资讯基础字段实体
 * @author tangxiaodong
 * 创建日期: 2014-10-28
 * </pre>
 */
@Entity
@Table(name="INFO_BASE")
public class InfoBase{
 
    @Id
    private Long id;
    
    @Column(name ="CAT_ID")
    private Long catId;
    
    @Column(name ="TITLE")
    private String title;
    
    @Column(name = "SUMMARY")
    private String summary;
    
    @Column(name ="AUTHOR_ID")
    private Long authorId;
    
    @Column(name ="CREATE_TIME")
    private Long createTime;
    
    @Column(name ="UPDATE_TIME")
    private Long updateTime;
    
    @Column(name ="LAST_OPERATOR_ID")
    private Long lastOperatorId;
    
    @Column(name ="INFO_TYPE")
    private Byte infoType;
    
    @Column(name ="HAS_PIC")
    private Byte hasPic;
    
    @Column(name ="HAS_VIDEO")
    private Byte hasVideo;
    
    @Column(name ="PIC_URL")
    private String picUrl;
    
    @Column(name ="VIDEO_URL")
    private String videoUrl;
    
    @Column(name ="SITE_URL")
    private String siteUrl;
    
    @Column(name ="INFO_STATE")
    private Byte infoState;
    
    @Column(name ="VIEW_NUM")
    private Long viewNum;
    
    @Column(name ="LOVE_NUM")
    private Long loveNum;
    
    @Column(name ="HATE_NUM")
    private Long hateNum;
    
    @Column(name ="IS_DELETE")
    private Byte isDelete;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getCatId() {
        return catId;
    }

    
    public void setCatId(Long catId) {
        this.catId = catId;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    
    public String getSummary() {
        return summary;
    }


    
    public void setSummary(String summary) {
        this.summary = summary;
    }


    public Long getAuthorId() {
        return authorId;
    }

    
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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

    
    public Long getLastOperatorId() {
        return lastOperatorId;
    }

    
    public void setLastOperatorId(Long lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    
    public Byte getInfoType() {
        return infoType;
    }

    
    public void setInfoType(Byte infoType) {
        this.infoType = infoType;
    }

    
    
    public Byte getHasPic() {
        return hasPic;
    }


    
    public void setHasPic(Byte hasPic) {
        this.hasPic = hasPic;
    }


    
    public Byte getHasVideo() {
        return hasVideo;
    }


    
    public void setHasVideo(Byte hasVideo) {
        this.hasVideo = hasVideo;
    }


    public String getPicUrl() {
        return picUrl;
    }

    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    
    public String getVideoUrl() {
        return videoUrl;
    }


    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


    public String getSiteUrl() {
        return siteUrl;
    }


    
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }


    public Byte getInfoState() {
        return infoState;
    }

    
    public void setInfoState(Byte infoState) {
        this.infoState = infoState;
    }

    
    public Long getViewNum() {
        return viewNum;
    }


    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }


    
    public Long getLoveNum() {
        return loveNum;
    }


    
    public void setLoveNum(Long loveNum) {
        this.loveNum = loveNum;
    }


    
    public Long getHateNum() {
        return hateNum;
    }


    
    public void setHateNum(Long hateNum) {
        this.hateNum = hateNum;
    }


    public Byte getIsDelete() {
        return isDelete;
    }

    
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

}
