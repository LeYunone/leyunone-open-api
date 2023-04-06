package com.leyunone.openapi.common.response;

import cn.hutool.http.HttpResource;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * HTTP返回参
 *
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@Data
@ToString
public class HttpResponse {

    /**
     * 返回体
     */
    private String body;
    /**
     * 状态码
     */
    private Integer status;

    public HttpResponse() {
    }

    public HttpResponse(String body, Integer status) {
        this.body = body;
        this.status = status;
    }

    public static HttpResponseBuild builder() {
        return new HttpResponse.HttpResponseBuild();
    }

    public static class HttpResponseBuild {
        private String body;
        private Integer status;

        public HttpResponse.HttpResponseBuild body(String body) {
            this.body = body;
            return this;
        }

        public HttpResponse.HttpResponseBuild status(Integer status) {
            this.status = status;
            return this;
        }

        public HttpResponse buildSuccess(String body) {
            return new HttpResponse(body, 200);
        }

        public HttpResponse buildSuccess() {
            return new HttpResponse("success", 200);
        }

        public HttpResponse buildFail(String body) {
            return new HttpResponse(body, 500);
        }

        public HttpResponse buildFail(String body, Integer status) {
            return new HttpResponse(body, status);
        }
    }
}
