package com.leyunone.openapi.api;

import cn.hutool.core.collection.CollectionUtil;
import com.leyunone.openapi.command.BaiduEmployHandler;
import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.common.vo.BaiduEmployVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@SpringBootTest
public class ApiService {
    
    @Autowired
    private BaiduEmployHandler baiduEmployHandler;

    @Test
    public void baiduEmploy(){
        BaiduEmployDTO baiduEmployDTO = new BaiduEmployDTO();
        baiduEmployDTO.setSite("https://www.leyunone.com");
        baiduEmployDTO.setToken("L16OtyPtqqRWBzKn");
        baiduEmployDTO.setUrls(CollectionUtil.newArrayList("https://www.leyunone.com/algorithm/dynamic-programming.html"
                ,"https://www.leyunone.com/frame/spring/spring-cloud-init.html"));
//        baiduEmployDTO.setSitemapUrl("https://leyunone.com/sitemap.xml");
        BaiduEmployVO handler = baiduEmployHandler.handler(baiduEmployDTO);
        System.out.println(handler.toString());   
    }
}
