package com.leyunone.openapi.command;

import com.leyunone.openapi.common.dto.IphoneSearchDTO;
import com.leyunone.openapi.common.vo.IphoneSearchVO;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.*;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
public class IphoneSearchHandler extends BaseHandler<IphoneSearchVO, IphoneSearchDTO> {

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
        for (int i = 0; i < midCount; i++) {
            sb.append(9);
        }
        Integer count = Integer.parseInt(sb.toString());

        char num[] = new char[midCount];
        Arrays.fill(num, '0');
        for (int i = 0; i <= count; i++) {
            
        }

        return IphoneSearchVO.builder().build();
    }

    public static void main(String[] args) {
        IphoneSearchHandler iphoneSearchHandler = new IphoneSearchHandler();
        IphoneSearchDTO iphoneSearchDTO = new IphoneSearchDTO();
        iphoneSearchDTO.setPrePhone("172");
        iphoneSearchDTO.setSufPhone("62");
        iphoneSearchHandler.handler(iphoneSearchDTO);
    }
}
