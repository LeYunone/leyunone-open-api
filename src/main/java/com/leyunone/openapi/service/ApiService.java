package com.leyunone.openapi.service;

import cn.hutool.core.collection.CollectionUtil;
import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.enums.ApiUrlEnum;
import com.leyunone.openapi.common.enums.ResultCode;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.common.vo.BaiduEmployVO;
import com.leyunone.openapi.util.AssertUtil;
import com.leyunone.openapi.util.MyStrUtils;
import com.leyunone.openapi.util.UrlAnalysisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
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
    public BaiduEmployVO baiduEmploy(BaiduEmployDTO baiduEmployDTO) {
        AssertUtil.isFalse(StringUtils.isEmpty(baiduEmployDTO.getSite()) || StringUtils.isEmpty(baiduEmployDTO.getToken()),
                ResultCode.TOKEN_SITE_NOT_EXIST);
        AssertUtil.isFalse(CollectionUtil.isEmpty(baiduEmployDTO.getUrls()) && StringUtils.isEmpty(baiduEmployDTO.getSitemapUrl()),
                ResultCode.PARAM_NOT_EXIST);
        /**
         * 拼接百度Api
         */
        String url = ApiUrlEnum.BAIDU_WEB_EMPLOY.getUrl() + "?site=" + baiduEmployDTO.getSite() + "&token=" + baiduEmployDTO.getToken();
        Map<String, String> map = new HashMap<>();
        map.put("Host", "data.zz.baidu.com");
        map.put("User-Agent", "curl/7.12.1");
        map.put("Content-Length", "83");
        map.put("Content-Type", "text/plain");
        HttpApiDTO.Post post = HttpApiDTO.builder().url(url).headers(map).build().post();
        List<String> urls = this.baiduEmployUrl(baiduEmployDTO);
        post.setData(MyStrUtils.join(urls,'\n'));
        HttpService httpService = new HttpService();
        HttpResponse httpResponse = httpService.httpPostExecute(post);
        return BaiduEmployVO.builder().httpResponse(httpResponse).successUrls(urls).build();
    }

    private List<String> baiduEmployUrl(BaiduEmployDTO baiduEmployDTO) {
        List<String> urlParam = null;
        if (CollectionUtil.isEmpty(baiduEmployDTO.getUrls()) && !StringUtils.isEmpty(baiduEmployDTO.getSitemapUrl())) {
            //解析siteMap,得到url
            urlParam = UrlAnalysisUtils.siteMapUrl2Str(baiduEmployDTO.getSitemapUrl());
        }
        if (CollectionUtil.isNotEmpty(baiduEmployDTO.getUrls())) {
            urlParam = baiduEmployDTO.getUrls();
        }
        return urlParam;
    }
}
