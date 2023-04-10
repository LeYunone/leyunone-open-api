package com.leyunone.openapi.command;

import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.dto.IphoneSearchDTO;
import com.leyunone.openapi.common.response.HttpResponse;
import com.leyunone.openapi.common.vo.IphoneSearchVO;
import com.leyunone.openapi.service.HttpService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
public class IphoneSearchHandler extends BaseHandler<IphoneSearchVO, IphoneSearchDTO> {

    @Autowired
    private HttpService httpService;

    @Override
    public IphoneSearchVO handler(IphoneSearchDTO iphoneSearchDTO) {
        String prePhone = iphoneSearchDTO.getPrePhone().trim();
        String sufPhone = iphoneSearchDTO.getSufPhone().trim();
        //中间位数
        int midCount = 11 - prePhone.length() - sufPhone.length();
        List<String> iphone = new ArrayList<>();
        //TODO 算法优化
        //循环次数
        StringBuilder sb = new StringBuilder();
        StringBuilder numb = new StringBuilder();
        for (int i = 0; i < midCount; i++) {
            sb.append(9);
            numb.append("0");
        }
        Integer count = Integer.parseInt(sb.toString());
        
        //拿到0-count 的数字
        for (int i = 0; i <= count; i++) {
            String s = String.valueOf(i);
            numb.replace(numb.length()-s.length(),numb.length(),s);
            iphone.add(prePhone+numb.toString()+sufPhone);
        }
        HttpResponse httpResponse = null;
        if(0==iphoneSearchDTO.getHttpType()){
            //Get
            HttpApiDTO.Get get = HttpApiDTO.Get.builder().build().get();
            //请求手机归属地查询
            httpResponse = new HttpService().httpGetExecute(get);
        }else{
            //Post
            HttpApiDTO.Post post = HttpApiDTO.Post.builder().build().post();
            httpResponse = new HttpService().httpPostExecute(post);
        }
        
        //过滤掉省会
        String provincial = iphoneSearchDTO.getProvincial();
        //过滤掉城市
        String city = iphoneSearchDTO.getCity();
        String body = httpResponse.getBody();
        List<String> resultIphone = new ArrayList<>();
        if(body.contains(provincial) && body.contains(city)){
            resultIphone.add(body);
        }
        
        return IphoneSearchVO.builder().build();
    }

    public static void main(String[] args) {
        IphoneSearchHandler iphoneSearchHandler = new IphoneSearchHandler();
        IphoneSearchDTO iphoneSearchDTO = new IphoneSearchDTO();
        iphoneSearchDTO.setPrePhone("172672");
        iphoneSearchDTO.setSufPhone("62");
        iphoneSearchHandler.handler(iphoneSearchDTO);
    }
}
