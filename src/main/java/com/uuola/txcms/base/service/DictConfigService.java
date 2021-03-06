/*
 * @(#)DictConfigService.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import java.util.List;

import com.uuola.txcms.base.dto.DictConfigDTO;
import com.uuola.txcms.base.entity.DictConfig;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
public interface DictConfigService {

    /**
     * 分页查询信息
     * @return
     */
    PageDTO fetchByRange(BaseQuery query);

    void  save(DictConfigDTO dto);
    
    /**
     * 通过字典代码获取字典配置
     * @param dictCode
     * @return
     */
    List<DictConfig> getDict(String dictCode);

    DictConfig findById(Long id);

    Integer update(DictConfigDTO dto);

    Integer delete(Integer id);
}
