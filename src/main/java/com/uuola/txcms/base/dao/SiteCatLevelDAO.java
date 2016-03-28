package com.uuola.txcms.base.dao;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.SiteCatLevel;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;

/**
 * 
 * <pre>
 * 类目级别表
 * @author tangxiaodong
 * 创建日期: 2016年3月28日
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.SiteCatLevelMapper")
@Repository
public class SiteCatLevelDAO extends TxWebDAO<SiteCatLevel> {

    /**
     * 物理删除所有记录
     * @return
     */
    public Integer deleteAll(){
        return this.deleteByMapper("deleteAll");
    }
}
