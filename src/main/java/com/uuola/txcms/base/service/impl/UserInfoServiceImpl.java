/*
 * @(#)UserInfoServiceImpl.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.txcms.base.dao.UserInfoDAO;
import com.uuola.txcms.base.service.UserInfoService;
import com.uuola.txweb.framework.dao.support.TsBaseTx;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-5
 * </pre>
 */
@Service
@TsBaseTx
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;
    
    @Override
    public PageDTO fetchByRange(BaseQuery query) {
        return new PageDTO(userInfoDAO.findByRange(query), 16);
    }

    @Override
    public int delete(Long id) {
        return userInfoDAO.deleteById(id);
    }

}
