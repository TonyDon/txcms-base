/*
 * @(#)InfoDTO.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.dto;

import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.entity.InfoContent;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2015年4月4日
 * </pre>
 */
public class InfoDTO {

    private InfoBase infoBase;
    
    private InfoContent infoContent;

    
    public InfoBase getInfoBase() {
        return infoBase;
    }

    
    public void setInfoBase(InfoBase infoBase) {
        this.infoBase = infoBase;
    }

    
    public InfoContent getInfoContent() {
        return infoContent;
    }

    
    public void setInfoContent(InfoContent infoContent) {
        this.infoContent = infoContent;
    }
}
