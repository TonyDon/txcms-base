/*
 * @(#)InfoTagRelation.java 2014-10-28
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-28
 * </pre>
 */
@Entity
@Table(name = "INFO_TAG_RELATION")
public class InfoTagRelation  {
    
    @Column(name = "TAG_ID")
    private Long tagId;
    
    @Column(name = "INFO_ID")
    private Long infoId;
    
    @Column(name = "CREATE_TIME")
    private Long createTime;

    
    public Long getTagId() {
        return tagId;
    }

    
    public Long getInfoId() {
        return infoId;
    }

    
    public Long getCreateTime() {
        return createTime;
    }

    
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    
    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    

}
