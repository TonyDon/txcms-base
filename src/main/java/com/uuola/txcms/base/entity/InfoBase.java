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

import com.uuola.txweb.framework.dao.support.BaseEntity;


/**
 * <pre>
 * 资讯基础字段实体
 * @author tangxiaodong
 * 创建日期: 2014-10-28
 * </pre>
 */
@Entity
@Table(name="INFO_BASE")
public class InfoBase extends BaseEntity {

    private static final long serialVersionUID = -817802743423678135L;
    
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
    
    @Column(name ="IS_PIC")
    private Byte isPic;
    
    @Column(name ="IS_VIDEO")
    private Byte isVideo;
    
    @Column(name ="PIC_URL")
    private String picUrl;
    
    @Column(name ="INFO_STATE")
    private Byte infoState;
    
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

}
