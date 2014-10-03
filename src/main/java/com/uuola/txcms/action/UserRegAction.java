/*
 * @(#)UserRegAction.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uuola.txcms.base.dto.UserInfoDTO;
import com.uuola.txcms.base.service.UserRegService;
import com.uuola.txcms.component.CaptchaValidator;
import com.uuola.txcms.constants.CST_ERROR_MSG;
import com.uuola.txweb.framework.action.BaseAction;


/**
 * <pre>
 * 用户注册
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
@Controller
@RequestMapping("/user/reg")
public class UserRegAction extends BaseAction{
    
    @Autowired
    private UserRegService userRegService;

    /**
     * 前台 ajax提交注册信息
     * @param userInfoDTO
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public void regist(UserInfoDTO userInfoDTO, @ModelAttribute(ERRORS_ATTR)
    ArrayList<String> errors) {
        // 基础校验没有通过 或者 验证码不匹配，返回异常信息
        if (CaptchaValidator.notMatch(userInfoDTO.getCaptcha())) {
            errors.add(CST_ERROR_MSG.CAPTCHA_ERROR);
        } else if (userInfoDTO.notValidPass()) {
            errors.addAll(getErrors(userInfoDTO));
        } else {
            // 保存用户基本信息
            userRegService.saveNewUserInfo(userInfoDTO);
        }
        // 重置属性为null
        userInfoDTO.reset();
    }
}
