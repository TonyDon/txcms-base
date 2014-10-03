/*
 * @(#)UserInfo.java 2013-11-10
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
 * 用户信息实体
 * @author tangxiaodong
 * 创建日期: 2013-11-10
 * </pre>
 */
@Entity
@Table(name="USER_INFO")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = -7337248999109815767L;

    @Id
    private Long id;
    
    @Column(name ="NAME")
    private String name;
    
    @Column(name ="PASS_KEY")
    private String passKey;
    
    @Column(name ="TEL")
    private String tel;
    
    @Column(name = "QQ")
    private String qq;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name ="GENDER")
    private Byte gender;
    
    @Column(name ="CREATE_TIME")
    private Long createTime;
    
    @Column(name ="UPATE_TIME")
    private Long updateTime;
    
    @Column(name = "CITY_CODE")
    private String cityCode;
    
    @Column(name ="STATUS")
    private Byte status;
    
    @Column(name ="ADMIN_FLAG")
    private Byte adminFlag;

    
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

    
    public String getPassKey() {
        return passKey;
    }

    
    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    
    public String getTel() {
        return tel;
    }

    
    public void setTel(String tel) {
        this.tel = tel;
    }

    
    public String getQq() {
        return qq;
    }

    
    public void setQq(String qq) {
        this.qq = qq;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public Byte getGender() {
        return gender;
    }

    
    public void setGender(Byte gender) {
        this.gender = gender;
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

    
    public String getCityCode() {
        return cityCode;
    }

    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    
    public Byte getStatus() {
        return status;
    }

    
    public void setStatus(Byte status) {
        this.status = status;
    }

    
    public Byte getAdminFlag() {
        return adminFlag;
    }

    
    public void setAdminFlag(Byte adminFlag) {
        this.adminFlag = adminFlag;
    }
    
    
}
