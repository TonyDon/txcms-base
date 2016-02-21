/*
 * @(#)WebGameAction.java 2015年11月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import java.io.File;
import java.util.Calendar;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.DateUtil;
import com.uuola.commons.StringUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.constant.CST_CHAR;
import com.uuola.commons.file.FileUtil;
import com.uuola.commons.packzip.ZipUtil;
import com.uuola.txcms.constants.CST_ERROR_MSG;
import com.uuola.txweb.framework.action.BaseAction;
import com.uuola.txweb.framework.utils.ContextUtil;


/**
 * <pre>
 * WEB游戏<br/>
 * @author tangxiaodong
 * 创建日期: 2015年11月3日
 * </pre>
 */
@Controller
@RequestMapping("/manager/app/webgame")
public class WebGameAction extends BaseAction {
    
    private final String UPLOAD_ROOT_DIR = "/h5gfile";
    
    private final String GAME_TPL_NAME = "_index.hgt";
    
    private final String OUT_GAME_INDEX = "index.html";
    
    // 删除路径合法性正则 /h5gfile/2016/01/01/a1234567b1234567 
    private final Pattern REGEX_URL_VALID = Pattern.compile(UPLOAD_ROOT_DIR + "/\\d{4}/\\d{2}/\\d{2}/\\w{16}");

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        return this.makeModelView("index");
    }
    
    @RequestMapping(value="/addpage", method=RequestMethod.GET)
    public String addPage(){
        return this.getViewName("addpage");
    }
    
    @RequestMapping(value="/initupload", method=RequestMethod.GET)
    public String initUpload(){
        return this.getViewName("initupload");
    }
    
    /**
     * 上传H5 GAME 游戏ZIP包
     * @param zipFile
     * @return
     */
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam(value = "zipfile") MultipartFile zipFile) {
        if (null == zipFile || zipFile.getSize() == 0) {
            return getModel(null, CST_ERROR_MSG.UPLOAD_FILE_SIZE_EMPTY, 1);
        }
        String fileName = zipFile.getOriginalFilename();
        String extName = FileUtil.getFileExt(fileName);
        if (!"zip".equalsIgnoreCase(extName)) {
            return getModel(null, CST_ERROR_MSG.EXT_NAME_INVALID, 1);
        }
        Calendar cal = Calendar.getInstance();
        String dateDir = String.format("/%s/%d/", Integer.toHexString(DateUtil.getYear(cal)), DateUtil.getDayInYear(cal));
        // /7e0/72/RndChr(16)
        String dirPath = dateDir.concat(KeyGenerator.getRndChr(16));
        String url = null;
        try {
            String urlPath = UPLOAD_ROOT_DIR.concat(dirPath);//  /h5gfile/7e0/72/RndChr(16)
            String distDir = ContextUtil.getRealPath(UPLOAD_ROOT_DIR).concat(dirPath);
            FileUtil.createNoExistsDirs(distDir);
            File dist = new File(distDir, fileName); // .../h5gfile/7e0/72/RndChr(16)/leidian.zip
            zipFile.transferTo(dist);
            url = resovleGameZip(dist, new File(distDir), urlPath);
        } catch (Exception e) {
            log.error("upload()", e);
        }
        return getModel(url, null, 0);
    }
    
    @RequestMapping(value="/removeupload", method = RequestMethod.GET)
    public String removeUpload(@RequestParam(value = "url") String url){
        if(null != url && url.indexOf(UPLOAD_ROOT_DIR)==0 && url.indexOf("..")<0 && 
                REGEX_URL_VALID.matcher(url).matches()){
            try{
                FileUtil.deleteDirs(ContextUtil.getRealPath(url));
            }catch(Exception e){
                // ignore 
            }
        }
        return this.getViewName("removeupload");
    }
    
    /**
     * 解压文件,读取模版 _index.ga 生成index.html,删除ZIP文件<br/>
     * 返回index.html url地址
     * @param dist
     * @param outDir
     * @param urlPath
     * @return
     */
    private String resovleGameZip(File dist, File outDir, String urlPath) {
        ZipUtil.unpack(dist, outDir, "utf-8");
        String outDirPath = outDir.getAbsolutePath();
        String zipFileName = FileUtil.getBaseName(dist.getAbsolutePath());
        // eg : \h5gfile\2015\12\31\gh\leidian
        String gamePackPath = outDirPath.concat(File.separator).concat(zipFileName);
        String indexTplPath = gamePackPath.concat(File.separator).concat(GAME_TPL_NAME);
        String indexHtmPath = gamePackPath.concat(File.separator).concat(OUT_GAME_INDEX);
        // 替换模版内容生成html
        String tplText = FileUtil.readStringByFile(indexTplPath, "utf-8");
        if(StringUtil.isNotEmpty(tplText)){
            FileUtil.writeStringToFile(indexHtmPath, parseHtml(tplText));
        }
        FileUtil.delete(dist);
        // return : /h5gfile/2015/12/31/gh/leidian/
        return urlPath.concat(CST_CHAR.STR_SLASH).concat(zipFileName).concat(CST_CHAR.STR_SLASH);
    }

    /**
     * 转换tpl html，修改title, 插入JS代码等
     * @param tplText
     * @return
     */
    private String parseHtml(String tplText) {
        Document doc = Jsoup.parse(tplText);
        Element title = doc.select("title").first();
        String titleText = null;
        if(null != title){
             titleText = title.text();
             title.text(titleText + "-986001娱乐在线");
        }else{
            Element head = doc.getElementsByTag("head").first();
            head.prepend("<title>小游戏-986001娱乐在线</title>");
        }
        Element body = doc.body();
        body.append("<span>js 代码插入</span>");
        return doc.html();
    }

    /**
     * 上传结果返回model定义
     * @param url
     * @param messsge
     * @param error
     * @return
     */
    private ModelAndView getModel(String url, String messsge, Integer error) {
        ModelAndView mv = this.makeModelView("upload");
        mv.addObject("url", url);
        mv.addObject("message", messsge);
        mv.addObject("error", error);
        return mv;
    }
}
