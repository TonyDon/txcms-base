/*
 * @(#)SiteCatException.java 2014-10-21
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.exception;

import com.uuola.commons.exception.BusinessException;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-21
 * </pre>
 */
public class SiteCatException extends BusinessException {

    private static final long serialVersionUID = 7339542312070528298L;

    public static final String EXIST_NODE_CAT_THEN_DEL  ="exist.node.cat.then.del";
    
    public SiteCatException(String message, Object... params){
        super(message, params);
    }
}
