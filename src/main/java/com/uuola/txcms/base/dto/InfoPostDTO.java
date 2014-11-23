/*
 * @(#)InfoPostDTO.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dto;

import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月23日
 * </pre>
 */
public class InfoPostDTO extends ValidateDTO {

    private static final long serialVersionUID = 7924224533970221972L;

    private Long id;
    
    private Long catId;
    
    private String title;
    
    private String summary;
    
    private Long authorId;
    
    private Long createTime;
    
    private Long updateTime;
    
    private Long lastOperatorId;
    
    private Byte infoType;
    
    private Byte isPic;
    
    private Byte isVideo;
    
    private String picUrl;
    
    private Byte infoState;
    
    private Byte isDelete;
    
    private String content;

    
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

    
    public Byte getIsPic() {
        return isPic;
    }

    
    public void setIsPic(Byte isPic) {
        this.isPic = isPic;
    }

    
    public Byte getIsVideo() {
        return isVideo;
    }

    
    public void setIsVideo(Byte isVideo) {
        this.isVideo = isVideo;
    }

    
    public String getPicUrl() {
        return picUrl;
    }

    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    
    public Byte getInfoState() {
        return infoState;
    }

    
    public void setInfoState(Byte infoState) {
        this.infoState = infoState;
    }

    
    public Byte getIsDelete() {
        return isDelete;
    }

    
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }
    
}