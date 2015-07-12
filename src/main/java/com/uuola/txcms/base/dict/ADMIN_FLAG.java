/*
 * @(#)ADMIN_FLAG.java 2015年7月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dict;


/**
 * <pre>
 * 管理员标识
 * @author tangxiaodong
 * 创建日期: 2015年7月12日
 * </pre>
 */
public enum ADMIN_FLAG {
    
    /**
     * 普通会员
     */
    MEMBER((byte)0),

    /**
     * 管理员
     */
    ADMIN((byte)1);
    
    private byte value;
    
    ADMIN_FLAG(byte value){
        this.value = value;
    }
    
    public byte val(){
        return this.value;
    }
}
