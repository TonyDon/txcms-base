package com.uuola.txcms_base;

import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.coder.Md5;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
 
    public static void main(String... args){
        String hash = Md5.encode("0198");
        System.out.println(hash);
        System.out.println(Md5.encode(hash + KeyGenerator.getRndChr(8)));
        System.out.println(Math.ceil((double)5/(double)3));
    }
}
