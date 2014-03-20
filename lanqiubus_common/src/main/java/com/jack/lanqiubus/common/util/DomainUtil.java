/**----------------------------------------------------------------
 // Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
 // @project：  ci-common
 // @package: com.pzoom.ads.platform.backend.ci.common.util
 // @className: DomainUtil
 //
 // @author: zhangyunjie
 // @date： 2013-10-22
 // @version: v1.0
 //----------------------------------------------------------------*/
package com.jack.lanqiubus.common.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jack.lanqiubus.core.util.Log;

/**
 * @description:
 */
public class DomainUtil {
    private static final Log log = Log.getLogger(DomainUtil.class);

    static List<String> domainList = new ArrayList<String>();

    static {
        SAXReader reader = new SAXReader(); // 使用SAXReader方式读取XML文件
        Document doc = null;
        try {
            URL url = ConfigManager.class.getClassLoader().getResource("domainDecoderSource.xml");
            doc = reader.read(url.getPath());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 加载XML配置文件，得到Document对象
        Element root = doc.getRootElement(); // 获得根节点
        Iterator iterator = root.elementIterator("domain");
        while (iterator.hasNext()) {
            Element el = (Element) iterator.next();
            domainList.add(el.getText());
        }
    }

    /**
     * 获取顶级域名 顶级域名获取失败，则返回null
     *
     * @param url
     * @return
     */
    public static String getTopDomain(String url) {
        url = url.toLowerCase();
        String httpPrefixx = "http://";
        if (url.startsWith(httpPrefixx)) {
            url = url.substring(httpPrefixx.length(), url.length());
        }
        String[] domainArr = url.split("/");
        if (domainArr.length > 0) {
            String domain = domainArr[0];
            for (String str : domainList) {
                if (domain.endsWith(str)) {
                    String temp = domain.substring(0,
                            domain.length() - str.length());
                    String[] suffixDomain = temp.split("\\.");
                    if (suffixDomain.length > 0) {
                        return suffixDomain[suffixDomain.length - 1] + str;
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * 获取域名，此处域名不进行顶级域名处理
     * @param url
     * @return
     */
    public static String getDomain(String url) {
        url = url.toLowerCase();
        String httpPrefixx = "http://";
        if (url.startsWith(httpPrefixx)) {
            url = url.substring(httpPrefixx.length(), url.length());
        }
        String[] domainArr = url.split("/");
        if (domainArr.length > 0) {
            return domainArr[0];
        }
        return null;
    }

    /**
     * 验证URL合法性
     *
     * @param url
     * @return
     */
    public static boolean checkUrl(String url) {
        if (url == null) {
            return false;
        }
        String regEx = "^([a-zA-Z0-9\\.\\-]+(\\:[a-zA-"
                + "Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{"
                + "2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}"
                + "[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|"
                + "[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-"
                + "4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0"
                + "-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/"
                + "[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*$";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(url);
        return matcher.matches();
    }

    /**
     * 计算是否为顶级域名
     *
     * @param domain
     * @return
     */
    public static boolean isTopDomain(String domain) {
        if (null == domain) {
            return false;
        }
        for (String str : domainList) {
            if (domain.endsWith(str)) {
                String temp = domain.substring(0,
                        domain.length() - str.length());
                if (!temp.contains("."))
                    return true;
                return false;
            }
        }
        return false;
    }
}
