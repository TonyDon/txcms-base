/*
 * @(#)VersionUtil.java 2016年4月16日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.uuola.commons.DateUtil;
import com.uuola.commons.constant.CST_DATE_FORMAT;
import com.uuola.txcms.constants.CST_SYSCONFIG_NAME;


/**
 * <pre>
 * 版本工具类
 * @author tangxiaodong
 * 创建日期: 2016年4月16日
 * </pre>
 */
public class VersionUtil implements InitializingBean {
    
    private static Logger log = LoggerFactory.getLogger(VersionUtil.class);
    
    private static String systemVersion ;

    /**
     * 资源文件版本
     */
    private static String sourceVersion ;
    
    private static String startupTime;
    
    /**
     * 加载所有类目信息
     */
    public static void load(){
        systemVersion = "TxCMS v1.0";
        sourceVersion = Long.toHexString(System.currentTimeMillis()) ;
        String srcVer = ConfigUtil.getTextVal(CST_SYSCONFIG_NAME.SITE_RESOURCE_VERSION);
        String sysVer = ConfigUtil.getTextVal(CST_SYSCONFIG_NAME.SITE_SYSTEM_VERSION);
        if(null != srcVer){
            sourceVersion = srcVer;
        }
        if(null != sysVer){
            systemVersion = sysVer;
        }
        log.warn("-- SystemVer:"+systemVersion+ " sourceVer:" + sourceVersion + " time:" + startupTime);
    }
    
    public static void setStartupTime(){
        startupTime = DateUtil.formatDate(new Date(), CST_DATE_FORMAT.YYYYMMDDHHMMSSSSS);
    }
    
    public static String getSrcVer(){
        return sourceVersion;
    }
    
    public static String getSysVer(){
        return systemVersion;
    }
    
    public static String getStartupTime(){
        return startupTime;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        setStartupTime();
        load();
    }

}
