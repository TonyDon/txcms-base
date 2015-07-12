/*
 * @(#)SessionUtil.java 2013-11-17
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import com.uuola.txcms.constants.CST_SESSION_NAME;
import com.uuola.txweb.framework.utils.ContextUtil;


/**
 * <pre>
 * 会话工具类
 * @author tangxiaodong
 * 创建日期: 2013-11-17
 * </pre>
 */
public class SessionUtil {

  /**
   * 得到验证码会话对象, 并移除该对象,防止验证码重复使用
   * @return
   */
  public static String getValidCode(){
      HttpServletRequest request = ContextUtil.getHttpServletRequest();
      String vcode = (String)WebUtils.getSessionAttribute(request, CST_SESSION_NAME.VALID_CODE);
      WebUtils.setSessionAttribute(request, CST_SESSION_NAME.VALID_CODE, null);
      return vcode;
  }
  
  /**
   * 设置验证码
   * @param request
   * @param code
   */
  public static void setValidCode(String code){
      HttpServletRequest request = ContextUtil.getHttpServletRequest();
      WebUtils.setSessionAttribute(request, CST_SESSION_NAME.VALID_CODE, code);
  }
  
  /**
   * 得到回话中的管理员对象
   */
  public static Object getAdmin(){
      HttpServletRequest request = ContextUtil.getHttpServletRequest();
      return WebUtils.getSessionAttribute(request, CST_SESSION_NAME.ADMIN_SESS_CODE);
  }
  
  /**
   * 设置管理员对象到回话中
   * @param admin
   */
  public static void setAdmin(Object admin){
      HttpServletRequest request = ContextUtil.getHttpServletRequest();
      WebUtils.setSessionAttribute(request, CST_SESSION_NAME.ADMIN_SESS_CODE, admin);
  }
  
}
