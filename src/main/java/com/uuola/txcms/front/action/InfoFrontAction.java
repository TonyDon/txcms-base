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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.query.InfoQuery;
import com.uuola.txcms.base.service.InfoQueryService;
import com.uuola.txcms.base.service.InfoService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
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
    
    @Autowired
    private InfoQueryService infoQueryService;
    
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
                return infoService.fetchEffective(((InfoQuery)query).getId());
            }
            
        });
        return assignViewName(mv, "view");
    }
    
    /**
     * 增加浏览次数
     * @param id
     */
    @RequestMapping(value = "/viewnum/hit", method = RequestMethod.PUT)
    public void hitViewNum(@RequestParam("id") Long id){
        infoService.adjustViewNum(id, 1L);
    }
    
    /**
     * 调整浏览次数
     * @param id
     * @param diff 正为增加，负为减少
     */
    @RequestMapping(value = "/viewnum/adjust", method = RequestMethod.GET)
    public void adjustViewNum(@RequestParam("id") Long id, @RequestParam("diff") Long diff){
        infoService.adjustViewNum(id, diff);
    }
    
    /**
     * 查询最近的信息集合
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/fetch-latest", method = RequestMethod.GET)
    public ModelAndView fetchLatestApi(InfoQuery query){
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {

            @Override
            public PageDTO doQuery(BaseQuery query) {
                return infoQueryService.fetchRangeView(query);
            }
            
        });
        return assignViewName(mv, "fetchLatest");
    }
}
