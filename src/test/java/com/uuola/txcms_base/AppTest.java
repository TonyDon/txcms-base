package com.uuola.txcms_base;

import java.lang.reflect.ParameterizedType;

import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.coder.Md5;
import com.uuola.txweb.framework.action.methods.QueryCallbackHandler;
import com.uuola.txweb.framework.action.methods.UpdateCallbackHandler;
import com.uuola.txweb.framework.dto.PageDTO;
import com.uuola.txweb.framework.dto.ValidateDTO;
import com.uuola.txweb.framework.query.BaseQuery;


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
        
        QueryCallbackHandler<PageDTO> handler = new QueryCallbackHandler<PageDTO>() {

            @Override
            public PageDTO doQuery(BaseQuery query) {
                // TODO Auto-generated method stub
                return new PageDTO();
            }
        };
        ParameterizedType type = (ParameterizedType)(handler.getClass().getGenericInterfaces()[0]);
        System.out.println(handler.getClass().getGenericInterfaces()[0] == QueryCallbackHandler.class);
        System.out.println(((Class<?>)type.getActualTypeArguments()[0]).getName());
        
        MyHandler my = new MyHandler();
        System.out.println(((ParameterizedType)(my.getClass().getGenericInterfaces()[0])).getRawType());
    }
}

@SuppressWarnings("serial")
class MyHandler extends ValidateDTO implements QueryCallbackHandler<PageDTO>, UpdateCallbackHandler<Integer>{

    @Override
    public PageDTO doQuery(BaseQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer doUpdate(ValidateDTO clientDTO) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
