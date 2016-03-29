/*
 * @(#)InfoQuery.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.query;

import javax.validation.constraints.NotNull;

import com.uuola.commons.constant.CST_CHAR;
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
    
    private String title;
    
    private Byte isDelete;
    
    private Byte infoState;
    
    private Long catId;
    
    private String catPath;
    

    @Override
    public void filter() {
        if(this.listSize>100){
            this.listSize = 100;
        }
        if(null != this.catPath){
            this.catPath = this.catPath.concat(CST_CHAR.STR_PERCENT);
        }
    }

    
    
    public Long getId() {
        return id;
    }


    
    public void setId(Long id) {
        this.id = id;
    }



    
    public String getTitle() {
        return title;
    }



    
    public void setTitle(String title) {
        this.title = title;
    }



    
    public Byte getIsDelete() {
        return isDelete;
    }



    
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }



    
    public Byte getInfoState() {
        return infoState;
    }



    
    public void setInfoState(Byte infoState) {
        this.infoState = infoState;
    }



    
    public String getCatPath() {
        return catPath;
    }



    
    public void setCatPath(String catPath) {
        this.catPath = catPath;
    }



    
    public Long getCatId() {
        return catId;
    }



    
    public void setCatId(Long catId) {
        this.catId = catId;
    }

}
