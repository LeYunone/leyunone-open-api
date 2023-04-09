package com.leyunone.openapi.common.vo;

import com.leyunone.openapi.common.response.HttpResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaiduEmployVO extends BaseVO{

    private List<String> successUrls;
    
    private HttpResponse httpResponse;
}
