/*
 * @(#)InfoFrontAction.java 2016年1月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.query.InfoQuery;
import com.uuola.txcms.base.service.InfoService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 信息展示
 * @author tangxiaodong
 * 创建日期: 2016年1月23日
 * </pre>
 */
@Controller
@RequestMapping("/info")
public class InfoFrontAction extends BaseAction {

    @Autowired
    private InfoService infoService;
    
    /**
     * 展示信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(InfoQuery query){
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<InfoDTO>() {

            @Override
            public InfoDTO doQuery(BaseQuery query) {
                return infoService.fetchById(((InfoQuery)query).getId());
            }
            
        });
        return assignViewName(mv, "view");
    }
}
