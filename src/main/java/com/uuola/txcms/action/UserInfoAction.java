/*
 * @(#)UserInfoAction.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txcms.base.service.UserInfoService;
import com.uuola.txweb.framework.action.BaseQueryAction;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.query.BaseQuery;
import com.uuola.txweb.framework.query.QueryCallbackHandler;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-5
 * </pre>
 */
@Controller
@RequestMapping("/user/info")
public class UserInfoAction extends BaseQueryAction {

    @Autowired
    private UserInfoService userInfoService;
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(UserInfoQuery query, ServletWebRequest webRequest) {

        ModelAndView model = executeQuery(webRequest, query, new QueryCallbackHandler() {

            @Override
            public PageDTO doQuery(BaseQuery query) {
                return userInfoService.fetchByRange(query);
            }

        });
        model.setViewName(this.getViewName("search"));
        return model;

    }

}
