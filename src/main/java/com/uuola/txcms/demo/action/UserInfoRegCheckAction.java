/*
 * @(#)UserInfoRegCheckAction.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uuola.commons.StringUtil;
import com.uuola.commons.constant.CST_REGEX;
import com.uuola.txcms.base.service.UserRegService;


/**
 * <pre>
 * 用户注册信息 手机号，邮箱，昵称信息校验
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
@Controller
@RequestMapping("/userInfoRegCheck")
public class UserInfoRegCheckAction {
    
    @Autowired
    private UserRegService userRegService;

    @RequestMapping(value="/tel", params={"regTel"})
    @ResponseBody
    public boolean validateTel(@RequestParam("regTel") String tel){
        if(StringUtil.isEmpty(tel) || !CST_REGEX.RE_TEL.matcher(tel).matches()){
            return false;
        }
        return userRegService.validateTel(tel);
    }
    
}
