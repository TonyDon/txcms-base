/*
 * @(#)WebGameFrontAction.java 2016年1月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dict.INFO_TYPE;
import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.query.InfoQuery;
import com.uuola.txcms.base.service.InfoService;
import com.uuola.txcms.component.WebResourceAccessUtil;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * h5game action
 * @author tangxiaodong
 * 创建日期: 2016年1月3日
 * </pre>
 */
@Controller
@RequestMapping("/h5g")
public class WebGameFrontAction extends BaseAction {
    
    @Autowired
    private InfoService infoService;

    /**
     * game 展示页面
     * @param query
     * @return
     */
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public ModelAndView show(InfoQuery query){
        ModelAndView mv = fetchEffectInfo(query);
        assignViewName(mv, "show");
        return detectRedirect(mv);
    }
    
    /**
     * 游戏页面
     * @param query
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.GET)
    public ModelAndView play(InfoQuery query){
        ModelAndView mv = fetchEffectInfo(query);
        mv.addObject(WebResourceAccessUtil.URL_HASH_PARAM_NAME, WebResourceAccessUtil.makeHash());
        assignViewName(mv, "play");
        return detectRedirect(mv);
    }
    
    /**
     * 探测是否为重定向请求，如果是则重定向到site url
     * @param mv
     * @return
     */
    private ModelAndView detectRedirect(ModelAndView mv){
        InfoDTO infoDTO = (InfoDTO)mv.getModel().get("infoDTO");
        InfoBase ib = infoDTO.getInfoBase();
        if(null != ib && INFO_TYPE.REDIRECT.value().equals(ib.getInfoType())){
           mv.setViewName("redirect:"+ib.getSiteUrl());
        }
        return mv;
    }
    
    private ModelAndView fetchEffectInfo(InfoQuery query){
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<InfoDTO>() {

            @Override
            public InfoDTO doQuery(BaseQuery query) {
                return infoService.fetchEffective(((InfoQuery)query).getId());
            }
            
        });
        return mv;
    }
}
