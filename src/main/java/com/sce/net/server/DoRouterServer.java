package com.sce.net.server;

import com.sce.net.handler.Handler;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public abstract class DoRouterServer implements Server {

  private Map<Integer, Handler> routerMap;

  /**
   * 获取当前路由对应的处理函数
   * @param msgId 消息ID
   * @return 处理函数
   */
  protected Handler getHandlers(int msgId) {
    return routerMap.getOrDefault(msgId, null);
  }

  @Override
  public void router(int msgId, Handler handler) {
    if (routerMap == null) {
      routerMap = new Hashtable<>();
    }
    if (!routerMap.containsKey(msgId)) {
      routerMap.put(msgId, handler);
    }

    // TODO
    // 抛出重复路由handler异常
  }
}
