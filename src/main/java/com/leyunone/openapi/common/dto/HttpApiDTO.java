package com.leyunone.openapi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HttpApiDTO {

    private String url;

    private Map<String, String> headers;

    public HttpApiDTO.Post post() {
        HttpApiDTO.Post po = new HttpApiDTO.Post();
        po.setUrl(this.getUrl());
        po.setHeaders(this.getHeaders());
        return po;
    }
    
    public HttpApiDTO.Get get(){
        HttpApiDTO.Get get = new HttpApiDTO.Get();
        get.setUrl(this.getUrl());
        get.setHeaders(this.getHeaders());
        return get;
    }

    /**
     * Post 请求
     */
    @Data
    public static class Post extends HttpApiDTO {
        /**
         * 值
         */
        private List<String> datas;

        private Map<String, Object> dataMap;

        private String data;

    }

    @Data
    public static class Get extends HttpApiDTO {

        /**
         * 值
         */
        private List<String> params;
        
        private String param;
    }
}

