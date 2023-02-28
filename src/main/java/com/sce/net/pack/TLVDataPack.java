package com.sce.net.pack;

import java.nio.ByteBuffer;

/**
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public class TLVDataPack implements Pack {

  @Override
  public int getHeadLen() {
    return 8;
  }

  @Override
  public byte[] pack(Message msg) {
    int msgLen = msg.getMsgLen();

    ByteBuffer buffer = ByteBuffer.allocate(8 + msgLen);
    buffer.putInt(msg.getMsgId());
    buffer.putInt(msgLen);
    buffer.put(msg.getBody());

    return buffer.array();
  }

  @Override
  public Message unpack(byte[] data) {
    ByteBuffer buffer = ByteBuffer.wrap(data);
    int msgId = buffer.getInt();
    int msgLen = buffer.getInt();

    return new TLVMessage(msgId, msgLen);
  }

}
