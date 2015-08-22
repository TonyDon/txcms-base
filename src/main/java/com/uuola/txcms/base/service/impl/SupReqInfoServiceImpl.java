/*
 * @(#)SupReqInfoServiceImpl.java 2013-12-15
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.DateUtil;
import com.uuola.txcms.base.dao.SupReqInfoDAO;
import com.uuola.txcms.base.dto.SupReqInfoDTO;
import com.uuola.txcms.base.entity.SupReqInfo;
import com.uuola.txcms.base.service.SupReqInfoService;
import com.uuola.txweb.framework.dao.support.TxWebTs;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2013-12-15
 * </pre>
 */
@Service("supReqInfoService")
@TxWebTs
public class SupReqInfoServiceImpl implements SupReqInfoService {

    @Autowired
    private SupReqInfoDAO supReqInfoDAO;
    
    @Override
    public void save(SupReqInfoDTO supReqInfoDTO) {
        SupReqInfo entity = new SupReqInfo();
        BeanUtils.copyProperties(supReqInfoDTO, entity);
        long time = DateUtil.getCurrTime();
        entity.setCreateTime(time);
        entity.setExpireTime(time + 30*24*60*60*1000);// 30 day after
        supReqInfoDAO.save(entity);
    }

    @Override
    public SupReqInfo getInfoById(Long id) {
        return supReqInfoDAO.get(id);
    }

    @Override
    public List<SupReqInfo> getBatchInfos(int startIndex, int rowSize) {
        return supReqInfoDAO.findInfosByRowRange(startIndex, rowSize);
    }

}
