/*
 * @(#)CaptchaValidator.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import com.uuola.commons.StringUtil;


/**
 * <pre>
 * 验证码校验
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
public class CaptchaValidator {
    /**
     * 客户输入CODE 是否与服务端代码匹配<br/>
     * 匹配返回 true
     * @param input
     * @return
     */
    public static boolean isMatch(String input){
        String serverCode = SessionUtil.getValidCode();
        if(StringUtil.isEmpty(serverCode) || StringUtil.isEmpty(input)){
            return false;
        }
        return serverCode.equalsIgnoreCase(input);
    }
    
    public static boolean notMatch(String input){
        return !CaptchaValidator.isMatch(input);
    }
}
