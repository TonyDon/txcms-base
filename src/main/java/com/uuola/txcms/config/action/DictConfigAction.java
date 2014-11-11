/*
 * @(#)DictConfigAction.java 2014-11-8
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.config.action;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
 * 系统字典操作
 * @author tangxiaodong
 * 创建日期: 2014-11-8
 * </pre>
 */
@Controller
@RequestMapping("/config/dict")
public class DictConfigAction extends BaseAction {

    @Autowired
    private DictConfigService dictConfigService;
    
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
    
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView add(DictConfigDTO sysConfigDTO, ServletWebRequest webRequest) {
        ModelAndView mv = updateAction(sysConfigDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO dto) {
                dictConfigService.save((DictConfigDTO)dto);
                return true;
            }
        });
        return assignViewName(mv, "add");
    }
    
    @RequestMapping(value = "/jsonp", method = RequestMethod.GET)
    public ResponseEntity<String> jsonp(
           @RequestParam(value = "dictCode")String dictCode, 
           @RequestParam(value = IConstant.CALL_BACK_NAME)String callbackName){
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
