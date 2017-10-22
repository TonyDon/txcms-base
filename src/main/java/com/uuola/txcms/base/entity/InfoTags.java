/*
 * @(#)InfoTags.java 2014-10-28
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
 * 资讯标签实体
 * @author tangxiaodong
 * 创建日期: 2014-10-28
 * </pre>
 */
@Entity
@Table(name = "INFO_TAGS")
public class InfoTags {


    @Id
    private Long id;
    
    @Column(name="TAG_NAME")
    private String tagName;
    
    @Column(name="INFO_NUM")
    private Integer infoNum;
    
    @Column(name="CREATE_TIME")
    private Long createTime;
    
    @Column(name="UPDATE_TIME")
    private Long updateTime;
    
    @Column(name="TAG_STATE")
    private Byte tagState;

    
    public Long getId() {
        return id;
    }

    
    public String getTagName() {
        return tagName;
    }

    
    public Integer getInfoNum() {
        return infoNum;
    }

    
    public Long getCreateTime() {
        return createTime;
    }

    
    public Long getUpdateTime() {
        return updateTime;
    }

    
    public Byte getTagState() {
        return tagState;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    
    public void setInfoNum(Integer infoNum) {
        this.infoNum = infoNum;
    }

    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    
    public void setTagState(Byte tagState) {
        this.tagState = tagState;
    }
    
}
