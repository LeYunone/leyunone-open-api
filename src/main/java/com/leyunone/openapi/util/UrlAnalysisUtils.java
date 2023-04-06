package com.leyunone.openapi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
public class UrlAnalysisUtils {

    private static Logger logger = LoggerFactory.getLogger(UrlAnalysisUtils.class);

    /**
     * 提取sitemap.xml url地址
     *
     * @return
     */
    public static List<String> siteMapUrl2Str(String siteMapUrl) {
        List<String> urls = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(siteMapUrl);
            NodeList urlList = document.getElementsByTagName("url");
            int urlCnt = urlList.getLength();
            logger.info("=====sitemapurl:{},======urlcount:{}", siteMapUrl, urlCnt);
            for (int i = 0; i < urlCnt; i++) {
                Node url = urlList.item(i);
                NodeList childNodes = url.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    String nodeName = childNodes.item(k).getTextContent().trim();
                    if ("loc".equals(childNodes.item(k).getNodeName()) && nodeName.endsWith("html")) {
                        String resUrl = nodeName;
                        if (nodeName.startsWith("http://") && !nodeName.contains("www")) {
                            nodeName = nodeName.substring(7);
                            resUrl = "http://www.";
                            resUrl = resUrl.concat(nodeName);
                        }
                        urls.add(resUrl);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urls;
    }
}
