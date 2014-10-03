/*
 * @(#)SiteCat.java 2013-11-10
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
@Table(name="SITE_CAT")
public class SiteCat extends BaseEntity {

    private static final long serialVersionUID = -7674007159049580729L;
    
    @Id
    private Long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name ="RID")
    private Long rid;
    
    @Column(name ="CAT_PATH")
    private String catPath;
    
    @Column(name="DISP_ORDER")
    private Integer dispOrder;
    
    @Column(name ="STATUS")
    private Byte status;
    
    @Column(name ="NODE_NUM")
    private Integer nodeNum;
    
    @Column(name ="site_type")
    private Integer siteType;

    
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

    
    public Long getRid() {
        return rid;
    }

    
    public void setRid(Long rid) {
        this.rid = rid;
    }

    
    public String getCatPath() {
        return catPath;
    }

    
    public void setCatPath(String catPath) {
        this.catPath = catPath;
    }

    
    public Integer getDispOrder() {
        return dispOrder;
    }

    
    public void setDispOrder(Integer dispOrder) {
        this.dispOrder = dispOrder;
    }

    
    public Byte getStatus() {
        return status;
    }

    
    public void setStatus(Byte status) {
        this.status = status;
    }

    
    public Integer getNodeNum() {
        return nodeNum;
    }

    
    public void setNodeNum(Integer nodeNum) {
        this.nodeNum = nodeNum;
    }

    
    public Integer getSiteType() {
        return siteType;
    }

    
    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

}
