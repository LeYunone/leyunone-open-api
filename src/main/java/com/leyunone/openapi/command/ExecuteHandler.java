package com.leyunone.openapi.command;

import com.leyunone.openapi.support.factory.CommandFacotry;
import org.springframework.stereotype.Service;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
@Service
public class ExecuteHandler {

    public <T>T execute(Class<T> clzz,Class<?> handler,Object o ){
        BaseHandler baseHandler = CommandFacotry.get(handler);
        return (T) baseHandler.execute(o);
    }

    public Object execute(Class<?> handler,Object o ){
        BaseHandler baseHandler = CommandFacotry.get(handler);
        return baseHandler.execute(o);
    }
}

