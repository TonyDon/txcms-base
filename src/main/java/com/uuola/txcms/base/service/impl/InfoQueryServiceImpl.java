/*
 * @(#)InfoQueryServiceImpl.java 2016年1月25日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.txcms.base.dao.InfoBaseDAO;
import com.uuola.txcms.base.service.InfoQueryService;
import com.uuola.txweb.framework.dao.support.TxWebTs;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年1月25日
 * </pre>
 */
@Service
@TxWebTs
public class InfoQueryServiceImpl implements InfoQueryService {

    @Autowired
    private InfoBaseDAO infoBaseDAO;
    
    @Override
    public PageDTO fetchByRange(BaseQuery query) {
        return new PageDTO(infoBaseDAO.findByRange(query), infoBaseDAO.findCount(query));
    }

}
