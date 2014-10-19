/*
 * @(#)SiteCatService.java 2014-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import com.uuola.txcms.base.dto.SiteCatDTO;
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
}
