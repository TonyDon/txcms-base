/*
 * @(#)SysConfigService.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import com.uuola.txcms.base.dto.SysConfigDTO;
import com.uuola.txcms.base.entity.SysConfig;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
public interface SysConfigService {

    /**
     * 分页查询信息
     * @return
     */
    PageDTO fetchByRange(BaseQuery query);

    void  save(SysConfigDTO dto);

    Integer delete(Long id);

    SysConfig findById(Long id);

    Integer update(SysConfigDTO dto);
    
    SysConfig findByName(String name);
}
