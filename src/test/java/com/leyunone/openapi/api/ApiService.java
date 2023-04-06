package com.leyunone.openapi.api;

import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.response.HttpResponse;
import org.junit.jupiter.api.Test;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
public class ApiService {

    @Test
    public void baiduEmploy(){
        com.leyunone.openapi.service.ApiService apiService = new com.leyunone.openapi.service.ApiService();
        BaiduEmployDTO baiduEmployDTO = new BaiduEmployDTO();
        baiduEmployDTO.setSite("https://www.leyunone.com");
        baiduEmployDTO.setToken("L16OtyPtqqRWBzKn");
//        baiduEmployDTO.setUrls(CollectionUtil.newArrayList("https://www.leyunone.com/algorithm/dynamic-programming.html"
//                ,"https://www.leyunone.com/frame/spring/spring-cloud-init.html"));
        baiduEmployDTO.setSitemapUrl("https://leyunone.com/sitemap.xml");
        HttpResponse httpResponse = apiService.baiduEmploy(baiduEmployDTO);
        System.out.println(httpResponse.toString());   
    }
}
