/*
 * @(#)WebGameAction.java 2015年11月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uuola.txweb.framework.action.BaseAction;


/**
 * <pre>
 * WEB游戏
 * @author tangxiaodong
 * 创建日期: 2015年11月3日
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/webgame")
public class WebGameAction extends BaseAction {

    @RequestMapping(value="/addpage", method=RequestMethod.GET)
    public String addPage(){
        return this.getViewName("addpage");
    }
}
