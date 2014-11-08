/*
 * @(#)DictConfigDTO.java 2014-11-8
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
public class DictConfigDTO extends ValidateDTO {
 
    private static final long serialVersionUID = -3789908383199625052L;

    private Integer id;
    
    private String name;
    
    private String dictCode;
    
    private String dictValue;
    
    private String remark;
    
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

    
    public String getDictCode() {
        return dictCode;
    }

    
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    
    public String getDictValue() {
        return dictValue;
    }

    
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    public Long getUpdateTime() {
        return updateTime;
    }

    
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
