package com.sce.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public abstract class AbstractServer extends DoRouterServer implements Server {

  /**
   * 默认端口号
   */
  private static final int DEFAULT_PORT = 8080;

  /**
   * 处理客户端连接线程池的默认参数
   */
  private static final int DEFAULT_CORE_POOL_SIZE = 10;
  private static final int DEFAULT_MAX_POOL_SIZE = 20;
  private static final long DEFAULT_KEEP_ALIVE_TIME = 100;
  private static final int DEFAULT_QUEUE_SIZE = 100;

  private final int port;
  private final ServerSocket serverSocket;
  private final Executor executor;

  public AbstractServer() throws IOException {
    this(DEFAULT_PORT);
  }

  public AbstractServer(int port) throws IOException {
    this.port = port;
    serverSocket = new ServerSocket(this.port);
    executor = new ThreadPoolExecutor(
        DEFAULT_CORE_POOL_SIZE,
        DEFAULT_MAX_POOL_SIZE,
        DEFAULT_KEEP_ALIVE_TIME,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(DEFAULT_QUEUE_SIZE),
        new ThreadPoolExecutor.AbortPolicy()
    );
  }



  @Override
  public void start() {
    System.out.printf("server start at port: %d%n", port);
    while (true) {
      try {
        Socket socket = serverSocket.accept();
        executor.execute(() -> doSocket(socket));
      } catch (IOException e) {
        e.printStackTrace();
        break;
      }
    }
  }

  /**
   * 处理客户端连接
   *
   * @param socket 客户端socket
   */
  protected abstract void doSocket(Socket socket);
}
