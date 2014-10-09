/*
 * @(#)UserInfoQuery.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.query;

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
    
    //TODO other search conditions 

    @Override
    public void filter() {
        if (this.listSize > 100) {
            throw new DemoException(DemoException.TEST_ERROR, this.listSize).setErrorCode(123);
        }
    }

}
