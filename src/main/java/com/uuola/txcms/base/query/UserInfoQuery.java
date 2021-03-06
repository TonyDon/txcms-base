/*
 * @(#)UserInfoQuery.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.query;

import javax.validation.constraints.Size;

import com.uuola.txcms.base.exception.DemoException;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 用户信息查询对象
 * @author tangxiaodong
 * 创建日期: 2014-10-5
 * </pre>
 */
public class UserInfoQuery extends BaseQuery {

    private static final long serialVersionUID = 7551270157936798721L;

    @Size(min=3, max=16)
    private String name;
    
    private String tel;
    
    private Byte adminFlag;

    @Override
    public void filter() {
        if (this.listSize > 100) {
            throw new DemoException(DemoException.TEST_ERROR, this.listSize).setErrorCode(123);
        }
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }


    
    public Byte getAdminFlag() {
        return adminFlag;
    }


    
    public void setAdminFlag(Byte adminFlag) {
        this.adminFlag = adminFlag;
    }


    
    public String getTel() {
        return tel;
    }


    
    public void setTel(String tel) {
        this.tel = tel;
    }

}
