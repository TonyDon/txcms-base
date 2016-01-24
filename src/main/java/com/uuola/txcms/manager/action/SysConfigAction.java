/*
 * @(#)SysConfigAction.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.SysConfigDTO;
import com.uuola.txcms.base.entity.SysConfig;
import com.uuola.txcms.base.query.SysConfigQuery;
import com.uuola.txcms.base.service.SysConfigService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.dto.ValidateDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 系统参数配置
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/sysconfig")
public class SysConfigAction extends BaseAction {
    
    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        return this.makeModelView("index");
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(SysConfigQuery query, ServletWebRequest webRequest) {
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {
            @Override
            public PageDTO doQuery(BaseQuery query) {
                return sysConfigService.fetchByRange(query);
            }
        });
        return assignViewName(mv, "search");
    }
    
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public ModelAndView post(SysConfigDTO sysConfigDTO, ServletWebRequest webRequest) {
        ModelAndView mv = updateAction(sysConfigDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO dto) {
                sysConfigService.save((SysConfigDTO)dto);
                return true;
            }
        });
        return assignViewName(mv, "post");
    }
    
    /**
     * 删除记录
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        Integer num = sysConfigService.delete(id);
        return makeModelView("delete").addObject("num", num);
    } 
    
    /**
     * 展示记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable("id") Long id) {
        SysConfig config = sysConfigService.findById(id);
        return makeModelView("show").addObject("sysConfig", config);
    } 
    
    /**
     * 更新记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable("id") Long id, SysConfigDTO sysConfigDTO ) {
        ModelAndView mv = updateAction(sysConfigDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO dto) {
                return sysConfigService.update((SysConfigDTO)dto);
            }
        });
        return assignViewName(mv, "update");
    } 
}
