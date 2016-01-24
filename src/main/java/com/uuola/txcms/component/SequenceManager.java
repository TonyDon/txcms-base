/*
 * @(#)SequenceManager.java 2014-10-30
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;

import java.util.List;

import org.springframework.util.Assert;

import com.uuola.commons.NumberUtil;
import com.uuola.commons.coder.SequenceBuilder;


/**
 * <pre>
 * 序列ID管理器,最多可配置9个SequenceBuilder
 * @author tangxiaodong
 * 创建日期: 2014-10-30
 * </pre>
 */
public class SequenceManager {

    private List<SequenceBuilder> sequenceBuilders ;
    
    private int sequenceBuilderCount = 0;
    
    private int multiples = 10 ;
    
    public SequenceManager(List<SequenceBuilder> sequenceBuilders) {
        Assert.notNull(sequenceBuilders, "At least one SequenceBuilder !");
        this.sequenceBuilders = sequenceBuilders;
        this.sequenceBuilderCount = sequenceBuilders.size();
        if (this.sequenceBuilderCount > 9 || this.sequenceBuilderCount == 0) {
            throw new IllegalArgumentException("Sequence Builders count at 1 ~ 9 !");
        }
    }
    
    /**
     * 随机获取ID
     * @return
     */
    public long makeId() {
        int index = NumberUtil.genRndInt(0, this.sequenceBuilderCount);
        return (this.sequenceBuilders.get(index).getSid() * multiples) + index + 1;
    }
    
    /**
     * 根据text.hashCode获取对应的ID
     * @param text
     * @return
     */
    public long makeId(String text) {
        int index = Math.abs(text.hashCode()) % this.sequenceBuilderCount;
        return (this.sequenceBuilders.get(index).getSid() * multiples) + index + 1;
    }
}
