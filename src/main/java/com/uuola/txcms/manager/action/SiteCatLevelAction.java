/*
 * @(#)SiteCatLevelAction.java 2016年3月28日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uuola.txcms.base.dict.TRUE_OR_FALSE;
import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.query.SiteCatQuery;
import com.uuola.txcms.base.service.SiteCatLevelService;
import com.uuola.txcms.base.service.SiteCatService;
import com.uuola.txweb.framework.action.BaseAction;


/**
 * <pre>
 * 类目级别action
 * @author tangxiaodong
 * 创建日期: 2016年3月28日
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/sitecatlevel")
public class SiteCatLevelAction extends BaseAction {
    
    @Autowired
    private SiteCatService siteCatService;

    @Autowired
    private SiteCatLevelService siteCatLevelService;
    
    /**
     * 重新构建类目级别表
     * @throws FileNotFoundException 
     */
    @RequestMapping(value = "/rebuild", method = RequestMethod.GET)
    public void rebuild(){
        SiteCatQuery query = new SiteCatQuery();
        query.setStatus(TRUE_OR_FALSE.T.value());
        List<SiteCat> list = siteCatService.fetch(query);
        siteCatLevelService.rebuild(list);
    }
}
