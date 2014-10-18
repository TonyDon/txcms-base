/*
 * @(#)UserInfoService.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-5
 * </pre>
 */
public interface UserInfoService {

    /**
     * 分页查询用户信息
     * @return
     */
    PageDTO fetchByRange(BaseQuery query);
    
    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 获取单个用户信息  
     * @param name
     * @return
     */
    UserInfo fetchSingle(UserInfoQuery query);
}
