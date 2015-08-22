/*
 * @(#)SietCatAction.java 2015年8月22日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.SiteCatDTO;
import com.uuola.txcms.base.query.SiteCatQuery;
import com.uuola.txcms.base.service.SiteCatService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.dto.ValidateDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 站点类目管理
 * @author tangxiaodong
 * 创建日期: 2015年8月22日
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/sitecat")
public class SiteCatAction extends BaseAction {

    @Autowired
    private SiteCatService siteCatService;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        return this.makeModelView("index");
    }
    
    
    /**
     * 查询类目列表信息
     * @param query
     * @param webRequest
     * @return
     */
    @RequestMapping(value = "/treelist", method = RequestMethod.GET)
    public ModelAndView treelist(SiteCatQuery query) {
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {
            @Override
            public PageDTO doQuery(BaseQuery query) {
                return siteCatService.fetchByRange((SiteCatQuery)query);
            }
        });
        return assignViewName(mv, "treelist");
    }
    
    /**
     * 添加用户信息
     * @param userInfoDTO
     * @param webRequest
     * @return
     */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView add(SiteCatDTO siteCatDTO) {
        ModelAndView mv = updateAction(siteCatDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO siteCatDTO) {
                siteCatService.create((SiteCatDTO)siteCatDTO);
                return null;
            }
        });
        return assignViewName(mv, "add");
    }
    
    
    /**
     * 删除记录
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        Integer num = siteCatService.delete(id);
        return makeModelView("delete").addObject("num", num);
    }
}
