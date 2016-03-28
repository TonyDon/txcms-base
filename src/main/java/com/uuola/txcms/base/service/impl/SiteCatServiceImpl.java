/*
 * @(#)SiteCatServiceImpl.java 2014-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.constant.CST_CHAR;
import com.uuola.txcms.base.dao.SiteCatDAO;
import com.uuola.txcms.base.dto.SiteCatDTO;
import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.exception.SiteCatException;
import com.uuola.txcms.base.query.SiteCatQuery;
import com.uuola.txcms.base.service.SiteCatService;
import com.uuola.txweb.framework.dao.support.TxWebTs;
import com.uuola.txweb.framework.dto.PageDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-19
 * </pre>
 */
@Service
@TxWebTs
public class SiteCatServiceImpl implements SiteCatService {


    @Autowired
    private SiteCatDAO siteCatDAO;
    
    
    @Override
    public void create(SiteCatDTO siteCatDTO) {
        Long rid = siteCatDTO.getRid();
        String catPath = "0-";
        // 创建一个顶级类目
        if(0 != rid){
            SiteCat parentCat = siteCatDAO.get(rid);
            siteCatDTO.setSiteType(parentCat.getSiteType());
            parentCat.setNodeNum(parentCat.getNodeNum()+1);
            siteCatDAO.update(parentCat);
            catPath = parentCat.getCatPath(); // 0-12-345-
        }
        SiteCat  targetCat = new SiteCat();
        BeanUtils.copyProperties(siteCatDTO, targetCat, "id");
        targetCat.setNodeNum(0);
        siteCatDAO.save(targetCat);
        Long id = targetCat.getId();
        targetCat.setCatPath(catPath.concat(String.valueOf(id)).concat(CST_CHAR.STR_LINE));
        siteCatDAO.update(targetCat);
    }


    @Override
    public PageDTO fetchByRange(SiteCatQuery query) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setTotal(20);// TODO
        pageDTO.setDatas(siteCatDAO.findByRange(query));
        return pageDTO;
    }


    @Override
    public Integer delete(Long id) {
        SiteCat cat = siteCatDAO.get(id);
        if(null == cat){
            return 0;
        }
        if(cat.getNodeNum()>0){
            throw new SiteCatException(SiteCatException.EXIST_NODE_CAT_THEN_DEL);
        }
        Integer effectNum = 0;
        effectNum += siteCatDAO.deleteById(id);
        SiteCat parentCat = siteCatDAO.get(cat.getRid());
        if(null != parentCat){
            Integer nodeNum = parentCat.getNodeNum();
            if(nodeNum>0){
                parentCat.setNodeNum(--nodeNum);
                siteCatDAO.update(parentCat);
            }
        }
        return effectNum;
    }


    @Override
    public List<SiteCat> fetch(SiteCatQuery query) {
        return siteCatDAO.find(query);
    }


    @Override
    public SiteCat fetchById(Long id) {
        return siteCatDAO.get(id);
    }
    

}
