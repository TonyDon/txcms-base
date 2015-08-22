/*
 * @(#)CmsInfoAction.java 2015年8月22日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.InfoPostDTO;
import com.uuola.txcms.base.service.InfoPostService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 * cms内容管理
 * @author tangxiaodong
 * 创建日期: 2015年8月22日
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/cmsinfo")
public class CmsInfoAction extends BaseAction {

    @Autowired
    private InfoPostService infoPostService;
    
    @RequestMapping(value="/addpage", method=RequestMethod.GET)
    public ModelAndView addPage(){
        return this.makeModelView("addpage");
    }
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public ModelAndView post(InfoPostDTO infoPostDTO, ServletWebRequest webRequest) {
        ModelAndView mv = updateAction(infoPostDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO infoPostDTO) {
                infoPostService.save((InfoPostDTO)infoPostDTO);
                return null;
            }
        });
        return mv;
    }
}
