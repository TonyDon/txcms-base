/*
 * @(#)SiteCatLevelServiceImpl.java 2016年3月28日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.commons.CollectionUtil;
import com.uuola.commons.ObjectUtil;
import com.uuola.txcms.base.dao.SiteCatLevelDAO;
import com.uuola.txcms.base.entity.SiteCat;
import com.uuola.txcms.base.entity.SiteCatLevel;
import com.uuola.txcms.base.service.SiteCatLevelService;
import com.uuola.txcms.component.SiteCatUtil;
import com.uuola.txweb.framework.dao.support.TxWebTs;


/**
 * <pre>
 * 类目级别表
 * @author tangxiaodong
 * 创建日期: 2016年3月28日
 * </pre>
 */
@Service
@TxWebTs
public class SiteCatLevelServiceImpl implements SiteCatLevelService {

    @Autowired
    private SiteCatLevelDAO siteCatLevelDAO;
    
    @Override
    public void rebuild(List<SiteCat> cats) {
        if(CollectionUtil.isEmpty(cats)){
            return ;
        }
        siteCatLevelDAO.deleteAll();
        for(SiteCat cat : cats){
            SiteCatLevel scl = extractSiteCatLevel(cat);
            siteCatLevelDAO.save(scl);
        }
    }

    private SiteCatLevel extractSiteCatLevel(SiteCat cat) {
        SiteCatLevel scl = new SiteCatLevel();
        scl.setCatId(cat.getId());
        Long[] cidArr = SiteCatUtil.getCatPathArray(cat.getCatPath());
        if (ObjectUtil.isNotEmpty(cidArr)) {
            int max = Math.min(4, cidArr.length);
            if (max >= 1) {
                scl.setC1(cidArr[0]);
            }
            if (max >= 2) {
                scl.setC2(cidArr[1]);
            }
            if (max >= 3) {
                scl.setC3(cidArr[2]);
            }
            if (max == 4) {
                scl.setC4(cidArr[3]);
            }
        }
        return scl;
    }

}
