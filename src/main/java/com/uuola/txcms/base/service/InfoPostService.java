/*
 * @(#)InfoPostService.java 2014年11月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service;

import java.util.List;

import com.uuola.txcms.base.dto.InfoPostDTO;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月23日
 * </pre>
 */
public interface InfoPostService {

    public void save(InfoPostDTO infoPostDTO);

    public Integer markDelete(List<Long> ids);
}
