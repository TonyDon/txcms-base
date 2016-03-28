/*
 * @(#)SiteCatLevelService.java 2016年3月28日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import java.util.List;

import com.uuola.txcms.base.entity.SiteCat;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年3月28日
 * </pre>
 */
public interface SiteCatLevelService {

    /**
     * 构建site cat level表
     * @return
     */
    void rebuild(List<SiteCat> cats);
}
