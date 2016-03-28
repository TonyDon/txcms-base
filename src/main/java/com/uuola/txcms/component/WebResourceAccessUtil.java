/*
 * @(#)WebResourceAccessUtil.java 2016年1月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import com.uuola.txcms.constants.CST_SYSCONFIG_NAME;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年1月3日
 * </pre>
 */
public abstract class WebResourceAccessUtil {
    
    public final static String URL_HASH_PARAM_NAME = "frwahash";
    
    private static String token = "" ;

    public static String makeHash(){
        if(null == token || token.isEmpty()){
            token = ConfigUtil.getTextVal(CST_SYSCONFIG_NAME.SITE_WEB_RESOURCE_ACCESS_TOKEN);
        }
        return token;
    }
    
    public static boolean checkHash(String hash){
        return token.equals(hash);
    }
    
    public synchronized static void refresh(){
        token = ConfigUtil.getTextVal(CST_SYSCONFIG_NAME.SITE_WEB_RESOURCE_ACCESS_TOKEN);
    }
}
