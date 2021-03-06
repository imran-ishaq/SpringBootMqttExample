package com.gaoyf.mqtt.core;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author Imran Ishaq
 * @since 2021/4/27 0009 16:05
 */
@Component
public class MQTTSubscriber extends MQTTConfig implements MqttCallback, IMQTTSubscriber {

    private String brokerUrl = null;
    final private String colon = ":";//Colon separator

    final private String clientId = "mqtt_server_sub";//Client ID can be freely defined here
    private ArrayList<String> messages=new ArrayList<>();

    private MqttClient mqttClient = null;
    private MqttConnectOptions connectionOptions = null;
    private MemoryPersistence persistence = null;

    private static final Logger logger = LoggerFactory.getLogger(MQTTSubscriber.class);

    public MQTTSubscriber() {
        this.config();
    }

    @Override
    public void connectionLost(Throwable cause) {
        logger.info("Connection Lost");

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        // Called when a message arrives from the server that matches any subscription made by the client
        String time = new Timestamp(System.currentTimeMillis()).toString();
        System.out.println();
        System.out.println("***********************************************************************");
        System.out.println("Message Recieved ：" + time + "  Topic: " + topic + "  Message: "
                + new String(message.getPayload()));
        messages.add(new String(message.getPayload()));
        System.out.println("***********************************************************************");
        System.out.println();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Leave it blank for subscriber

    }

    @Override
    public void subscribeMessage(String topic) {
        try {
            this.mqttClient.subscribe(topic, this.qos);
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            this.mqttClient.disconnect();
        } catch (MqttException me) {
            logger.error("ERROR", me);
        }
    }

    protected void config(String ip, Integer port, Boolean ssl, Boolean withUserNamePass) {
        String protocal = this.TCP;
        if (ssl) {
            protocal = this.SSL;
        }
        this.brokerUrl = protocal + this.ip + colon + port;
        this.persistence = new MemoryPersistence();
        this.connectionOptions = new MqttConnectOptions();
        try {
            this.mqttClient = new MqttClient(brokerUrl, clientId, persistence);
            this.connectionOptions.setCleanSession(true);
            if (withUserNamePass) {
                if (password != null) {
                    this.connectionOptions.setPassword(this.password.toCharArray());
                }
                if (username != null) {
                    this.connectionOptions.setUserName(this.username);
                }
            }
            this.mqttClient.connect(this.connectionOptions);
            this.mqttClient.setCallback(this);
        } catch (MqttException me) {
            me.printStackTrace();
        }

    }

    public ArrayList<String> getMessages(){
    	
    	return this.messages;
    }
    protected void config() {

        this.brokerUrl = this.TCP + this.ip + colon + this.port;
        this.persistence = new MemoryPersistence();
        this.connectionOptions = new MqttConnectOptions();
        try {
            this.mqttClient = new MqttClient(brokerUrl, clientId, persistence);
            this.connectionOptions.setCleanSession(true);
            if (password != null) {
                this.connectionOptions.setPassword(this.password.toCharArray());
            }
            if (username != null) {
                this.connectionOptions.setUserName(this.username);
            }
            this.mqttClient.connect(this.connectionOptions);
            this.mqttClient.setCallback(this);
        } catch (MqttException me) {
            me.printStackTrace();
        }

    }

}
