/*
 * @(#)InfoQueryService.java 2016年1月25日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import java.util.List;

import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.entity.InfoContent;
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
    PageDTO fetchRangeLatestView(BaseQuery query);
    
    /**
     * 前端按类别分页查询 query.catPath需要设置 类别路径
     * @param query
     * @return
     */
    PageDTO fetchRangeCatView(BaseQuery query);

    /**
     * 查询信息正文内容
     * @param id
     * @return
     */
    InfoContent fetchEffectContent(Long id);
    
    /**
     * 通过传入的catId，返回相关联的随机信息ID
     * @param id
     * @return
     */
    List<Long> fetchRandRelatedIds(Long catId);

    /**
     * 找当前信息的前一条或后一条记录ID
     * @param id
     * @param catId
     * @param direct
     * @return
     */
    Long fetchSidesId(Long id, Long catId, Integer direct);
}
