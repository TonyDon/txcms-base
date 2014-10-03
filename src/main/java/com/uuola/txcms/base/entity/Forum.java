/*
 * @(#)Forum.java 2013-11-10
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
 * 论坛版块实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="BBS_FORUM")
public class Forum extends BaseEntity {

    private static final long serialVersionUID = 2609896501623679371L;
    
    @Id
    private Long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="STATUS")
    private Byte status;
    
    @Column(name="DISP_ORDER")
    private Integer dispOrder;
    
    @Column(name="POST_NUM")
    private Integer postNum;
    
    @Column(name="TODAY_POST_NUM")
    private Integer todayPostNum;
    
    @Column(name="LAST_POST_NAME")
    private String lastPostName;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
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

    
    public Integer getPostNum() {
        return postNum;
    }

    
    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    
    public Integer getTodayPostNum() {
        return todayPostNum;
    }

    
    public void setTodayPostNum(Integer todayPostNum) {
        this.todayPostNum = todayPostNum;
    }

    
    public String getLastPostName() {
        return lastPostName;
    }

    
    public void setLastPostName(String lastPostName) {
        this.lastPostName = lastPostName;
    }
    
    

}
