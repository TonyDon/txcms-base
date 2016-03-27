/*
 * @(#)SysConfigDAO.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.SysConfig;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 系统参数配置DAO
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.SysConfigMapper")
@Repository
public class SysConfigDAO extends TxWebDAO<SysConfig> {

    public List<SysConfig> findByRange(BaseQuery query){
        return this.selectList("findByRange", query);
    }
    
    public Integer findCount(BaseQuery query){
        return this.selectOne("findCount", query);
    }

    public SysConfig findByName(String name) {
        return this.selectOne("findByName", name);
    }
}
