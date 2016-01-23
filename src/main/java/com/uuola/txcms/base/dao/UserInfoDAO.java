/*
 * @(#)UserInfoDAO.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txweb.framework.dao.annotation.MapperNamespace;
import com.uuola.txweb.framework.dao.support.TxWebDAO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 用户基本信息数据操作
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
@MapperNamespace("com.uuola.txcms.sqlmapper.UserInfoMapper")
@Repository
public class UserInfoDAO extends TxWebDAO<UserInfo> {

    public boolean isNotExistTel(String tel) {
        UserInfoQuery query =  new UserInfoQuery();
        query.setTel(tel);
        UserInfo userInfo = this.selectOne("findSingle", query);
        return null == userInfo ;
    }
    
    public List<UserInfo> findByRange(BaseQuery query){
        return this.selectList("findByRange", query);
    }
    
    public UserInfo findSingle(BaseQuery query){
        return this.selectOne("findSingle", query);
    }
}
