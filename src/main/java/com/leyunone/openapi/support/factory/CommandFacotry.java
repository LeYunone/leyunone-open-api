package com.leyunone.openapi.support.factory;

import cn.hutool.core.util.ObjectUtil;
import com.leyunone.openapi.command.BaseHandler;
import com.leyunone.openapi.common.dto.HttpApiDTO;
import com.leyunone.openapi.common.vo.BaseVO;
import com.leyunone.openapi.util.AssertUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
public class CommandFacotry {

    private static Map<Class<?>, BaseHandler> handlers = new HashMap<>();

    public static void regiest(Class<?> clazz, BaseHandler baseHandler) {
        handlers.put(clazz, baseHandler);
    }

    public static BaseHandler get(Class<?> clazz) {
        BaseHandler baseHandler = handlers.get(clazz);
        AssertUtil.isFalse(ObjectUtil.isNull(baseHandler), "handler is empty");
        return baseHandler;
    }

}
