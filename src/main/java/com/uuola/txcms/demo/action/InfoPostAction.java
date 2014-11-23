/*
 * @(#)InfoPostAction.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

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
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月23日
 * </pre>
 */
@Controller
public class InfoPostAction extends BaseAction {

    @Autowired
    private InfoPostService infoPostService;
    
    @RequestMapping(value="/info/add", method=RequestMethod.POST)
    public ModelAndView add(InfoPostDTO infoPostDTO, ServletWebRequest webRequest) {
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
