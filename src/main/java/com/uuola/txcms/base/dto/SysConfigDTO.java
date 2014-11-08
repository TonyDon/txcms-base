/*
 * @(#)SysConfigDTO.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dto;

import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
public class SysConfigDTO extends ValidateDTO {

    private static final long serialVersionUID = 3412614511930357809L;

    private Integer id;

    private String name;

    private String sysValue;

    private String sysType;

    private String generalClass;
    
    private Long updateTime;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
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

    
    public void setSysType(String sysType) {
        this.sysType = sysType;
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
