/*
 * @(#)TestAction.java 2014-4-20
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uuola.txcms.base.dto.InfoDTO;
import com.uuola.txcms.base.entity.InfoBase;
import com.uuola.txcms.component.ConfigUtil;
import com.uuola.txcms.component.SequenceManager;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014-4-20
 * </pre>
 */
@Controller
@RequestMapping("/test")
public class TestAction {
    
    @Autowired
    private SequenceManager sequenceManager;

    @RequestMapping("/show")
    public void show(Model model){
        model.addAttribute("show", this.getClass().getCanonicalName());
        model.addAttribute("seqId", sequenceManager.makeId());
        model.addAttribute("test", (InfoDTO)null);
        model.addAttribute("uuola.site.domain", ConfigUtil.getTextVal("uuola.site.domain"));
        model.addAttribute("maptest", ConfigUtil.getMap("maptest"));
        model.addAttribute("arraytest", ConfigUtil.getArray("arraytest", Integer.class));
        model.addAttribute("listtest", ConfigUtil.getList("listtest", String.class));
        model.addAttribute("listbeantest", ConfigUtil.getList("listbeantest", InfoBase.class));
        model.addAttribute("booleantest", ConfigUtil.getBoolean("booleantest"));
        model.addAttribute("numbertest", ConfigUtil.getNumberVal("numbertest"));
    }

}
