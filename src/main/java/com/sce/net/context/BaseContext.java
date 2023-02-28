package com.sce.net.context;

import com.sce.net.pack.Message;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;

/**
 * TODO
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public class BaseContext implements Context {

  private final Socket socket;
  private final Message msg;
  private final OutputStream output;

  public BaseContext(Socket socket, Message msg) throws IOException {
    this.socket = socket;
    this.msg = msg;
    this.output = socket.getOutputStream();

    doHandle();
  }

  /**
   * 处理socket，解析消息体
   */
  protected void doHandle() throws SocketException {
    if (socket.isClosed()) {
      throw new SocketException("Socket is closed");
    }
  }

  @Override
  public <T> T body(Class<T> clazz) {
    return null;
  }

  @Override
  public String bodyStr() {
    return bodyStr(Charset.defaultCharset());
  }

  @Override
  public String bodyStr(Charset charset) {
    return new String(msg.getBody(), charset);
  }

  @Override
  public byte[] bodyBytes() {
    return new byte[0];
  }

  @Override
  public void set(String key, Object value) {

  }

  @Override
  public Object get(String key) {
    return null;
  }

  @Override
  public void json(Object value) {

  }

  @Override
  public void str(String value) throws IOException {
    bytes(value.getBytes());
  }

  @Override
  public void bytes(byte[] value) throws IOException {
    output.write(value);
    output.flush();
  }
}
