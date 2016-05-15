/*
 * @(#)InfoFrontAction.java 2016年1月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.CollectionUtil;
import com.uuola.commons.NumberUtil;
import com.uuola.commons.StringUtil;
import com.uuola.txcms.base.dict.INFO_TYPE;
import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.base.entity.InfoContent;
import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.query.InfoQuery;
import com.uuola.txcms.base.service.InfoQueryService;
import com.uuola.txcms.base.service.InfoService;
import com.uuola.txcms.component.SiteCatUtil;
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
     * 页面信息存储DTO MODEL 属性KEY
     */
    private final String PAGE_INFODTO_KEY = "infoDTO";
    
    /**
     * 展示信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewPath(@PathVariable("id") Long id) {
        if (null == id) {
            return null;
        }
        return viewRequest(id);
    }
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView viewRequest(@RequestParam("id") Long id) {
        if (null == id) {
            return null;
        }
        InfoQuery query = new InfoQuery();
        query.setId(id);
        ModelAndView mv = queryAction(query, PAGE_INFODTO_KEY, new QueryCallbackHandler<InfoDTO>() {

            @Override
            public InfoDTO doQuery(BaseQuery query) {
                return infoService.fetchEffective(((InfoQuery) query).getId());
            }

        });
        assignViewName(mv, "view");
        
        InfoDTO infoDTO = (InfoDTO)mv.getModel().get(PAGE_INFODTO_KEY);
        InfoBase ib = infoDTO.getInfoBase();
        InfoContent cont = infoDTO.getInfoContent();
        if(null != ib && INFO_TYPE.REDIRECT.value().equals(ib.getInfoType())){
           mv.setViewName("redirect:"+ib.getSiteUrl());
        }
        if(null != cont && StringUtil.isNotEmpty(cont.getContent())){
            mv.addObject("content", cont.getContent());
            cont.setContent(null); // 设置为NULL 不用JSON序列化
        }
        return mv;
    }

    /**
     * 归档列表，用于SEO抓取
     * @param query
     * @return
     */
    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public ModelAndView archive(InfoQuery query){
        if(null == query.getPageNo()){
            query.setPageNo(1);
        }
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {

            @Override
            public PageDTO doQuery(BaseQuery query) {
                return infoQueryService.fetchRangeLatestView(query);
            }
            
        });
        return assignViewName(mv, "archive");
    }
    
    /**
     * 增加浏览次数
     * @param id
     */
    @RequestMapping(value = "/api/hit-viewnum", method = RequestMethod.PUT)
    public void hitViewNumApi(@RequestParam("id") Long id){
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
                return infoQueryService.fetchRangeLatestView(query);
            }
            
        });
        return assignViewName(mv, "fetchLatest");
    }
    
    /**
     * 按类别查询信息集合
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/fetch-cat-list", method = RequestMethod.GET)
    public ModelAndView fetchCatApi(InfoQuery query){
        if(null == query.getCatId()){
            return null;
        }
        SiteCat cat = SiteCatUtil.getSiteCat(query.getCatId());
        if(null == cat){
            return null;
        }
        query.setCatPath(cat.getCatPath());
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {

            @Override
            public PageDTO doQuery(BaseQuery query) {
                return infoQueryService.fetchRangeCatView(query);
            }
            
        });
        return assignViewName(mv, "fetchCatList");
    }
    
    @RequestMapping(value = "/api/post-mood", method = RequestMethod.PUT)
    public void postMoodApi(@RequestParam("id") Long id, @RequestParam("mood") String mood){
        infoService.adjustMood(id, mood, 1);
    }
    
    @RequestMapping(value = "/api/view-cont", method = RequestMethod.GET)
    public ModelAndView viewContentApi(@RequestParam("id") Long id){
        InfoContent content = infoQueryService.fetchEffectContent(id);
        ModelAndView mv = this.makeModelView("viewContent");
        mv.addObject("infoConent", content);
        return mv;
    }
    
    @RequestMapping(value = "/api/rand-pick", method = RequestMethod.GET)
    public ModelAndView randPickApi(@RequestParam("cid") Long cid){
        List<Long> ids = infoQueryService.fetchRandRelatedIds(cid);
        Long retId = null;
        if(CollectionUtil.isNotEmpty(ids)){
            retId = ids.get(NumberUtil.genRndInt(0, ids.size()));
        }
        ModelAndView mv = this.makeModelView("randPick");
        mv.addObject("id", retId);
        return mv;
    }
    
    @RequestMapping(value = "/api/go-pick", method = RequestMethod.GET)
    public ModelAndView goPickApi(@RequestParam("id") Long id, @RequestParam("cid") Long cid, @RequestParam("direct") Integer direct){
        Long retId = infoQueryService.fetchSidesId(id, cid, direct);
        ModelAndView mv = this.makeModelView("goPick");
        mv.addObject("id", retId);
        return mv;
    }
}
