/*
 * @(#)UserInfoDAO.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txweb.framework.dao.support.TsBaseDAO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 用户基本信息数据操作
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
@Repository
public class UserInfoDAO extends TsBaseDAO<UserInfo> {

    /**
     * 判断是否存在该移动号码的用户<br/>
     * 不存在返回true,否则返回false 存在记录
     * @param tel
     * @return
     */
    public boolean isNotExistTel(String tel) {
        List<Map<String, Object>> list = this.executeQuery("select id from user_info where tel=? limit 0,1", tel);
        return CollectionUtils.isEmpty(list);
    }
    
    public List<UserInfo> findByRange(BaseQuery query){
        return this.selectList("com.uuola.txcms.sqlmapper.UserInfoMapper.findByRange", query);
    }
    
    public UserInfo findSingle(BaseQuery query){
        return this.selectOne("com.uuola.txcms.sqlmapper.UserInfoMapper.findSingle", query);
    }
}
