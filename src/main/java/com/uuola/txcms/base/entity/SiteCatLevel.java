/*
 * @(#)SiteCatLevel.java 2013-11-10
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
 *
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="SITE_CAT_LEVEL")
public class SiteCatLevel extends BaseEntity {
 
    private static final long serialVersionUID = -1624286616410882306L;

    @Id
    private Long id;
    
    @Column(name="CAT_ID")
    private Long catId;
    
    @Column(name="C1")
    private Long c1;
    
    @Column(name="C2")
    private Long c2;
    
    @Column(name="C3")
    private Long c3;
    
    @Column(name ="C4")
    private Long c4;

    
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

    
    public Long getC1() {
        return c1;
    }

    
    public void setC1(Long c1) {
        this.c1 = c1;
    }

    
    public Long getC2() {
        return c2;
    }

    
    public void setC2(Long c2) {
        this.c2 = c2;
    }

    
    public Long getC3() {
        return c3;
    }

    
    public void setC3(Long c3) {
        this.c3 = c3;
    }

    
    public Long getC4() {
        return c4;
    }

    
    public void setC4(Long c4) {
        this.c4 = c4;
    }
}
