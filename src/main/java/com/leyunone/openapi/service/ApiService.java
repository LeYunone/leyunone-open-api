package com.leyunone.openapi.service;

import cn.hutool.core.collection.CollectionUtil;
import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.enums.ApiUrlEnum;
import com.leyunone.openapi.common.enums.ResultCode;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.util.AssertUtil;
import com.leyunone.openapi.util.MyStrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@Service
public class ApiService {

    @Autowired
    private HttpService httpService;

    /**
     * 百度站长APi收录 返回结果
     *
     * @param baiduEmployDTO
     * @return
     */
    public HttpResponse baiduEmploy(BaiduEmployDTO baiduEmployDTO) {
        AssertUtil.isFalse(StringUtils.isEmpty(baiduEmployDTO.getSite()) || StringUtils.isEmpty(baiduEmployDTO.getToken()), 
                ResultCode.TOKEN_SITE_NOT_EXIST);
        AssertUtil.isFalse(CollectionUtil.isEmpty(baiduEmployDTO.getUrls()), ResultCode.PARAM_NOT_EXIST);
        /**
         * 拼接百度Api
         */
        String url = ApiUrlEnum.BAIDU_WEB_EMPLOY.getUrl() + "?site=" + baiduEmployDTO.getSite() + "&token=" + baiduEmployDTO.getToken();
        String urlParam = MyStrUtils.join(baiduEmployDTO.getUrls(),'\n');
        Map<String,String> map = new HashMap<>();
        map.put("Host","data.zz.baidu.com");
        map.put("User-Agent", "curl/7.12.1");
        map.put("Content-Length", "83");
        map.put("Content-Type", "text/plain");
        HttpApiDTO.Post post = HttpApiDTO.builder().url(url).headers(map).build().post();
        post.setData(urlParam);
        HttpService httpService  = new HttpService();
        return httpService.httpPostExecute(post);
    }
}
