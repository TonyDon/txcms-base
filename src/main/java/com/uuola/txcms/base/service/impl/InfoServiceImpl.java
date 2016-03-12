/*
 * @(#)InfoServiceImpl.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.txcms.base.dao.InfoBaseDAO;
import com.uuola.txcms.base.dao.InfoContentDAO;
import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.entity.InfoContent;
import com.uuola.txcms.base.service.InfoService;
import com.uuola.txweb.framework.dao.support.TxWebTs;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2015年4月4日
 * </pre>
 */
@Service
@TxWebTs
public class InfoServiceImpl implements InfoService {


    @Autowired
    private InfoBaseDAO infoBaseDAO;
    
    @Autowired
    private InfoContentDAO infoContentDAO;
    
    @Override
    public InfoDTO fetchById(Long id) {
        InfoDTO infoDTO = new InfoDTO();
        InfoBase infoBase = infoBaseDAO.get(id);
        InfoContent content = infoContentDAO.get(id);
        infoDTO.setInfoBase(infoBase);
        infoDTO.setInfoContent(content);
        return infoDTO;
    }

    @Override
    public InfoDTO fetchEffective(Long id) {
        InfoDTO infoDTO = new InfoDTO();
        InfoBase infoBase = infoBaseDAO.findEffective(id);
        if (null != infoBase) {
            InfoContent content = infoContentDAO.get(id);
            infoDTO.setInfoBase(infoBase);
            infoDTO.setInfoContent(content);
        }
        return infoDTO;
    }

    @Override
    public void adjustViewNum(Long id, Long diffNum) {
        infoBaseDAO.adjustViewNum(id, diffNum);
    }

}
