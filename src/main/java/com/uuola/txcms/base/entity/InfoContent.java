/*
 * @(#)InfoContent.java 2014-10-28
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
 * 资讯内容实体
 * @author tangxiaodong
 * 创建日期: 2014-10-28
 * </pre>
 */
@Entity
@Table(name="INFO_CONTENT")
public class InfoContent {

    
    @Id
    @Column(name="INFO_ID")
    private Long infoId;
    
    @Column(name="CONTENT")
    private String content;

    
    public Long getInfoId() {
        return infoId;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

}
