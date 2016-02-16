/*
 * @(#)CmsInfoAction.java 2015年8月22日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.CollectionUtil;
import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.dto.InfoPostDTO;
import com.uuola.txcms.base.query.InfoQuery;
import com.uuola.txcms.base.service.InfoPostService;
import com.uuola.txcms.base.service.InfoQueryService;
import com.uuola.txcms.component.SessionUtil;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.dto.ValidateDTO;
import com.uuola.txweb.framework.query.BaseQuery;


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
    
    @Autowired
    private InfoQueryService infoQueryService;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        return this.makeModelView("index");
    }
    
    @RequestMapping(value="/addpage", method=RequestMethod.GET)
    public ModelAndView addPage(){
        return this.makeModelView("addpage");
    }
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public ModelAndView post(InfoPostDTO infoPostDTO, ServletWebRequest webRequest) {
        infoPostDTO.setAuthorId(SessionUtil.getUser().getId());
        ModelAndView mv = updateAction(infoPostDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO infoPostDTO) {
                infoPostService.save((InfoPostDTO)infoPostDTO);
                return null;
            }
        });
        return mv;
    }
    
    /**
     * 标记删除记录
     */
    @RequestMapping(value = "/markdelete", method = RequestMethod.POST)
    public ModelAndView markDelete(@RequestParam("ids[]") ArrayList<Long> ids) {
        Integer num = 0;
        if (CollectionUtil.isNotEmpty(ids)) {
            num = infoPostService.markDelete(ids);
        }
        return makeModelView("markdelete").addObject("num", num);
    }
    
    /**
     * 更新状态
     */
    @RequestMapping(value = "/infostate", method = RequestMethod.POST)
    public ModelAndView infoState(@RequestParam("ids[]") ArrayList<Long> ids, @RequestParam("state") Byte state) {
        Integer num = 0;
        if (CollectionUtil.isNotEmpty(ids)) {
            num = infoPostService.updateInfoState(ids, state);
        }
        return makeModelView("infoState").addObject("num", num);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(InfoQuery query, ServletWebRequest webRequest) {
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {
            @Override
            public PageDTO doQuery(BaseQuery query) {
                return infoQueryService.fetchByRange(query);
            }
        });
        return assignViewName(mv, "search");
    }
    
    /**
     * 展示信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(InfoQuery query){
        InfoDTO info = infoQueryService.fetchById(query.getId());
        ModelAndView mv = this.makeModelView("view");
        mv.addObject("infoDTO", info);
        return mv;
    }
}
