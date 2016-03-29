/*
 * @(#)SiteCatUtil.java 2016年3月28日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.uuola.commons.CollectionUtil;
import com.uuola.commons.ObjectUtil;
import com.uuola.commons.StringUtil;
import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.query.SiteCatQuery;
import com.uuola.txcms.base.service.SiteCatService;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年3月28日
 * </pre>
 */
public class SiteCatUtil implements ApplicationContextAware, InitializingBean{
    
    private static Logger log = LoggerFactory.getLogger(SiteCatUtil.class);
    
    private static Map<Long, SiteCat> cidCatholder = new HashMap<Long, SiteCat>();
    
    private static ApplicationContext context;
    
    /**
     * 加载所有类目信息
     */
    public static void loadAllCat(){
        SiteCatService service = context.getBean(SiteCatService.class);
        List<SiteCat> list = service.fetch(new SiteCatQuery());
        if(CollectionUtil.isNotEmpty(list)){
            cidCatholder.clear();
            for(SiteCat cat : list){
                cidCatholder.put(cat.getId(), cat);
            }
        }
        log.warn("SiteCatUtil.loadAllCat() invoked.");
    }
    
    /**
     * 得到生效类目集合
     * @return
     */
    public static List<SiteCat> getSiteCats(){
        List<SiteCat> cats = new ArrayList<SiteCat>();
        for(Map.Entry<Long, SiteCat> e : cidCatholder.entrySet()){
            SiteCat c = new SiteCat();
            BeanUtils.copyProperties(e.getValue(), c);
            cats.add(c);
        }
        return cats;
    }
    
    /**
     * 根据类目ID 得到类目信息
     * @param cid
     * @return
     */
    public static SiteCat getSiteCat(Long cid){
        return cidCatholder.get(cid);
    }

    /**
     * 转换 0-1-23-45- TO [1,23,45]
     * @param catPath
     * @return
     */
    public static Long[] getCatPathArray(String catPath){
        if(StringUtil.isEmpty(catPath) || catPath.length()<2){
            return new Long[]{};
        }
        int startIdx = catPath.indexOf("0-");
        
        String cpath = startIdx>=0 ? catPath.substring(2, catPath.length()-1) : catPath;
        String[] cpStrArr = StringUtil.split(cpath, '-');
        if(ObjectUtil.isEmpty(cpStrArr)){
            return new Long[]{};
        }
        Long[] idArray = new Long[cpStrArr.length];
        for(int k=0; k<cpStrArr.length; k++){
            idArray[k] = Long.valueOf(cpStrArr[k]);
        }
        return idArray;
    }
    
    public static void main(String... args){
        Long[] ca = getCatPathArray("0-1-23-45-");
        for(Long i : ca)
        System.out.println(i);
        System.out.println(ca.length);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadAllCat();
    }

}
