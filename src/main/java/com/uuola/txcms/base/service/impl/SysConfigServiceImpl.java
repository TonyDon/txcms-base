/*
 * @(#)SysConfigServiceImpl.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.DateUtil;
import com.uuola.txcms.base.dao.SysConfigDAO;
import com.uuola.txcms.base.dto.SysConfigDTO;
import com.uuola.txcms.base.entity.SysConfig;
import com.uuola.txcms.base.service.SysConfigService;
import com.uuola.txweb.framework.dao.support.TxWebTs;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@Service
@TxWebTs
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigDAO sysConfigDAO;

    @Override
    public PageDTO fetchByRange(BaseQuery query) {
        return new PageDTO(sysConfigDAO.findByRange(query), sysConfigDAO.findCount(query));
    }

    @Override
    public void save(SysConfigDTO sysConfigDTO) {
        SysConfig entity = new SysConfig();
        BeanUtils.copyProperties(sysConfigDTO, entity);
        entity.setUpdateTime(DateUtil.getCurrTime());
        sysConfigDAO.save(entity);
    }

    @Override
    public Integer delete(Long id) {
        return sysConfigDAO.deleteById(id);
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigDAO.get(id);
    }

    @Override
    public Integer update(SysConfigDTO dto) {
        SysConfig entity = sysConfigDAO.get(dto.getId());
        entity.setGeneralClass(dto.getGeneralClass());
        entity.setName(dto.getName());
        entity.setRemark(dto.getRemark());
        entity.setSysType(dto.getSysType());
        entity.setSysValue(dto.getSysValue());
        entity.setUpdateTime(DateUtil.getCurrTime());
        return sysConfigDAO.update(entity);
    }

}
