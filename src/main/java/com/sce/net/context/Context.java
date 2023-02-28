package com.sce.net.context;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 上下文
 *
 * @author songchengen
 * @version 0.0.1
 * @date 2023/2/27
 */
public interface Context {

  /**
   * 解析消息体，转化成指定的类
   *
   * @param clazz 指定的类
   * @param <T>   指定的类
   * @return 返回指定类的实例
   */
  <T> T body(Class<T> clazz);

  /**
   * 返回消息体，转化成字符创
   *
   * @return 返回转化成字符串的消息体
   */
  String bodyStr();

  /**
   * 返回转化成指定字符集的消息体
   *
   * @param charset 字符集
   * @return 返回转化成指定字符集的消息体
   */
  String bodyStr(Charset charset);

  /**
   * 返回原始字节数组消息体
   *
   * @return 返回原始字节数组消息体
   */
  byte[] bodyBytes();

  /**
   * 设置上下文变量
   *
   * @param key   键
   * @param value 值
   */
  void set(String key, Object value);

  /**
   * 获取上下文变量
   *
   * @param key 键
   * @return 返回上下文变量
   */
  Object get(String key);

  /**
   * 发送消息，内部讲value转化成字节数组
   *
   * @param value 消息
   */
  void json(Object value);

  /**
   * 发送字符串消息，内部讲字符串转化成字节数组
   *
   * @param value 字符串消息
   * @throws IOException IO异常
   */
  void str(String value) throws IOException;

  /**
   * 发送最原始的字节数组消息
   *
   * @param value 字节数组消息
   * @throws IOException IO异常
   */
  void bytes(byte[] value) throws IOException;
}
