/*
 * @(#)UserAccessActionInterceptor.java 2014-4-20
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uuola.txcms.component.SessionUtil;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-4-20
 * </pre>
 */
public class ManagerAccessActionInterceptor extends HandlerInterceptorAdapter {
    
    private String redirectUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod && null == SessionUtil.getUser()){
            response.sendRedirect(request.getContextPath() + redirectUrl);                 
            return false;
        }
        return true;
    }

    
    public String getRedirectUrl() {
        return redirectUrl;
    }

    
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
