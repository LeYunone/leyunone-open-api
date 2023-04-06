package com.leyunone.openapi.control;

import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.response.DataResponse;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@RequestMapping("/api")
@RestController
public class GoApiController {
    
    @Autowired
    private ApiService apiService;

    /**
     * 百度收录
     * @return
     */
    @RequestMapping("/baiduemploy")
    public DataResponse baiduEmploy(BaiduEmployDTO baiduEmployDTO) {
        HttpResponse httpResponse = apiService.baiduEmploy(baiduEmployDTO);
        return DataResponse.of(httpResponse);
    }
}
