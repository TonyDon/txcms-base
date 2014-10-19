/*
 * @(#)SiteCatDAO.java 2014-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.query.SiteCatQuery;
import com.uuola.txweb.framework.dao.support.TsBaseDAO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-19
 * </pre>
 */
@Repository
public class SiteCatDAO extends TsBaseDAO<SiteCat> {

    public List<SiteCat> findByRange(SiteCatQuery query){
        return this.selectList("com.uuola.txcms.sqlmapper.SiteCatMapper.findByRange", query);
    }
}
