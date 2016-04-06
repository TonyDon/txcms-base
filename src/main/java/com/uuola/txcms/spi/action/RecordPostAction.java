/*
 * @(#)RecordPostAction.java 2016年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.spi.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.CollectionUtil;
import com.uuola.commons.NumberUtil;
import com.uuola.commons.StringUtil;
import com.uuola.txcms.base.dict.INFO_STATE;
import com.uuola.txcms.base.dict.INFO_TYPE;
import com.uuola.txcms.base.dict.TRUE_OR_FALSE;
import com.uuola.txcms.base.dto.InfoPostDTO;
import com.uuola.txcms.base.service.InfoPostService;
import com.uuola.txcms.component.ConfigUtil;
import com.uuola.txcms.constants.CST_SYSCONFIG_NAME;
import com.uuola.txcms.spi.dto.InfoRecord;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.action.IConstant;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.ValidateDTO;


/**
 * <pre>
 * 抓取记录处理接口
 * @author tangxiaodong
 * 创建日期: 2016年4月4日
 * </pre>
 */
@Controller
@RequestMapping("/spi/record")
public class RecordPostAction extends BaseAction {

    @Autowired
    private InfoPostService infoPostService;
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView post(@RequestBody InfoRecord record, WebRequest request) {
        String accessToken = request.getHeader("AccessToken");
        if(!ConfigUtil.getTextVal(CST_SYSCONFIG_NAME.SITE_CRAWLER_ACCESS_TOKEN).equals(accessToken)){
            ModelAndView mv = new ModelAndView();
            return mv.addObject(IConstant.UPDATE_RESULT_ATTR, false);
        }
        InfoPostDTO infoDTO = makeInitInfoDTO(record);
        ModelAndView mv = updateAction(infoDTO, new UpdateCallbackHandler<Boolean>() {
            @Override
            public Boolean doUpdate(ValidateDTO infoPostDTO) {
                try {
                    infoPostService.save((InfoPostDTO) infoPostDTO);
                } catch (Exception e) {
                    log.error("", e);
                    return false;
                }
                return true;
            }
        });
        return mv;
    }

    private InfoPostDTO makeInitInfoDTO(InfoRecord record) {
        InfoPostDTO info = new InfoPostDTO();
        info.setAuthorId(10004L);
        info.setTitle(record.getTitle());
        info.setSummary(record.getSummary());
        info.setInfoType(INFO_TYPE.CONTENT.value());
        info.setHasPic(TRUE_OR_FALSE.F.value());
        info.setHasVideo(TRUE_OR_FALSE.F.value());
        info.setCatId(record.getCatId());
        info.setInfoState(INFO_STATE.WAIT_AUDIT.value());
        info.setLoveNum((long) NumberUtil.genRndInt(10, 30));
        info.setHateNum((long) NumberUtil.genRndInt(5, 10));
        info.setViewNum((long) NumberUtil.genRndInt(80, 100));
        if(StringUtil.isNotEmpty(record.getContent())){
            info.setContent(record.getContent());
        }
        if(CollectionUtil.isNotEmpty(record.getRemoteImgUrls())){
            info.setPicUrl(record.getRemoteImgUrls().get(0));
            info.setHasPic(TRUE_OR_FALSE.T.value());
            if(record.getRemoteImgUrls().size()>1){
                //TODO add content html
            }
        }
        if(StringUtil.isNotEmpty(record.getVideoUrl())){
            info.setVideoUrl(record.getVideoUrl());
            info.setHasVideo(TRUE_OR_FALSE.T.value());
        }
        if(StringUtil.isNotEmpty(record.getSrcUrl())){
            info.setSiteUrl(record.getSrcUrl());
        }
        
        return info;
    }
}
