/*
 * @(#)INFO_TYPE.java 2016年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dict;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年4月4日
 * </pre>
 */
public enum INFO_TYPE {

    // 文本资讯
    CONTENT(Byte.valueOf("0")),
    
    // 重定向跳转
    REDIRECT(Byte.valueOf("1"));
    
    private Byte val;
    
    INFO_TYPE(Byte val){
        this.val = val;
    }
    
    public Byte value(){
        return this.val;
    }
}
