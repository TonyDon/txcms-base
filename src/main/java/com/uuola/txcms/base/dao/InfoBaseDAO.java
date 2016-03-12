/*
 * @(#)InfoBaseDAO.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.uuola.commons.DateUtil;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月23日
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.InfoBaseMapper")
@Repository
public class InfoBaseDAO extends TxWebDAO<InfoBase> {

    public InfoBase findById(Long id){
        return this.selectById(id);
    }

    public List<InfoBase> findByRange(BaseQuery query) {
        return this.selectList("findByRange", query);
    }

    public Integer findCount(BaseQuery query) {
        return this.selectOne("findCount", query);
    }
    
    public Integer markDelete(List<Long> ids){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        params.put("updateTime", DateUtil.getCurrTime());
        return this.updateByMapper("markDelete", params);
    }
    
    public InfoBase findEffective(Long id){
        return this.selectOne("findEffective", id);
    }

    public Integer updateInfoState(List<Long> ids, Byte state) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        params.put("state", state);
        params.put("updateTime", DateUtil.getCurrTime());
        return this.updateByMapper("updateInfoState", params);
    }

    public void adjustViewNum(Long id, Long diffNum) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("diffNum", diffNum);
        this.updateByMapper("adjustViewNum", params);
    }
}
