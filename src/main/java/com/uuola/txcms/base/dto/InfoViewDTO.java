/*
 * @(#)LatestInfoDTO.java 2016年3月15日
 * 
 * Copy Right@ uuola
 */ 
package com.uuola.txcms.base.dto;

import com.uuola.txcms.base.dict.TRUE_OR_FALSE;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年3月15日
 * </pre>
 */
public class InfoViewDTO {
    
    private Long id;
    
    private Long catId;
    
    private String title;
    
    private String summary;
    
    private Long authorId;
    
    private Long createTime;
    
    private Long updateTime;
    
    private Long lastOperatorId;
    
    private Byte infoType;
    
    private Byte hasPic;
    
    private Byte hasVideo;
    
    private String picUrl;
    
    private String videoUrl;
    
    private String siteUrl;
    
    private Byte infoState;
    
    private Long viewNum;
    
    private Long loveNum;
    
    private Long hateNum;
    
    private Byte isDelete;
    
    private Byte hasContent = TRUE_OR_FALSE.F.value(); //默认没有正文

    
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

    
    public Byte getHasContent() {
        return hasContent;
    }

    
    public void setHasContent(Byte hasContent) {
        this.hasContent = hasContent;
    }
}
