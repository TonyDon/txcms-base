/*
 * @(#)SysConfigAction.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.config.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.SysConfigDTO;
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
 *
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@Controller
@RequestMapping("/config/sys")
public class SysConfigAction extends BaseAction {
    
    @Autowired
    private SysConfigService sysConfigService;

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
    
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView add(SysConfigDTO sysConfigDTO, ServletWebRequest webRequest) {
        ModelAndView mv = updateAction(sysConfigDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO dto) {
                sysConfigService.save((SysConfigDTO)dto);
                return true;
            }
        });
        return assignViewName(mv, "add");
    }
}
