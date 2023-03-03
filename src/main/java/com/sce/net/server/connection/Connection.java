package com.sce.net.server.connection;

import java.net.Socket;
import java.net.SocketAddress;

/**
 * Copyright (c) 2021, songchengen. All rights reserved.
 *
 * @author chengensong
 * @version 0.0.1
 * @date 2023/3/3
 */
public interface Connection {

  /**
   * 连接是否已被关闭
   *
   * @return 返回连接关闭的状态
   */
  boolean isClosed();

  /**
   * 返回最原始的客户端socket
   *
   * @return 返回socket
   */
  Socket getSocket();

  /**
   * 返回连接ID
   *
   * @return 返回连接ID
   */
  int getConnectionId();

  /**
   * 返回客户端地址
   *
   * @return 返回客户端地址
   */
  SocketAddress getRemoteAddress();



}
