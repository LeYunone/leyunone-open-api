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
    
    private String body;

    private Map<String, Object> dataMap;

}

