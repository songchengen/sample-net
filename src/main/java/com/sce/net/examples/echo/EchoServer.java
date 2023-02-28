package com.sce.net.examples.echo;

import com.sce.net.server.BaseServer;
import com.sce.net.server.Server;
import java.io.IOException;

/**
 * TODO
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public class EchoServer {

  public static void main(String[] args) throws IOException {
    Server server = new BaseServer(7777);

    server.router(0, ctx -> {
      String str = ctx.bodyStr();
      System.out.printf("recv from client: %s%n", str);
      try {
        ctx.str(str);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    server.start();
  }
}
