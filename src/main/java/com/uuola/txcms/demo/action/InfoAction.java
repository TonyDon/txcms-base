/*
 * @(#)InfoAction.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

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
 *
 * @author tangxiaodong
 * 创建日期: 2015年4月4日
 * </pre>
 */
@Controller
@RequestMapping("/info")
public class InfoAction extends BaseAction {

    @Autowired
    private InfoService infoService;
    
    /**
     * 展示信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(InfoQuery query){
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<InfoDTO>() {

            @Override
            public InfoDTO doQuery(BaseQuery query) {
                return infoService.fetchById(((InfoQuery)query).getId());
            }
            
        });
        return assignViewName(mv, "show");
    }
}
