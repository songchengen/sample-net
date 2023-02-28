package com.sce.net.pack;

/**
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public class TLVMessage implements Message {

  private int msgId;
  private int msgLen;
  private byte[] body;

  public TLVMessage(int msgId, int msgLen) {
    this.msgId = msgId;
    this.msgLen = msgLen;
  }

  @Override
  public int getMsgId() {
    return msgId;
  }

  @Override
  public void setMsgId(int msgId) {
    this.msgId = msgId;
  }

  @Override
  public int getMsgLen() {
    return msgLen;
  }

  @Override
  public void setMsgLen(int msgLen) {
    this.msgLen = msgLen;
  }

  @Override
  public byte[] getBody() {
    return body;
  }

  @Override
  public void setBody(byte[] body) {
    this.body = body;
  }
}
