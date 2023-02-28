package com.sce.net.server;

import com.sce.net.context.BaseContext;
import com.sce.net.context.Context;
import com.sce.net.handler.Handler;
import com.sce.net.pack.TLVDataPack;
import com.sce.net.pack.Message;
import com.sce.net.pack.Pack;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public class BaseServer extends AbstractServer implements Server {

  private final Pack pack = new TLVDataPack();

  public BaseServer() throws IOException {
    super();
  }

  public BaseServer(int port) throws IOException {
    super(port);
  }

  @Override
  protected void doSocket(Socket socket) {

    try (
        InputStream input = socket.getInputStream()
    ) {
      while (true) {
        // 1. 解析字节流转换成 Message
        byte[] headData = input.readNBytes(pack.getHeadLen());
        Message msg = pack.unpack(headData);

        if (msg.getMsgLen() > 0) {
          byte[] data = input.readNBytes(msg.getMsgLen());
          msg.setBody(data);
        } else {
          msg.setBody(new byte[0]);
        }

        // 2. 生成Context上下文
        Context ctx = new BaseContext(socket, msg);
        // 3. 调用消息体路由函数
        Handler handler = getHandlers(msg.getMsgId());

        handler.handle(ctx);

      }
    } catch (IOException e) {
      e.printStackTrace();
      try {
        socket.close();
      } catch (IOException ee) {
        ee.printStackTrace();
      }
    }

  }
}
