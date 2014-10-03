/*
 * @(#)RoleCfg.java 2013-11-10
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
 * 角色配置实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="ROLE_CFG")
public class RoleCfg extends BaseEntity {

    private static final long serialVersionUID = 5803370269545883232L;
    
    @Id
    private Long id;
    
    @Column(name="FUNC_KEYS")
    private String funcKeys;
    
    @Column(name="REMARK")
    private String remark;
    
    @Column(name="STATUS")
    private Byte status;
    
    @Column(name="CREATE_TIME")
    private Long createTime;
    
    @Column(name="UPDATE_TIME")
    private Long updateTime;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getFuncKeys() {
        return funcKeys;
    }

    
    public void setFuncKeys(String funcKeys) {
        this.funcKeys = funcKeys;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    public Byte getStatus() {
        return status;
    }

    
    public void setStatus(Byte status) {
        this.status = status;
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
    
    
}
