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
    public HttpResponse httpPostExecute(HttpApiDTO.Post post) {
        HttpRequest httpr = HttpRequest
                .post(post.getUrl());
        if (CollectionUtil.isNotEmpty(post.getHeaders())) {
            for (String key : post.getHeaders().keySet()) {
                httpr.header(key, post.getHeaders().get(key));
            }
        }
        if (!StringUtils.isEmpty(post.getData())) {
            httpr.body(post.getData());
        }
        String body = httpr.execute().body();
        return HttpResponse.builder().buildSuccess(body);
    }

    /**
     * 执行HTTP - Get
     *
     * @return
     */
    public HttpResponse httpGetExecute() {
        return HttpResponse.builder().buildSuccess();
    }
}
