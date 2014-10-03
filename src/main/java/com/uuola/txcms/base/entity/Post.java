/*
 * @(#)Post.java 2013-11-10
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
 * 帖子内容、回帖
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="BBS_POST")
public class Post extends BaseEntity {

    private static final long serialVersionUID = 6508914191774003942L;
    
    @Id
    private Long id;
    
    @Column(name="SUBJECT_ID")
    private Long subjectId;
    
    @Column(name="CONTENT")
    private String content;
    
    @Column(name="IS_FIRST")
    private Byte isFirst;
    
    @Column(name="POST_NAME")
    private String postName;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getSubjectId() {
        return subjectId;
    }

    
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    
    public Byte getIsFirst() {
        return isFirst;
    }

    
    public void setIsFirst(Byte isFirst) {
        this.isFirst = isFirst;
    }

    
    public String getPostName() {
        return postName;
    }

    
    public void setPostName(String postName) {
        this.postName = postName;
    }

}
