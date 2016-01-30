/*
 * @(#)InfoPostServiceImpl.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.DateUtil;
import com.uuola.commons.StringUtil;
import com.uuola.txcms.base.dao.InfoBaseDAO;
import com.uuola.txcms.base.dao.InfoContentDAO;
import com.uuola.txcms.base.dto.InfoPostDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.entity.InfoContent;
import com.uuola.txcms.base.service.InfoPostService;
import com.uuola.txcms.component.SequenceManager;
import com.uuola.txweb.framework.dao.support.TxWebTs;


/**
 * <pre>
 * 创建信息服务
 * @author tangxiaodong
 * 创建日期: 2014年11月23日
 * </pre>
 */
@Service
@TxWebTs
public class InfoPostServiceImpl implements InfoPostService {

    @Autowired
    private InfoBaseDAO infoBaseDAO;
    
    @Autowired
    private InfoContentDAO infoContentDAO;
    
    @Autowired
    private SequenceManager sequenceManager;
    
    @Override
    public void save(InfoPostDTO infoPostDTO) {
        InfoBase base = new InfoBase();
        InfoContent content = new InfoContent();
        BeanUtils.copyProperties(infoPostDTO, base);
        base.setId(sequenceManager.makeId(infoPostDTO.getTitle()));
        base.setAuthorId(-1L);
        base.setCreateTime(DateUtil.getCurrTime());
        infoBaseDAO.save(base);
        if (StringUtil.isNotEmpty(infoPostDTO.getContent())) {
            content.setContent(infoPostDTO.getContent());
            content.setInfoId(base.getId());
            infoContentDAO.save(content);
        }
    }

}
