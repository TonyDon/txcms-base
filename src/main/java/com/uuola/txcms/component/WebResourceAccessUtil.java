/*
 * @(#)WebResourceAccessUtil.java 2016年1月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年1月3日
 * </pre>
 */
public abstract class WebResourceAccessUtil {
    
    public final static String URL_HASH_PARAM_NAME = "frwahash";

    public static String makeHash(){
        return "bcbe3365e6ac95ea2c0343a2395834dd";
    }
    
    public static boolean checkHash(String hash){
        return "bcbe3365e6ac95ea2c0343a2395834dd".equals(hash);
    }
}
