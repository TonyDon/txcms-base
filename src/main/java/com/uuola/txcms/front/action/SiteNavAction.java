/*
 * @(#)SiteNavAction.java 2016年3月15日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.front.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txweb.framework.action.BaseAction;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年3月15日
 * </pre>
 */
@Controller
@RequestMapping
public class SiteNavAction extends BaseAction {

    
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public ModelAndView latest(){
        return this.makeModelView("latest");
    }
}
