package com.sce.net.examples.echo;

import com.sce.net.pack.TLVMessage;
import com.sce.net.pack.TLVDataPack;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * TODO
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public class EchoClient {

  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 7777);

    try (
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream()
    ) {
      handle(input, output);
    }
    socket.close();
  }

  private static void handle(InputStream input, OutputStream output) throws IOException {
    TLVDataPack pack = new TLVDataPack();
    String request = "hello world";
    byte[] value = request.getBytes(Charset.defaultCharset());
    TLVMessage message = new TLVMessage(0, value.length);
    message.setBody(value);
    byte[] data = pack.pack(message);
    while (true) {

      output.write(data);
      output.flush();
      byte[] buf = new byte[512];
      int cnt = input.read(buf);
      String response = new String(buf, 0, cnt);
      System.out.println("recv from server: " + response);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
