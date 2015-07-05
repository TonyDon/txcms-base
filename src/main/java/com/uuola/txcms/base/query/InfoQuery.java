/*
 * @(#)InfoQuery.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.query;

import javax.validation.constraints.NotNull;

import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2015年4月4日
 * </pre>
 */
public class InfoQuery extends BaseQuery {

    private static final long serialVersionUID = 6329984665376751408L;
    
    @NotNull
    private Long id;
    

    @Override
    public void filter() {
        // TODO Auto-generated method stub

    }


    
    public Long getId() {
        return id;
    }


    
    public void setId(Long id) {
        this.id = id;
    }

}