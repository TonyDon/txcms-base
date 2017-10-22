/*
 * @(#)DictConfig.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@Entity
@Table(name="DICT_CONFIG")
public class DictConfig {

    @Id
    private Integer id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DICT_CODE")
    private String dictCode;
    
    @Column(name = "DICT_VALUE")
    private String dictValue;
    
    @Column(name = "REMARK")
    private String remark;
    
    @Column(name = "UPDATE_TIME")
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
