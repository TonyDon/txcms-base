/*
 * @(#)CaptchaAction.java 2013-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.action;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uuola.commons.NumberUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.image.ImageVerifier;
import com.uuola.txcms.component.SessionUtil;


/**
 * <pre>
 * 验证码
 * @author tangxiaodong
 * 创建日期: 2013-10-19
 * </pre>
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaAction {
    
    private Color[] fontcolor = {
            new Color(167,208,125),
            new Color(235,25,106),
            new Color(162,111,243),
            new Color(51,187,237)
            };
    
    private Color[] bgcolor = {
            Color.WHITE,
            new Color(234,234,234)
            };
    
    private Font[] font ={ 
            new Font("Tahoma", Font.PLAIN|Font.ITALIC, 28),
            new Font("Arial", Font.BOLD|Font.ITALIC, 26)
        };

    
    
    
    @RequestMapping(value = "/{sid}", method = RequestMethod.GET)
    public void show(@PathVariable("sid")
    String sid, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String randomText = makeRndText();
        SessionUtil.setValidCode(randomText);
        ImageVerifier.outputImage(80, 32, 26, 32, true, true, fontcolor, bgcolor, true, false, randomText,
                font[NumberUtil.genRndInt(0, 2)], "png", response.getOutputStream());
    }

    
    
    
    private String makeRndText() {
        return KeyGenerator.getRndChr(NumberUtil.genRndInt(3, 5), KeyGenerator.NUMBER_MAP);
    }

    
    
    
    
}
