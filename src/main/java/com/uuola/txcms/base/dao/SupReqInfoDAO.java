/*
 * @(#)SupReqInfoDAO.java 2013-12-30
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.SupReqInfo;
import com.uuola.txcms.base.query.SupReqInfoQuery;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2013-12-30
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.SupReqInfoMapper")
@Repository
public class SupReqInfoDAO extends TxWebDAO<SupReqInfo> {


    /**
     * 通过起始位置和取出排记录大小返回记录集
     * @param startIndex
     * @param rowSize
     * @return
     */
    public List<SupReqInfo> findInfosByRowRange(int startIndex, int rowSize){
/*        String sql = "select * from sup_req_info limit ?, ? ";
        return this.executeQuery(sql, SupReqInfo.class, startIndex, rowSize);*/
        SupReqInfoQuery query = new SupReqInfoQuery();
        query.setCrow(startIndex);
        query.setListSize(rowSize);
        return this.selectList("findInfosByRowRange", query);
    }
}
