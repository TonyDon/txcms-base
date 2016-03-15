package com.uuola.txcms.base.dict;


public enum TRUE_OR_FALSE {

    T(Byte.valueOf("1")),
    
    F(Byte.valueOf("0"));
    
    private Byte val;
    
    TRUE_OR_FALSE(Byte val){
        this.val = val;
    }
    
    public Byte value(){
        return this.val;
    }
}
