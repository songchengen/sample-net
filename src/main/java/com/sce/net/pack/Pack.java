package com.sce.net.pack;

/**
 * TODO
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public interface Pack {

  /**
   * 获取消息头的长途
   *
   * @return 返回消息头的长度
   */
  int getHeadLen();

  /**
   * 打包
   *
   * @param msg 消息
   * @return 返回打包后的数据
   */
  byte[] pack(Message msg);

  /**
   * 解包
   *
   * @param data 数据
   * @return 返回解包后的消息
   */
  Message unpack(byte[] data);
}
