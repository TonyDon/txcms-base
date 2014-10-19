/*
 * @(#)SiteCatDTO.java 2014-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-19
 * </pre>
 */
public class SiteCatDTO extends ValidateDTO {

    private static final long serialVersionUID = -5277080114095979660L;;
    
    @NotEmpty
    @Length(min=2, max=16)
    private String name;
    
    @NotNull
    private Long rid;
    
    private Integer dispOrder;
    
    private Byte status;
    
    private Integer siteType;

    
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

    
    public Integer getSiteType() {
        return siteType;
    }

    
    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

}
