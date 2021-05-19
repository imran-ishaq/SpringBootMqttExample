package com.gaoyf.mqtt.core;

/**
 * @author Imran Ishaq
 * @since 2021/4/27 0009 16:02
 * <p>
 * 
 */
public interface IMQTTPublisher {
    /**
     * 发布消息
     *
     * @param topic   主题
     * @param message 消息
     */
    public void publishMessage(String topic, String message);

    /**
     * 断开MQTT客户端
     */
    public void disconnect();
}

