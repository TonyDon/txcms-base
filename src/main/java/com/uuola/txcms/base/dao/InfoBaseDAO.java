/*
 * @(#)InfoBaseDAO.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;


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
}
