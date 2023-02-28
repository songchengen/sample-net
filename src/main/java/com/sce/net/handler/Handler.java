package com.sce.net.handler;

import com.sce.net.context.Context;

/**
 * TODO
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public interface Handler {

    /**
    * 处理消息
    *
    * @param ctx 上下文
    */
    void handle(Context ctx);
}
