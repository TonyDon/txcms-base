/*
 * @(#)UserInfoService.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

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
}
