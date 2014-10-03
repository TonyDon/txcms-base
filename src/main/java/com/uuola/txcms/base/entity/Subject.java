/*
 * @(#)Subject.java 2013-11-10
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
 * 论坛主题实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="BBS_SUBJECT")
public class Subject extends BaseEntity {

    private static final long serialVersionUID = 3248624287088887289L;
    
    @Id
    private Long id;
    
    @Column(name="FORUM_ID")
    private Long forumId;
    
    @Column(name="SUBJECT")
    private String subject;
    
    @Column(name="STATUS")
    private Byte status;
    
    @Column(name="SUBJECT_COLOR")
    private String subjectColor;
    
    @Column(name="AUTHOR_NAME")
    private String authorName;
    
    @Column(name="AUTHOR_ID")
    private Long authorId;
    
    @Column(name="VIEW_NUM")
    private Long viewNum;
    
    @Column(name="POST_NUM")
    private Long postNum;
    
    @Column(name="CREATE_TIME")
    private Long createTime;
    
    @Column(name="UPDATE_TIME")
    private Long updateTime;
    
    @Column(name="LAST_POST_NAME")
    private String lastPostName;
    
    @Column(name="LAST_POST_TIME")
    private Long lastPostTime;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getForumId() {
        return forumId;
    }

    
    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    
    public String getSubject() {
        return subject;
    }

    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    
    public Byte getStatus() {
        return status;
    }

    
    public void setStatus(Byte status) {
        this.status = status;
    }

    
    public String getSubjectColor() {
        return subjectColor;
    }

    
    public void setSubjectColor(String subjectColor) {
        this.subjectColor = subjectColor;
    }

    
    public String getAuthorName() {
        return authorName;
    }

    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    
    public Long getAuthorId() {
        return authorId;
    }

    
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    
    public Long getViewNum() {
        return viewNum;
    }

    
    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    
    public Long getPostNum() {
        return postNum;
    }

    
    public void setPostNum(Long postNum) {
        this.postNum = postNum;
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

    
    public String getLastPostName() {
        return lastPostName;
    }

    
    public void setLastPostName(String lastPostName) {
        this.lastPostName = lastPostName;
    }

    
    public Long getLastPostTime() {
        return lastPostTime;
    }

    
    public void setLastPostTime(Long lastPostTime) {
        this.lastPostTime = lastPostTime;
    }
    

}
