package com.leyunone.openapi.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.response.HttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * HTTP服务
 *
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@Service
public class HttpService {

    /**
     * 执行HTTP - Post
     *
     * @return
     */
    public HttpResponse httpPostExecute(HttpApiDTO post) {
        HttpRequest httpr = HttpRequest
                .post(post.getUrl());
        this.packHttp(httpr,post);
        
        String body = httpr.execute().body();
        return HttpResponse.builder().buildSuccess(body);
    }

    /**
     * 执行HTTP - Get
     *
     * @return
     */
    public HttpResponse httpGetExecute(HttpApiDTO get) {
        HttpRequest httpr = HttpRequest
                .get(get.getUrl());
        this.packHttp(httpr,get);
        
        String body = httpr.execute().body();
        return HttpResponse.builder().buildSuccess(body);
    }
    
    private void packHttp(HttpRequest httpr,HttpApiDTO http){
        if (CollectionUtil.isNotEmpty(http.getHeaders())) {
            for (String key : http.getHeaders().keySet()) {
                httpr.header(key, http.getHeaders().get(key));
            }
        }
        if (!StringUtils.isEmpty(http.getBody())) {
            httpr.body(http.getBody());
        }
        if(CollectionUtil.isNotEmpty(http.getDataMap())){
            httpr.form(http.getDataMap());
        }
    }
}
