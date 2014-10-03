/*
 * @(#)UserRegService.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import com.uuola.txcms.base.dto.UserInfoDTO;


/**
 * <pre>
 * 会员注册服务类
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
public interface UserRegService {

    /**
     * 验证用户输入的移动号码是否被使用过<br/>
     * 被使用过返回false, 未使用true
     * @param tel
     * @return
     */
    public boolean validateTel(String tel);
    
    
    public boolean saveNewUserInfo(UserInfoDTO userInfoDTO);
}
