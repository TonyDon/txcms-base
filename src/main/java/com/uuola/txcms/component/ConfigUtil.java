/*
 * @(#)ConfigUtil.java 2016年3月27日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.uuola.commons.JsonUtil;
import com.uuola.commons.exception.Assert;
import com.uuola.txcms.base.dict.SYS_CONFIG_TYPE;
import com.uuola.txcms.base.entity.SysConfig;
import com.uuola.txcms.base.service.SysConfigService;
import com.uuola.txweb.framework.utils.ContextUtil;

/**
 * <pre>
 * 配置参数工具类
 * @author tangxiaodong
 * 创建日期: 2016年3月27日
 * </pre>
 */
public class ConfigUtil {

    /**
     * 得到文本参数值
     * @param name
     * @return
     */
    public static String getTextVal(String name) {
        Assert.hasText(name);
        SysConfigService service = ContextUtil.getBean(SysConfigService.class);
        SysConfig cfg = service.findByName(name);
        return null != cfg && SYS_CONFIG_TYPE.STRING.name().equalsIgnoreCase(cfg.getSysType()) ? 
                cfg.getSysValue() : null;
    }
    
    /**
     * 得到数值参数值
     * @param name
     * @return BigDecimal
     */
    public static Number getNumberVal(String name) {
        Assert.hasText(name);
        SysConfigService service = ContextUtil.getBean(SysConfigService.class);
        SysConfig cfg = service.findByName(name);
        return null != cfg && null != cfg.getSysValue()
                && SYS_CONFIG_TYPE.NUMBER.name().equalsIgnoreCase(cfg.getSysType()) ? new BigDecimal(cfg.getSysValue())
                        : null;
    }
    
    /**
     * 得到布尔参数值
     * @param name
     * @return
     */
    public static Boolean getBoolean(String name){
        Assert.hasText(name);
        SysConfigService service = ContextUtil.getBean(SysConfigService.class);
        SysConfig cfg = service.findByName(name);
        return null != cfg && SYS_CONFIG_TYPE.BOOLEAN.name().equalsIgnoreCase(cfg.getSysType()) ? 
                Boolean.valueOf(cfg.getSysValue()) : false;
    }
    
    /**
     * 得到列表:<br/>
     * eg: [{"a":1,"b":2}] -> List<Demo>{demo.a=1, demo.b=2}
     * @param name
     * @return
     */
    public static <T> List<T> getList(String name, Class<T> clazz){
        Assert.hasText(name);
        SysConfigService service = ContextUtil.getBean(SysConfigService.class);
        SysConfig cfg = service.findByName(name);
        String gClazzName = clazz.getSimpleName();
        if(null != cfg && null != cfg.getSysValue() && SYS_CONFIG_TYPE.LIST.name().equalsIgnoreCase(cfg.getSysType()) && 
                null != cfg.getGeneralClass() && cfg.getGeneralClass().contains(gClazzName)){
            return JsonUtil.parseArray(cfg.getSysValue(), clazz);
        }
        return Collections.emptyList();
    }

    /**
     * 得到列表:<br/>
     * eg: [{"a":1,"b":2}] -> List<Demo>{demo.a=1, demo.b=2}
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] getArray(String name, Class<T> clazz) {
        Assert.hasText(name);
        SysConfigService service = ContextUtil.getBean(SysConfigService.class);
        SysConfig cfg = service.findByName(name);
        String gClazzName = clazz.getSimpleName();
        if (null != cfg && null != cfg.getSysValue() && SYS_CONFIG_TYPE.ARRAY.name().equalsIgnoreCase(cfg.getSysType())
                && null != cfg.getGeneralClass() && cfg.getGeneralClass().contains(gClazzName)) {
            List<T> list = JsonUtil.parseArray(cfg.getSysValue(), clazz);
            return list.toArray((T[]) Array.newInstance(clazz, list.size()));
        }
        return (T[]) Array.newInstance(clazz, 0);
    }
    
    /**
     * 得到MAP ，要求json格式
     * @param name
     * @return
     */
    @SuppressWarnings("rawtypes")
    public  static Map getMap(String name){
        Assert.hasText(name);
        SysConfigService service = ContextUtil.getBean(SysConfigService.class);
        SysConfig cfg = service.findByName(name);
        if(null != cfg && null != cfg.getSysValue() && SYS_CONFIG_TYPE.MAP.name().equalsIgnoreCase(cfg.getSysType())){
            return JsonUtil.toJsonObject(cfg.getSysValue(), Map.class);
        }
        return Collections.emptyMap();
    }
    

}
