/*
 * @(#)StoreFileUtil.java 2016年4月25日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.uuola.txcms.constants.CST_SYSCONFIG_NAME;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年4月25日
 * </pre>
 */
public class StoreFileUtil implements InitializingBean{
    
    private static Logger log = LoggerFactory.getLogger(StoreFileUtil.class);
    
    private static String storeFileDomain = "http://s.986001.com";
    
    public static void load(){
        String domain = ConfigUtil.getTextVal(CST_SYSCONFIG_NAME.SITE_STORE_FILE_DOMAIN);
        if(null != domain){
            storeFileDomain = domain;
        }
        log.warn("-- Store File Domain:"+ storeFileDomain);
    }

    /**
     * 转换URL为全地址
     *  /store/abc.jpg -> http://www.abc.com/store/abc.jpg
     * @param url
     * @return
     */
    public static String parseUrl(String url) {
        if (null != url && url.indexOf("http") != 0 && !url.startsWith(storeFileDomain)) {
            return storeFileDomain + url;
        }
        return url;
    }
    
    /**
     * 移除域名 http://www.abc.com/store/abc.jpg -> /store/abc.jpg
     * @param url
     * @return
     */
    public static String removeDomain(String url){
        if(null != url && url.startsWith(storeFileDomain)){
            return url.substring(storeFileDomain.length());
        }
        return url;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        load();
    }

}
