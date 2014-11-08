/*
 * @(#)UserInfoAction.java 2014-10-5
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.txcms.base.dto.UserInfoDTO;
import com.uuola.txcms.base.entity.UserInfo;
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
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<PageDTO>() {
            @Override
            public PageDTO doQuery(BaseQuery query) {
                return userInfoService.fetchByRange(query);
            }
        });
        return assignViewName(mv, "search");
    }
    
    /**
     * 添加用户信息
     * @param userInfoDTO
     * @param webRequest
     * @return
     */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView add(UserInfoDTO userInfoDTO, ServletWebRequest webRequest) {
        ModelAndView mv = updateAction(userInfoDTO, new UpdateCallbackHandler<Object>() {
            @Override
            public Object doUpdate(ValidateDTO userInfoDTO) {
                userRegService.saveNewUserInfo((UserInfoDTO)userInfoDTO);
                return null;
            }
        });
        
        // 重置关键属性为null
        userInfoDTO.reset();
        return assignViewName(mv, "add");
    }

    
    /**
     * 删除记录
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        Integer num = userInfoService.delete(id);
        return makeModelView("delete").addObject("num", num);
    }
    
    /**
     * 展示用户信息
     * @param id
     * @param query
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable("id") String id, UserInfoQuery query){
        query.setName(id);
        ModelAndView mv = queryAction(query, new QueryCallbackHandler<UserInfo>() {

            @Override
            public UserInfo doQuery(BaseQuery query) {
                return userInfoService.fetchSingle((UserInfoQuery)query);
            }
            
        });
        return assignViewName(mv, "show");
    }
    

}
