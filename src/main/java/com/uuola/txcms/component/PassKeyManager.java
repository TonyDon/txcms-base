/*
 * @(#)PassKeyManager.java 2013-12-7
 * 
 * Copy Right@ uuola
 */

package com.uuola.txcms.component;

import com.uuola.commons.coder.DES;
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
}
