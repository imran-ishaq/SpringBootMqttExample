package com.gaoyf.mqtt.core;

import java.util.ArrayList;

/**
* @author Imran Ishaq
 * @since 2021/4/27 0009 16:04
 * <p>
 * Subscriber interface

 */
public interface IMQTTSubscriber {

    /**
     * Subscribe to Topic
     *
     * @param topic
     */
    public void subscribeMessage(String topic);
    
    public ArrayList<String> getMessages();

    /**
     * Disconnect the MQTT client
     */
    public void disconnect();
}
