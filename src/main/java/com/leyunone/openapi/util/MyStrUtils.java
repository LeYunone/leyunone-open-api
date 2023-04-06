package com.leyunone.openapi.util;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.Collection;

/**
 * 二次封装各包下的StringUtils
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
public class MyStrUtils {

    public static String join(Collection<String> collections, char seq){
        return StringUtils.join(collections,seq);
    }
    
}
