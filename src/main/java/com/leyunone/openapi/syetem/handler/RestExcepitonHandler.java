package com.leyunone.openapi.syetem.handler;

import com.leyunone.openapi.common.response.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
@ControllerAdvice
@ResponseBody
public class RestExcepitonHandler {

    private static Logger logger = LoggerFactory.getLogger(RestExcepitonHandler.class);
    
    @ExceptionHandler(value = RuntimeException.class)
    public DataResponse runtimE(Exception e){
        logger.error(e.getMessage());
        return DataResponse.buildFailure(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public DataResponse exceptionE(Exception e){
        logger.error(e.getMessage());
        e.printStackTrace();
        return DataResponse.buildFailure("error");
    }
}
