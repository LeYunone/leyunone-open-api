package com.leyunone.openapi.common.dto;

import lombok.Data;

/**
 * @see com.leyunone.openapi.control.GoApiController#iphoneSearch(IphoneSearchDTO) 
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
@Data
public class IphoneSearchDTO extends HttpApiDTO{

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
}
