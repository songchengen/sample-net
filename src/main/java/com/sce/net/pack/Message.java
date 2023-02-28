package com.sce.net.pack;

/**
 * 消息
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/28
 */
public interface Message {

  /**
   * 获取消息ID
   *
   * @return 返回消息ID
   */
  int getMsgId();

  /**
   * 设置消息ID
   *
   * @param msgId 消息ID
   */
  void setMsgId(int msgId);

  /**
   * 获取消息长度
   *
   * @return 返回消息长度
   */
  int getMsgLen();

  /**
   * 设置消息长度
   *
   * @param msgLen 消息长度
   */
  void setMsgLen(int msgLen);

  /**
   * 获取消息体
   *
   * @return 返回消息体
   */
  byte[] getBody();

  /**
   * 设置消息体
   *
   * @param body 消息体
   */
  void setBody(byte[] body);
}
