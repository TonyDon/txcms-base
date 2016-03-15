/*
 * @(#)BooleanUtil.java 2016年3月15日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import com.uuola.txcms.base.dict.TRUE_OR_FALSE;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年3月15日
 * </pre>
 */
public abstract class BooleanUtil {

    /**
     * 得到布尔值对应的 byte枚举值
     * @param b
     * @return
     */
    public static Byte getByte(boolean b){
        return b ? TRUE_OR_FALSE.T.value() : TRUE_OR_FALSE.F.value();
    }
}
