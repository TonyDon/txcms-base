/*
 * @(#)INFO_STATE.java 2016年2月16日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dict;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年2月16日
 * </pre>
 */
public enum INFO_STATE {

    WAIT_AUDIT(Byte.valueOf("0")),
    
    PASS(Byte.valueOf("1")),
    
    REFUSE(Byte.valueOf("2"));
    
    private Byte val;
    
    INFO_STATE(Byte val){
        this.val = val;
    }
    
    public Byte value(){
        return this.val;
    }
    
}
