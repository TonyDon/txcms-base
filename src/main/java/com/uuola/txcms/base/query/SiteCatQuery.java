/*
 * @(#)SiteCatQuery.java 2014-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.query;

import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-19
 * </pre>
 */
public class SiteCatQuery extends BaseQuery {

    private static final long serialVersionUID = -8596033834422727288L;
    
    // 父类目ID
    private Long rid;
    
    @Override
    public void filter() {
        if (this.listSize > 100) {
            this.listSize = 100;
        }
        if(null == rid){
            rid = 0L;
        }
    }

    
    public Long getRid() {
        return rid;
    }

    
    public void setRid(Long rid) {
        this.rid = rid;
    }

}
