/*
 * @(#)VerifyAction.java 2015年7月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uuola.txcms.base.dict.ADMIN_FLAG;
import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txcms.base.service.UserInfoService;
import com.uuola.txcms.component.CaptchaValidator;
import com.uuola.txcms.component.PassKeyManager;
import com.uuola.txcms.component.SessionUtil;
import com.uuola.txcms.constants.CST_ERROR_MSG;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.IConstant;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2015年7月12日
 * </pre>
 */
@Controller
@RequestMapping("/manager/verify")
public class VerifyAction extends BaseAction{
    
    @Autowired
    private UserInfoService userInfoService;
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return this.getViewName("login");
    }
    
    @RequestMapping(value="/check", method = RequestMethod.POST)
    public void check(
            @RequestParam(value="name") String name,
            @RequestParam(value="hashkey") String hashkey,
            @RequestParam(value="captcha") String captcha,
            @ModelAttribute(IConstant.VALID_ERRORS_ATTR) ArrayList<String> errors){
        
        if (CaptchaValidator.notMatch(captcha)) {
            errors.add(CST_ERROR_MSG.CAPTCHA_ERROR);
        }else{
            UserInfoQuery query = new UserInfoQuery();
            query.setName(name);
            query.setAdminFlag(ADMIN_FLAG.ADMIN.val());
            UserInfo user = userInfoService.fetchSingle(query);
            if(null == user){
                errors.add(CST_ERROR_MSG.VERIFY_USER_NOT_EXIST);
            }else if(!PassKeyManager.verifyUserHashKey(user.getPassKey(), captcha, hashkey)){
                errors.add(CST_ERROR_MSG.VERIFY_USER_CHECK_FAIL);
            }else{
                // 验证通过 设置管理员对象到回话
                SessionUtil.setAdmin(user);
            }
        }
        
    }

}
