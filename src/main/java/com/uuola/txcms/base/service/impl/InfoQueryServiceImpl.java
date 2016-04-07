/*
 * @(#)InfoQueryServiceImpl.java 2016年1月25日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.CollectionUtil;
import com.uuola.commons.NumberUtil;
import com.uuola.txcms.base.dao.InfoBaseDAO;
import com.uuola.txcms.base.dao.InfoContentDAO;
import com.uuola.txcms.base.dict.INFO_STATE;
import com.uuola.txcms.base.dict.TRUE_OR_FALSE;
import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.dto.InfoViewDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.entity.InfoContent;
import com.uuola.txcms.base.query.InfoQuery;
import com.uuola.txcms.base.service.InfoQueryService;
import com.uuola.txcms.component.BooleanUtil;
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
    
    @Autowired
    private InfoContentDAO infoContentDAO;
    
    @Override
    public PageDTO fetchByRange(BaseQuery query) {
        return new PageDTO(infoBaseDAO.findByRange(query), infoBaseDAO.findCount(query));
    }

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
    public PageDTO fetchRangeLatestView(BaseQuery query) {
        List<InfoViewDTO> list = infoBaseDAO.fetchRangeLatestView(query);
        if(CollectionUtil.isNotEmpty(list)){
            List<Long> ids = new ArrayList<Long>();
            for(InfoViewDTO dto : list){
                ids.add(dto.getId());
            }
            List<Long> hasContIds = infoContentDAO.fetchHavingContentIds(ids);
            if(CollectionUtil.isNotEmpty(hasContIds)){
                Set<Long> contIdSet = new HashSet<Long>(hasContIds);
                for(InfoViewDTO dto : list){
                    dto.setHasContent(BooleanUtil.getByte(contIdSet.contains(dto.getId())));
                }
            }
        }
        return new PageDTO(list, -1);
    }
    
    @Override
    public PageDTO fetchRangeCatView(BaseQuery query) {
        List<InfoViewDTO> list = infoBaseDAO.fetchRangeCatView(query);
        if(CollectionUtil.isNotEmpty(list)){
            List<Long> ids = new ArrayList<Long>();
            for(InfoViewDTO dto : list){
                ids.add(dto.getId());
            }
            List<Long> hasContIds = infoContentDAO.fetchHavingContentIds(ids);
            if(CollectionUtil.isNotEmpty(hasContIds)){
                Set<Long> contIdSet = new HashSet<Long>(hasContIds);
                for(InfoViewDTO dto : list){
                    dto.setHasContent(BooleanUtil.getByte(contIdSet.contains(dto.getId())));
                }
            }
        }
        return new PageDTO(list, -1);
    }

    @Override
    public InfoContent fetchEffectContent(Long id) {
        InfoQuery query = new InfoQuery();
        query.setId(id);
        query.setInfoState(INFO_STATE.PASS.value());
        query.setIsDelete(TRUE_OR_FALSE.F.value());
        return infoContentDAO.fetchContent(query);
    }
    
    @Override
    public List<Long> fetchRandRelatedIds(Long catId) {
        if(null == catId){
            return Collections.emptyList();
        }
        Integer max = infoBaseDAO.findCountByCatId(catId);
        return infoBaseDAO.findIdsByRange(catId, NumberUtil.genRndInt(0, max), NumberUtil.genRndInt(3, 10));
    }

    @Override
    public Long fetchSidesId(Long id, Long catId, Integer direct) {
        if(null == id || null == catId || null == direct){
            return null;
        }
        Long retId = null ;
        if(direct == 1){ //靠前的一条
            retId = infoBaseDAO.findNextId(id, catId);
        }else{ //靠后的一条
            retId = infoBaseDAO.findPrevId(id, catId);
        }
        return retId;
    }

}
