/*
 * @(#)PassKeyManager.java 2013-12-7
 * 
 * Copy Right@ uuola
 */

package com.uuola.txcms.component;

import com.uuola.commons.coder.DES;
import com.uuola.commons.coder.SHA;
import com.uuola.commons.constant.CST_CHAR;
import com.uuola.txcms.constants.CST_HASH_PASS;

/**
 * <pre>
 * 密码管理器
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
public class PassKeyManager {


    public static String encrypt(String input) {
        return DES.encrypt(input, CST_HASH_PASS.USER_PASS_KEY);
    }
    
    public static String decrypt(String input){
        return DES.decrypt(input, CST_HASH_PASS.USER_PASS_KEY);
    }
    
    /**
     * 验证客户端HASH KEY 用于登录信息验证,与common.js配套使用
     * @param passkey
     * @param captcha
     * @param hashkey
     * @return
     */
    public static boolean verifyUserHashKey(String passkey, String captcha, String hashkey){
        if(null == hashkey || null == passkey || null == captcha){
            return false;
        }
        String orgPasskey = decrypt(passkey);
        String serverHashKey = SHA.encode(orgPasskey.concat(CST_CHAR.STR_AT).concat(captcha));
        return serverHashKey.equals(hashkey);
    }
}
