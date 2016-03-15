/*
 * @(#)InfoContentDAO.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.InfoContent;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月23日
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.InfoContentMapper")
@Repository
public class InfoContentDAO extends TxWebDAO<InfoContent> {
    
    public InfoContent findById(Long infoId){
        return selectById(infoId);
    }

    public InfoContent findEffectById(Long infoId){
        return selectOne("findEffectById", infoId);
    }

    public List<Long> fetchHavingContentIds(List<Long> infoIds) {
        return selectList("fetchHavingContentIds", infoIds);
    }
}
