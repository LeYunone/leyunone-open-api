package com.leyunone.openapi.task;

import com.leyunone.openapi.command.BaiduEmployHandler;
import com.leyunone.openapi.common.dto.BaiduEmployDTO;
import com.leyunone.openapi.common.vo.BaiduEmployVO;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 偷偷用其他服务器的定时任务 :)
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-05-28
 */
@Component
public class XXLJobHandler extends IJobHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaiduEmployHandler baiduEmployHandler;

    @XxlJob(value = "apiHandler")
    @Override
    public void execute() throws Exception {
        logger.info("XXL-JOB EXECUTE:{}", LocalDateTime.now());
        BaiduEmployDTO baiduEmployDTO = new BaiduEmployDTO();
        baiduEmployDTO.setSite("https://www.leyunone.com");
        baiduEmployDTO.setToken("L16OtyPtqqRWBzKn");
//        baiduEmployDTO.setUrls(CollectionUtil.newArrayList("https://www.leyunone.com/algorithm/dynamic-programming.html"
//                ,"https://www.leyunone.com/frame/spring/spring-cloud-init.html"));
        baiduEmployDTO.setSitemapUrl("https://leyunone.com/sitemap.xml");
        BaiduEmployVO handler = baiduEmployHandler.handler(baiduEmployDTO);
        System.out.println(handler.toString());
    }
}
