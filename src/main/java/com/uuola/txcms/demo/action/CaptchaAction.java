/*
 * @(#)CaptchaAction.java 2013-10-19
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.demo.action;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uuola.commons.NumberUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.coder.Md5;
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
        // 随机字符加密验证码明文
        String rndChar = KeyGenerator.getRndChr(32);
        SessionUtil.setValidCode(randomText);
        response.addCookie(makeRndCharCookie(rndChar));
        response.addCookie(makeCaptchaHashTextCookie(randomText, rndChar));
        ImageVerifier.outputImage(80, 32, 26, 32, true, true, fontcolor, bgcolor, false, false, randomText,
                font[NumberUtil.genRndInt(0, 2)], "png", response.getOutputStream());
    }

    
    private String makeRndText() {
        return KeyGenerator.getRndChr(NumberUtil.genRndInt(3, 5), KeyGenerator.LETTER_NUMBER_MAP);
    }
    
    private Cookie makeCaptchaHashTextCookie(String randomText, String rndChar){
        Cookie captchaHashTextCookie = new Cookie("cc_hash", Md5.encode(randomText.toLowerCase().concat(rndChar)));
        captchaHashTextCookie.setPath("/");
        captchaHashTextCookie.setMaxAge(-1);
        return captchaHashTextCookie;
    }
    
    private Cookie makeRndCharCookie(String rndChar){
        Cookie rndCharCookie = new Cookie("cc_rc", rndChar);
        rndCharCookie.setPath("/");
        rndCharCookie.setMaxAge(-1);
        return rndCharCookie;
    }

    
    
    
    
}
