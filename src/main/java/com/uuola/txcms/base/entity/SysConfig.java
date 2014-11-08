/*
 * @(#)SysConfig.java 2014-10-28
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
 * 系统配置实体
 * @author tangxiaodong
 * 创建日期: 2014-10-28
 * </pre>
 */
@Entity
@Table(name="SYS_CONFIG")
public class SysConfig extends BaseEntity {

    private static final long serialVersionUID = -4092219936498753594L;
    
    @Id
    private Long id;
    
    @Column(name ="NAME")
    private String name;
    
    @Column(name ="SYS_VALUE")
    private String sysValue;
    
    @Column(name ="SYS_TYPE")
    private String sysType;
    
    @Column(name ="GENERAL_CLASS")
    private String generalClass;
    
    @Column(name ="UPDATE_TIME")
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

    
    public String getSysValue() {
        return sysValue;
    }

    
    public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

    
    public String getSysType() {
        return sysType;
    }

    
    public void setSysType(String sysValue) {
        this.sysType = sysValue;
    }

    
    public String getGeneralClass() {
        return generalClass;
    }

    
    public void setGeneralClass(String generalClass) {
        this.generalClass = generalClass;
    }

    
    public Long getUpdateTime() {
        return updateTime;
    }

    
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    

}
