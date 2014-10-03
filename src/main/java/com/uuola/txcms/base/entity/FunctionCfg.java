/*
 * @(#)FunctionCfg.java 2013-11-10
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
 * 功能配置实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="FUNCTION_CFG")
public class FunctionCfg extends BaseEntity {
 
    private static final long serialVersionUID = 967150766418340909L;
    
    @Id
    private Long id;
    
    @Column(name ="NAME")
    private String name;
    
    @Column(name ="FUNC_VAL")
    private String funcVal;
    
    @Column(name="FUNC_URL")
    private String funcUrl;
    
    @Column(name ="REMARK")
    private String remark;
    
    @Column(name ="CREATE_TIME")
    private Long createTime;
    
    @Column(name="UPDATE_TIME")
    private Long updateTime;

    
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

    
    public String getFuncVal() {
        return funcVal;
    }

    
    public void setFuncVal(String funcVal) {
        this.funcVal = funcVal;
    }

    
    public String getFuncUrl() {
        return funcUrl;
    }

    
    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
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
