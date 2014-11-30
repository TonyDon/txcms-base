/*
 * @(#)UserInfoDAOTest.java 2014年11月29日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms_base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.uuola.commons.JsonUtil;
import com.uuola.txcms.base.dao.UserInfoDAO;
import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txweb.framework.dao.support.SqlCondDef;
import com.uuola.txweb.framework.dao.support.SqlPropValue;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月29日
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserInfoDAOTest {

    @Configuration
    @ImportResource({"classpath:/applicationContext.xml"})
    public static class Config {

        @Bean
        public UserInfoDAO get() {
            return new UserInfoDAO();
        }
    }
    
    @Autowired
    private UserInfoDAO userInfoDAO;
    
    @Test
    public void test_getByKeys(){
        List<Long> ids = new ArrayList<Long>();
        ids.add(10000L);
        ids.add(10001l);
        ids.add(10002L);
        List<UserInfo> list = userInfoDAO.getByKeys(ids);
        System.out.println(JsonUtil.toJSONString(list));
    }
    
    @Test
    public void test_deleteByPropValue(){
        UserInfo ui = new UserInfo();
        ui.setName("dsaf");
        ui.setTel("af");
        ui.setId(10002l);
        userInfoDAO.delete(ui);
        UserInfo u = userInfoDAO.get(10002);
        System.out.println(u);
    }
    
    @Test
    public void test_delete_pv(){
        SqlPropValue[] pvs = {
                new SqlPropValue("name", "dsaf").setRelationCondition(SqlCondDef.AND),
                new SqlPropValue("tel", "af")
        };
        System.out.println(userInfoDAO.delete(pvs));
        UserInfo u = userInfoDAO.get(10002);
        System.out.println(u);
    }
}
