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
import com.uuola.txweb.framework.dao.support.TxWebDAO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 用户基本信息数据操作
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
@Repository
public class UserInfoDAO extends TxWebDAO<UserInfo> {

    public boolean isNotExistTel(String tel) {
        UserInfoQuery query =  new UserInfoQuery();
        query.setTel(tel);
        UserInfo userInfo = this.selectOne("com.uuola.txcms.sqlmapper.UserInfoMapper.findSingle", query);
        return null == userInfo ;
    }
    
    public List<UserInfo> findByRange(BaseQuery query){
        return this.selectList("com.uuola.txcms.sqlmapper.UserInfoMapper.findByRange", query);
    }
    
    public UserInfo findSingle(BaseQuery query){
        return this.selectOne("com.uuola.txcms.sqlmapper.UserInfoMapper.findSingle", query);
    }
}
