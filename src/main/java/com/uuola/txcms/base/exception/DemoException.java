/*
 * @(#)DemoException.java 2014-10-9
 * 
 * Copy Right@ yihaodian
 */ 

package com.uuola.txcms.base.exception;

import com.uuola.commons.exception.BusinessException;


/**
 * <pre>
 * 测试异常类
 * @author tangxiaodong
 * 创建日期: 2014-10-9
 * </pre>
 */
public class DemoException extends BusinessException {

    private static final long serialVersionUID = 2981689865302652830L;
    
    public static final String TEST_ERROR ="test.error";
    
    public DemoException(String message, Object... params){
        super(message, params);
    }
}
