/*
 * @(#)UserRole.java 2013-11-10
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
 * 用户角色实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="USER_ROLE")
public class UserRole {
 
    
    @Id
    private Long id;
    
    @Column(name="USER_ID")
    private Long userId;
    
    @Column(name="ROLE_ID")
    private Long roleId;
    
    @Column(name ="CREATE_TIME")
    private Long createTime;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getUserId() {
        return userId;
    }

    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public Long getRoleId() {
        return roleId;
    }

    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    
    public Long getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
