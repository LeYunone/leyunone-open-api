package com.leyunone.openapi.command;

import cn.hutool.core.collection.CollectionUtil;
import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.enums.ApiUrlEnum;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.common.vo.BaiduEmployVO;
import com.leyunone.openapi.common.vo.BaseVO;
import com.leyunone.openapi.service.HttpService;
import com.leyunone.openapi.util.MyStrUtils;
import com.leyunone.openapi.util.UrlAnalysisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
@Service
public class BaiduEmployHandler extends BaseHandler<BaiduEmployVO,BaiduEmployDTO> {

    @Autowired
    private HttpService httpService;
    
    @Override
    public BaiduEmployVO handler(BaiduEmployDTO baiduEmployDTO) {
        /**
         * 拼接百度Api
         */
        String url = ApiUrlEnum.BAIDU_WEB_EMPLOY.getUrl() + "?site=" + baiduEmployDTO.getSite() + "&token=" + baiduEmployDTO.getToken();
        Map<String, String> map = new HashMap<>();
        map.put("Host", "data.zz.baidu.com");
        map.put("User-Agent", "curl/7.12.1");
        map.put("Content-Length", "83");
        map.put("Content-Type", "text/plain");
        HttpApiDTO post = HttpApiDTO.builder().url(url).headers(map).build();
        List<String> urls = this.baiduEmployUrl(baiduEmployDTO);

        post.setBody(MyStrUtils.join(urls, '\n'));
        HttpResponse httpResponse = httpService.httpPostExecute(post);
        String body = httpResponse.getBody();
        Collections.shuffle(urls);
        if(body.contains("\"message\":\"over quota\"")){
            //超过
            if(CollectionUtil.isNotEmpty(urls) && urls.size()>100){
                //最大100
                urls = urls.subList(0,100);
                post.setBody(MyStrUtils.join(urls,'\n'));
            }
            httpResponse = httpService.httpPostExecute(post);
        }
        return BaiduEmployVO.builder().httpResponse(httpResponse).successUrls(urls).build();
    }

    private List<String> baiduEmployUrl(BaiduEmployDTO baiduEmployDTO) {
        List<String> urlParam = new ArrayList<>();
        if (!StringUtils.isEmpty(baiduEmployDTO.getSitemapUrl())) {
            //解析siteMap,得到url
            List<String> strings = UrlAnalysisUtils.siteMapUrl2Str(baiduEmployDTO.getSitemapUrl());
            if(CollectionUtil.isNotEmpty(strings)){
                urlParam.addAll(strings);
            }
        }
        if (CollectionUtil.isNotEmpty(baiduEmployDTO.getUrls())) {
            urlParam.addAll(baiduEmployDTO.getUrls());
        }
        return urlParam;
    }

}
