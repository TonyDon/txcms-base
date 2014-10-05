/*
 * @(#)UserInfoAction.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.action;

import java.util.ArrayList;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;

import com.uuola.commons.constant.HTTP_STATUS_CODE;
import com.uuola.commons.exception.BusinessException;
import com.uuola.commons.exception.BusinessExceptionMessageProvider;
import com.uuola.txcms.base.query.UserInfoQuery;
import com.uuola.txcms.base.service.UserInfoService;
import com.uuola.txweb.framework.action.BaseQueryAction;
import com.uuola.txweb.framework.dto.PageDTO;


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
    public void query(UserInfoQuery query, 
            @ModelAttribute(ERRORS_ATTR)ArrayList<String> errors, 
            ServletWebRequest webRequest,
            Model model) {
        
        if (!preValidQuery(query, errors)) {
            webRequest.getResponse().setStatus(HTTP_STATUS_CODE.SC_BAD_REQUEST);
            return ;
        }
        
        query.filter();
        query.calcCurrRowIndex();
        
        try {
            PageDTO   pageDTO = userInfoService.fetchByRange(query);
            model.addAttribute("page", pageDTO);
        } catch (BusinessException be) {
            errors.add(BusinessExceptionMessageProvider.getMessage(be));
        } catch (Exception e) {
            errors.add(ExceptionUtils.getFullStackTrace(e));
        }
        
        if (!errors.isEmpty()) {
            webRequest.getResponse().setStatus(HTTP_STATUS_CODE.SC_BZ_ERROR);
        }
    }

}
