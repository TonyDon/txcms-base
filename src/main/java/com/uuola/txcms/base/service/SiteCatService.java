/*
 * @(#)SiteCatService.java 2014-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import java.util.List;

import com.uuola.txcms.base.dto.SiteCatDTO;
import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.query.SiteCatQuery;
import com.uuola.txweb.framework.dto.PageDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-19
 * </pre>
 */
public interface SiteCatService {

    /**
     * 创建站点类目
     * @param siteCatDTO
     */
    void create(SiteCatDTO siteCatDTO);
    
    /**
     * 查询站点类目
     * @param query
     * @return
     */
    PageDTO fetchByRange(SiteCatQuery query);
    
    /**
     * 删除一个类目
     * @param id
     * @return
     */
    Integer delete(Long id);
    
    /**
     * 获取所有类目
     * @return
     */
    List<SiteCat> fetch(SiteCatQuery query);
    
    /**
     * 得到
     * @param id
     * @return
     */
    SiteCat fetchById(Long id);
}
