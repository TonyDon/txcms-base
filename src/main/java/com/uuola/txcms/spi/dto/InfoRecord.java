/*
 * @(#)InfoRecord.java 2016年4月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.spi.dto;

import java.util.List;


/**
 * <pre>
 * 信息记录
 * @author tangxiaodong
 * 创建日期: 2016年4月3日
 * </pre>
 */
public class InfoRecord {
    
    private String srcUrl;
    
    private String title ;
    
    private String summary;
    
    private String content;
    
    private Long catId;
    
    private List<String> imgs;
    
    private List<String> remoteImgUrls;
    
    private String videoUrl;

    
    public String getSrcUrl() {
        return srcUrl;
    }


    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getSummary() {
        return summary;
    }

    
    public void setSummary(String summary) {
        this.summary = summary;
    }

    
    public Long getCatId() {
        return catId;
    }


    public void setCatId(Long catId) {
        this.catId = catId;
    }



    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    
    public List<String> getImgs() {
        return imgs;
    }

    
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    
    public List<String> getRemoteImgUrls() {
        return remoteImgUrls;
    }

    
    public void setRemoteImgUrls(List<String> remoteImgUrls) {
        this.remoteImgUrls = remoteImgUrls;
    }

    
    public String getVideoUrl() {
        return videoUrl;
    }


    
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


    @Override
    public String toString() {
        return "InfoRecord [srcUrl=" + srcUrl + ", title=" + title + "]";
    }

    
}
