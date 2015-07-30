/*
 * @(#)ConsoleAction.java 2015年7月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.entity.UserInfo;
import com.uuola.txcms.component.SessionUtil;
import com.uuola.txweb.framework.action.BaseAction;


/**
 * <pre>
 * 控制台
 * @author tangxiaodong
 * 创建日期: 2015年7月12日
 * </pre>
 */
@Controller
@RequestMapping("/manager/console")
public class ConsoleAction extends BaseAction {

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = this.makeModelView("index");
        Object user = SessionUtil.getAdmin();
        if(null == user){
            model.setViewName("redirect:/manager/verify/login");
        }
        return model;
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(){
        SessionUtil.setAdmin(null);
        return "redirect:/manager/verify/login";
    }
    
    @RequestMapping(value="/session_check", method=RequestMethod.GET)
    @ResponseBody
    public Object sessionCheck() {
        Object user = SessionUtil.getAdmin();
        if (null != user) {
            return ((UserInfo)user).getName();
        }
        return "error";
    }
}
