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

import com.uuola.txcms.base.dto.UserInfoDTO;
import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txcms.base.service.UserInfoService;
import com.uuola.txcms.base.service.UserRegService;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.dto.ValidateDTO;
import com.uuola.txweb.framework.query.BaseQuery;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-10-5
 * </pre>
 */
@Controller
@RequestMapping("/user/info")
public class UserInfoAction extends BaseAction {

    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private UserRegService userRegService;
    
    /**
     * 查询用户信息
     * @param query
     * @param webRequest
     * @return
     */
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
    
    /**
     * 添加用户信息
     * @param userInfoDTO
     * @param webRequest
     * @return
     */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView add(UserInfoDTO userInfoDTO, ServletWebRequest webRequest) {
        ModelAndView model = executeUpdate(webRequest, userInfoDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO userInfoDTO) {
                userRegService.saveNewUserInfo((UserInfoDTO)userInfoDTO);
                return null;
            }
        });
        
        // 重置关键属性为null
        userInfoDTO.reset();
        model.setViewName(getViewName("add"));
        return model;
    }

}
