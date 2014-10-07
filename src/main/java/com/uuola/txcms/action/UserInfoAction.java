/*
 * @(#)UserInfoAction.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.constant.HTTP_STATUS_CODE;
import com.uuola.commons.exception.BusinessException;
import com.uuola.commons.exception.BusinessExceptionMessageProvider;
import com.uuola.txcms.base.dto.UserInfoDTO;
import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txcms.base.service.UserInfoService;
import com.uuola.txcms.base.service.UserRegService;
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
        ModelAndView model = new ModelAndView();
        List<String> errors = new ArrayList<String>();
        if (!userInfoDTO.validatePass()) {
            errors.addAll(getErrors(userInfoDTO));
        } else {
            // 保存用户基本信息
            try {
                userRegService.saveNewUserInfo(userInfoDTO);
            }catch(BusinessException be){
                errors.add(BusinessExceptionMessageProvider.getMessage(be));
            }catch(Exception e){
                errors.add(ExceptionUtils.getFullStackTrace(e));
            }
        }
        // 重置属性为null
        userInfoDTO.reset();
        model.addObject(ERRORS_ATTR, errors);
        model.setViewName(getViewName("add"));
        
        if(!errors.isEmpty()){
            webRequest.getResponse().setStatus(HTTP_STATUS_CODE.SC_BZ_ERROR);
        }
        
        return model;
    }

}
