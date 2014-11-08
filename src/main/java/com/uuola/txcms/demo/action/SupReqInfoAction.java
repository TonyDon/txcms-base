/*
 * @(#)SupReqInfoAction.java 2013-12-15
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uuola.txcms.base.dto.SupReqInfoDTO;
import com.uuola.txcms.base.entity.SupReqInfo;
import com.uuola.txcms.base.service.SupReqInfoService;
import com.uuola.txcms.component.CaptchaValidator;
import com.uuola.txcms.constants.CST_ERROR_MSG;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.IConstant;


/**
 * <pre>
 * 供求信息
 * @author tangxiaodong
 * 创建日期: 2013-12-15
 * </pre>
 */
@Controller
@RequestMapping("/supReq/info")
public class SupReqInfoAction extends BaseAction {

    @Autowired
    private SupReqInfoService supReqInfoService;
    
    /**
     * 保存客户端提交的供求信息
     * @param supReqInfoDTO
     * @param errors
     */
    @RequestMapping(method=RequestMethod.POST)
    public void post(SupReqInfoDTO supReqInfoDTO, @ModelAttribute(IConstant.VALID_ERRORS_ATTR) 
    ArrayList<String> errors){
        if (!CaptchaValidator.isMatch(supReqInfoDTO.getCaptcha())) {
            errors.add(CST_ERROR_MSG.CAPTCHA_ERROR);
        } else  if (!supReqInfoDTO.validatePass()) {
            errors.addAll(getErrors(supReqInfoDTO));
        } else {
            // 保存用供求信息
            supReqInfoService.save(supReqInfoDTO);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(Serializable id, Model model) {
        SupReqInfo info =  supReqInfoService.getInfoById(parseId(id));
        model.addAttribute("supReqInfo", info);
        return this.getViewName("show");
    }
    
    /**
     * 列表展示
     * @param p
     * @param model
     * @return
     */
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(@RequestParam(value="p", required=false, defaultValue="1") Integer p, Model model){
        int pageNo = p.intValue();
        int rowSize = 5;
        int startIndex = (pageNo-1) * rowSize ;
        model.addAttribute("list", supReqInfoService.getBatchInfos(startIndex, rowSize));
        return this.getViewName("list");
    }
}
