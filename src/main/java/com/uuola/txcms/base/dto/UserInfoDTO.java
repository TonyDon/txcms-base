/*
 * @(#)UserInfoDTO.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
public class UserInfoDTO extends ValidateDTO {

    private static final long serialVersionUID = 4524010793324910268L;
    
    private String name;

    @NotNull
    private String tel;
    
    @NotNull
    private String passKey;
    
    private String email;
    
    private Long createTime;
    
    @NotEmpty
    private String captcha;

    
    
    public String getName() {
        return name;
    }


    
    public void setName(String name) {
        this.name = name;
    }


    public String getTel() {
        return tel;
    }

    
    public void setTel(String tel) {
        this.tel = tel;
    }

    
    public String getPassKey() {
        return passKey;
    }

    
    
    public String getEmail() {
        return email;
    }



    
    public void setEmail(String email) {
        this.email = email;
    }



    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    
    public Long getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }


    
    public String getCaptcha() {
        return captcha;
    }


    
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
    
    public void reset(){
        this.tel = null;
        this.passKey = null;
    }
    
}
