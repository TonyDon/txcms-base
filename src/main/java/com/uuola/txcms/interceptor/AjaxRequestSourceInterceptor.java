/*
 * @(#)AjaxRequestSourceInterceptor.java 2016年3月20日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uuola.commons.StringUtil;
import com.uuola.commons.constant.HTTP_STATUS_CODE;


/**
 * <pre>
 * ajax 请求来源拦截检查
 * @author tangxiaodong
 * 创建日期: 2016年3月20日
 * </pre>
 */
public class AjaxRequestSourceInterceptor extends HandlerInterceptorAdapter {

    private Map<String, String> checkHeaders;
    
    private final String HEADER_REFERER = "Referer";
    private final String HEADER_X_REQUESTED_WITH = "X-Requested-With";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String referer = request.getHeader(HEADER_REFERER);
        String xRequestedWith = request.getHeader(HEADER_X_REQUESTED_WITH);
        if (StringUtil.isNotEmpty(referer) && StringUtil.isNotEmpty(xRequestedWith)) {
            String cReferer = checkHeaders.get(HEADER_REFERER);
            String cXRequestedWith = checkHeaders.get(HEADER_X_REQUESTED_WITH);
            int refererPos = referer.indexOf(cReferer);
            if (null != cReferer && null != cXRequestedWith && (refererPos >= 0 && refererPos < 16)
                    && cXRequestedWith.equalsIgnoreCase(xRequestedWith)) {
                return true;
            }else{
                response.setStatus(HTTP_STATUS_CODE.SC_NOT_FOUND);
                return false;
            }
        }
        response.setStatus(HTTP_STATUS_CODE.SC_NOT_FOUND);
        return false;
    }

    public Map<String, String> getCheckHeaders() {
        return checkHeaders;
    }

    public void setCheckHeaders(Map<String, String> checkHeaders) {
        this.checkHeaders = checkHeaders;
    }

}
