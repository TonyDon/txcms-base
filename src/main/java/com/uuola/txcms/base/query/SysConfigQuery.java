/*
 * @(#)SysConfigQuery.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.query;

import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
public class SysConfigQuery extends BaseQuery {

    private static final long serialVersionUID = -1296732157110435683L;
    
    private String name;

    @Override
    public void filter() {
        // TODO Auto-generated method stub

    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

}
