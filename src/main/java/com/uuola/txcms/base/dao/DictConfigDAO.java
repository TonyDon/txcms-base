/*
 * @(#)DictConfigDAO.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.DictConfig;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 系统字典配置DAO
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.DictConfigMapper")
@Repository
public class DictConfigDAO extends TxWebDAO<DictConfig> {

    public List<DictConfig> findByRange(BaseQuery query){
        return this.selectList("findByRange", query);
    }
    
    public Integer findCount(BaseQuery query){
        return this.selectOne("findCount", query);
    }
    
    /**
     * 通过字典编码查询字典参数列表
     * @param dictCode
     * @return
     */
    public List<DictConfig> findByCode(String dictCode) {
        return this.selectList("findByDictCode", dictCode);
    }
}
