/*
 * @(#)DictConfigServiceImpl.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.DateUtil;
import com.uuola.commons.StringUtil;
import com.uuola.txcms.base.dao.DictConfigDAO;
import com.uuola.txcms.base.dto.DictConfigDTO;
import com.uuola.txcms.base.entity.DictConfig;
import com.uuola.txcms.base.service.DictConfigService;
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
public class DictConfigServiceImpl implements DictConfigService {

    @Autowired
    private DictConfigDAO dictConfigDAO;
    
    @Override
    public PageDTO fetchByRange(BaseQuery query) {
        return new PageDTO(dictConfigDAO.findByRange(query), dictConfigDAO.findCount(query));
    }


    @Override
    public void save(DictConfigDTO dictConfigDTO) {
        // TODO Auto-generated method stub
        DictConfig entity = new DictConfig();
        BeanUtils.copyProperties(dictConfigDTO, entity);
        entity.setUpdateTime(DateUtil.getCurrTime());
        dictConfigDAO.save(entity);
    }


    @Override
    public List<DictConfig> getDict(String dictCode) {
        if(StringUtil.isEmpty(dictCode)){
            return Collections.emptyList();
        }
        return dictConfigDAO.findByCode(dictCode);
    }


    @Override
    public DictConfig findById(Long id) {
        return dictConfigDAO.get(id);
    }


    @Override
    public Integer update(DictConfigDTO dto) {
        DictConfig entity = dictConfigDAO.get(dto.getId());
        BeanUtils.copyProperties(dto, entity);
        entity.setUpdateTime(DateUtil.getCurrTime());
        return dictConfigDAO.update(entity);
    }


    @Override
    public Integer delete(Integer id) {
        return dictConfigDAO.deleteById(id);
    }

}
