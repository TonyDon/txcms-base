/*
 * @(#)UserRegServiceImpl.java 2013-12-7
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.DateUtil;
import com.uuola.txcms.base.dao.UserInfoDAO;
import com.uuola.txcms.base.dto.UserInfoDTO;
import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txcms.base.service.UserRegService;
import com.uuola.txcms.component.PassKeyManager;
import com.uuola.txcms.component.SequenceManager;
import com.uuola.txweb.framework.dao.support.TsBaseTx;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2013-12-7
 * </pre>
 */
@Service
@TsBaseTx
public class UserRegServiceImpl implements UserRegService {
    
    @Autowired
    private SequenceManager sequenceManager;

    @Autowired
    private UserInfoDAO userInfoDAO;
    
    @Override
    public boolean validateTel(String tel) {
        return userInfoDAO.isNotExistTel(tel);
    }

    @Override
    public boolean saveNewUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        String passkey= userInfo.getPassKey();
        userInfo.setPassKey(PassKeyManager.encrypt(passkey));
        userInfo.setCreateTime(DateUtil.getCurrMsTime());
        userInfo.setId(sequenceManager.makeUserId());
        userInfoDAO.save(userInfo);
        if(null!=userInfo.getId()){
            return true;
        }
        return false;
    }

}
