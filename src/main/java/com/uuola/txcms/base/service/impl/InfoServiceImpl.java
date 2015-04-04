/*
 * @(#)InfoServiceImpl.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.txcms.base.dao.InfoBaseDAO;
import com.uuola.txcms.base.dao.InfoContentDAO;
import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.entity.InfoContent;
import com.uuola.txcms.base.service.InfoService;
import com.uuola.txweb.framework.dao.support.TsBaseTx;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2015年4月4日
 * </pre>
 */
@Service
@TsBaseTx
public class InfoServiceImpl implements InfoService {


    @Autowired
    private InfoBaseDAO infoBaseDAO;
    
    @Autowired
    private InfoContentDAO infoContentDAO;
    
    @Override
    public InfoDTO fetchById(Long id) {
        InfoDTO infoDTO = new InfoDTO();
        InfoBase infoBase = infoBaseDAO.get(id);
        List<InfoContent> infoContents = infoContentDAO.findByPropValue("infoId", id);
        infoDTO.setInfoBase(infoBase);
        if(infoContents.size()==1){
            infoDTO.setInfoContent(infoContents.get(0));
        }
        return infoDTO;
    }

}
