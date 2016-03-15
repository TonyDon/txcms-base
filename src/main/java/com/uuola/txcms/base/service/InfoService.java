/*
 * @(#)InfoService.java 2015年4月4日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import com.uuola.txcms.base.dto.InfoDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2015年4月4日
 * </pre>
 */
public interface InfoService {

    /**
     * 获取info记录
     * @param id
     * @return
     */
    InfoDTO fetchById(Long id);
    
    /**
     * 获取未删除的info记录
     * @param id
     * @return
     */
    InfoDTO fetchEffective(Long id);

    /**
     * 调整浏览次数
     * @param id
     * @param diffNum
     */
    void adjustViewNum(Long id, Long diffNum);

}
