/*
 * @(#)WebGameAction.java 2015年11月3日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.manager.action;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.commons.DateUtil;
import com.uuola.commons.StringUtil;
import com.uuola.commons.coder.KeyGenerator;
import com.uuola.commons.constant.CST_CHAR;
import com.uuola.commons.constant.CST_DATE_FORMAT;
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

    @RequestMapping(value="/addpage", method=RequestMethod.GET)
    public String addPage(){
        return this.getViewName("addpage");
    }
    
    /**
     * 上传H5 GAME 游戏ZIP包
     * @param zipFile
     * @return
     */
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam(value = "zipfile") MultipartFile zipFile) {
        // TODO
        if (null == zipFile || zipFile.getSize() == 0) {
            return getModel(null, CST_ERROR_MSG.UPLOAD_FILE_SIZE_EMPTY, 1);
        }
        String fileName = zipFile.getOriginalFilename();
        String extName = FileUtil.getFileExt(fileName);
        if (!"zip".equalsIgnoreCase(extName)) {
            return getModel(null, CST_ERROR_MSG.EXT_NAME_INVALID, 1);
        }
        // 保存文件路径
        String dateDir = DateUtil.formatDate(new Date(), CST_DATE_FORMAT.YYYYsMMsDD);
        // dirPath : /2015/12/31/gh
        String dirPath = CST_CHAR.STR_SLASH.concat(dateDir).concat(CST_CHAR.STR_SLASH).concat(KeyGenerator.getRndChr(4));
        String url = null;
        try {
            //  /h5gfile/2015/12/31/gh
            String urlPath = UPLOAD_ROOT_DIR.concat(dirPath);
            String distDir = ContextUtil.getRealPath(UPLOAD_ROOT_DIR).concat(dirPath);
            FileUtil.createNoExistsDirs(distDir);
            // TODO 解压文件
            // TODO 读取模版 _index.ga 生成index.html
            // TODO 删除ZIP文件
            // TODO 返回index.html url地址
            File dist = new File(distDir, fileName); // .../h5gfile/2015/12/31/gh/leidian.zip
            zipFile.transferTo(dist);
            url = resovleGameZip(dist, new File(distDir), urlPath); // .../h5gfile/2015/12/31/gh/leidian/index.html
        } catch (Exception e) {
            log.error("upload()", e);
        }
        return getModel(url, null, 0);
    }
    
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
            FileUtil.writeStringToFile(indexHtmPath, StringUtils.replace(tplText, "<#IncludePage#>", "<b>test</b>"));
        }
        FileUtil.delete(dist);
        // return : /h5gfile/2015/12/31/gh/leidian/index.html
        return urlPath.concat(CST_CHAR.STR_SLASH).concat(zipFileName).concat(CST_CHAR.STR_SLASH).concat(OUT_GAME_INDEX);
    }

    /**
     * 保存游戏信息
     * @return
     */
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(){
        return null;
    }
    
    private ModelAndView getModel(String url, String messsge, Integer error) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", url);
        mv.addObject("message", messsge);
        mv.addObject("error", error);
        return mv;
    }
}
