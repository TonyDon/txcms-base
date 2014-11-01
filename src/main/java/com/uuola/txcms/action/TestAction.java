/*
 * @(#)TestAction.java 2014-4-20
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    }

}
