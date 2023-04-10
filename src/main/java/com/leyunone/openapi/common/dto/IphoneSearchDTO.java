package com.leyunone.openapi.common.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 * @see com.leyunone.openapi.control.GoApiController#iphoneSearch(IphoneSearchDTO)
 */
@Data
public class IphoneSearchDTO extends HttpApiDTO {

    /**
     * 手机号
     */
    private String iphone;

    /**
     * 前缀号码 2? 3? 4?
     */
    private String prePhone;

    /**
     * 后缀号码 2? 3? 4?
     */
    private String sufPhone;

    /**
     * 省会
     */
    private String provincial;

    /**
     * 城市
     */
    private String city;

    /**
     * 0 Get 1 Post
     */
    private Integer httpType = 0;

    /**
     * 请求头参数
     */
    private Map<String,String> headMap = new HashMap<>();

    /**
     * 请求体参数
     */
    private Map<String,Object> dataMap = new HashMap<>();

    /**
     * 请求体
     */
    private String dataBody;
}
