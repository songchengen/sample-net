package com.sce.net.server;

import com.sce.net.handler.Handler;

/**
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/27
 */
public interface Server {

  /**
   * 启动服务
   */
  void start();

  /**
   * 增加对应路由的处理函数
   *
   * @param msgId   消息ID
   * @param handler 处理函数
   */
  void router(int msgId, Handler handler);
}
