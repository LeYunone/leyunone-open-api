package com.leyunone.openapi.command;


import com.leyunone.openapi.support.factory.CommandFacotry;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-09
 */
public abstract class BaseHandler<V, D> implements InitializingBean {


    public abstract V handler(D d);

    public V execute(D d) {
        return this.handler(d);
    }

    @Override
    public void afterPropertiesSet() {
        CommandFacotry.regiest(this.getClass(), this);
    }
}
