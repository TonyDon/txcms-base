/*
 * @(#)SupReqInfoService.java 2013-12-15
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import java.util.List;

import com.uuola.txcms.base.dto.SupReqInfoDTO;
import com.uuola.txcms.base.entity.SupReqInfo;


/**
 * <pre>
 * 供求信息服务
 * @author tangxiaodong
 * 创建日期: 2013-12-15
 * </pre>
 */
public interface SupReqInfoService {

    /**
     * 保存供求信息
     * @param supReqInfoDTO
     * @return
     */
    public void save(SupReqInfoDTO supReqInfoDTO);
    
    /**
     * 根据ID获取实体
     * @param id
     */
    public SupReqInfo getInfoById(Long id);
    

    /**
     * 分批查询信息
     * @param startIndex 记录起始行号
     * @param rowSize 取数据量大小
     * @return List<SupReqInfo>
     */
    public List<SupReqInfo> getBatchInfos(int startIndex, int rowSize);
}
