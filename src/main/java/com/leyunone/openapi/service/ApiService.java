package com.leyunone.openapi.service;

import cn.hutool.core.collection.CollectionUtil;
import com.leyunone.openapi.command.BaiduEmployHandler;
import com.leyunone.openapi.command.BaseHandler;
import com.leyunone.openapi.command.ExecuteHandler;
import com.leyunone.openapi.command.IphoneSearchHandler;
import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.dto.IphoneSearchDTO;
import com.leyunone.openapi.common.enums.ApiUrlEnum;
import com.leyunone.openapi.common.enums.ResultCode;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.common.vo.BaiduEmployVO;
import com.leyunone.openapi.common.vo.IphoneSearchVO;
import com.leyunone.openapi.support.factory.CommandFacotry;
import com.leyunone.openapi.util.AssertUtil;
import com.leyunone.openapi.util.MyStrUtils;
import com.leyunone.openapi.util.UrlAnalysisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@Service
public class ApiService {

    @Autowired
    private ExecuteHandler executeHandler;

    /**
     * 百度站长APi收录 返回结果
     *
     * @param baiduEmployDTO
     * @return
     */
    public BaiduEmployVO baiduEmploy(BaiduEmployDTO baiduEmployDTO) {
        AssertUtil.isFalse(StringUtils.isEmpty(baiduEmployDTO.getSite()) || StringUtils.isEmpty(baiduEmployDTO.getToken()),
                ResultCode.TOKEN_SITE_NOT_EXIST);
        AssertUtil.isFalse(CollectionUtil.isEmpty(baiduEmployDTO.getUrls()) && StringUtils.isEmpty(baiduEmployDTO.getSitemapUrl()),
                ResultCode.PARAM_NOT_EXIST);
        return executeHandler.execute(BaiduEmployVO.class, BaiduEmployHandler.class, baiduEmployDTO);
    }


    public IphoneSearchVO iphoneSearch(IphoneSearchDTO iphoneSearchDTO) {
        AssertUtil.isFalse(StringUtils.isEmpty(iphoneSearchDTO.getPrePhone()) || StringUtils.isEmpty(iphoneSearchDTO.getSufPhone()),
                ResultCode.PARAM_NOT_EXIST);
        
        return executeHandler.execute(IphoneSearchVO.class, IphoneSearchHandler.class, iphoneSearchDTO);
    }
}
