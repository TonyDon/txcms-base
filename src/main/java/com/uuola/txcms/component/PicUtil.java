/*
 * @(#)PicUtil.java 2016年4月1日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.txcms.component;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2016年4月1日
 * </pre>
 */
public abstract class PicUtil {

    /**
     * 给图片地址转换为缩图地址
     * eg: abc.jpg , w120 -> abc.w120.jpg
     * @param orgPic
     * @param thumbWidthFlag
     * @return
     */
    public static String getPicThumbUrl(String picUrl, String thumbWidthFlag) {
        if (null == picUrl) {
            return "https://img.alicdn.com/imgextra/i2/152137799/T2jXVgXgdOXXXXXXXX_!!152137799.gif"; // blank.gif
        }
        int pos = picUrl.lastIndexOf('.');// abc.jpg
        if (pos < 0) {
            return "https://img.alicdn.com/imgextra/i2/152137799/T2jXVgXgdOXXXXXXXX_!!152137799.gif"; // blank.gif
        }
        String pre = picUrl.substring(0, pos);// abc
        String ext = picUrl.substring(pos + 1); // jpg
        return pre.concat(".").concat(thumbWidthFlag).concat(".").concat(ext);
    }
}
