package com.leyunone.openapi.control;

import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.dto.IphoneSearchDTO;
import com.leyunone.openapi.common.response.DataResponse;
import com.leyunone.openapi.common.vo.BaiduEmployVO;
import com.leyunone.openapi.common.vo.IphoneSearchVO;
import com.leyunone.openapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
     *
     * @return
     */
    @RequestMapping("/baiduemploy")
    public DataResponse<BaiduEmployVO> baiduEmploy(BaiduEmployDTO baiduEmployDTO) {
        BaiduEmployVO baiduEmployVO = apiService.baiduEmploy(baiduEmployDTO);
        return DataResponse.of(baiduEmployVO);
    }

    @RequestMapping("/iphonesearch")
    public DataResponse iphoneSearch(IphoneSearchDTO iphoneSearchDTO) {
        IphoneSearchVO iphoneSearchVO = apiService.iphoneSearch(iphoneSearchDTO);
        return DataResponse.of(iphoneSearchVO);
    }

}
