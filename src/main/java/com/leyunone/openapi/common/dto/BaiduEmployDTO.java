package com.leyunone.openapi.common.dto;

import lombok.Data;

import java.util.List;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@Data
public class BaiduEmployDTO extends HttpApiDTO {

    private String token;
    
    private String site;
    
    private List<String> urls;
}
