/*
 * @(#)InfoQueryService.java 2016年1月25日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * info信息查询服务
 * @author tangxiaodong
 * 创建日期: 2016年1月25日
 * </pre>
 */
public interface InfoQueryService {

    /**
     * 分页查询
     * @param query
     * @return
     */
    PageDTO fetchByRange(BaseQuery query);
    
    /**
     * 获取info记录
     * @param id
     * @return
     */
    InfoDTO fetchById(Long id);

    /**
     * 前端分页查询
     * @param query
     * @return
     */
    PageDTO fetchRangeView(BaseQuery query);

}
