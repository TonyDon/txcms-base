/*
 * @(#)FileResourceWebAccessInterceptor.java 2016年1月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uuola.commons.constant.HTTP_STATUS_CODE;
import com.uuola.txcms.component.WebResourceAccessUtil;


/**
 * <pre>
 * web file 外网访问拦截 主要针对 h5gfile目录
 * @author tangxiaodong
 * 创建日期: 2016年1月3日
 * </pre>
 */
public class FileResourceWebAccessInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String hash = request.getParameter("frwahash");
        if(!WebResourceAccessUtil.checkHash(hash)){
            response.setStatus(HTTP_STATUS_CODE.SC_NOT_FOUND);
            return false;
        }
        return true;
    }
}
