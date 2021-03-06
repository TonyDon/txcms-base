/*
 * @(#)DictConfigAction.java 2015年8月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.JsonUtil;
import com.uuola.txcms.base.dto.DictConfigDTO;
import com.uuola.txcms.base.entity.DictConfig;
import com.uuola.txcms.base.query.DictConfigQuery;
import com.uuola.txcms.base.service.DictConfigService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.IConstant;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.dto.ValidateDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 * 字典配置管理
 * @author tangxiaodong
 * 创建日期: 2015年8月12日
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/dictconfig")
public class DictConfigAction extends BaseAction {

    @Autowired
    private DictConfigService dictConfigService;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        return this.makeModelView("index");
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(DictConfigQuery query, ServletWebRequest webRequest) {
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {
            @Override
            public PageDTO doQuery(BaseQuery query) {
                return dictConfigService.fetchByRange(query);
            }
        });
        return assignViewName(mv, "search");
    }
    
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public ModelAndView post(DictConfigDTO sysConfigDTO, ServletWebRequest webRequest) {
        ModelAndView mv = updateAction(sysConfigDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO dto) {
                dictConfigService.save((DictConfigDTO)dto);
                return true;
            }
        });
        return assignViewName(mv, "post");
    }
    
    /**
     * 展示记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable("id") Long id) {
        DictConfig config = dictConfigService.findById(id);
        return makeModelView("show").addObject("dictConfig", config);
    } 
    
    /**
     * 更新记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable("id") Long id, DictConfigDTO dictConfigDTO ) {
        ModelAndView mv = updateAction(dictConfigDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO dto) {
                return dictConfigService.update((DictConfigDTO)dto);
            }
        });
        return assignViewName(mv, "update");
    } 
    
    /**
     * 删除记录
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        Integer num = dictConfigService.delete(id);
        return makeModelView("delete").addObject("num", num);
    } 
    
    @RequestMapping(value = "/jsonp", method = RequestMethod.GET)
    public ResponseEntity<String> jsonp(
           @RequestParam("dictCode")String dictCode, 
           @RequestParam(IConstant.CALL_BACK_NAME)String callbackName){
        List<DictConfig> dicts = dictConfigService.getDict(dictCode);
        StringBuilder sb = new StringBuilder(callbackName + "(");
        sb.append(JsonUtil.toJSONString(dicts));
        sb.append(")");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "javascript", Charset.forName("UTF-8")));
        ResponseEntity<String> re = new ResponseEntity<String>(sb.toString(), headers, HttpStatus.OK);
        return re;
    }
}
