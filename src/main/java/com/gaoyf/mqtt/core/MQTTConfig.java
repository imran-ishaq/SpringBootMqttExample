package com.gaoyf.mqtt.core;

/**
* @author Imran Ishaq
 * @since 2021/4/27 0009 16:00
 */
public abstract class MQTTConfig {

    protected String ip ="Define your URL of Broker server";// "127.0.0.1";

    /**
     * qos0 For the client, there is one and only one publish package. For the broker, there is one and only one publish. In short, it is to send the package only once, regardless of whether it is received or not. It is suitable for those who are not Very important data. 
    * The qos1 interaction is the effect of one more ack, but there will be a problem. Although we can guarantee that we must receive the message from the client or server through confirmation, we cannot guarantee that the message is only once, 
    * that is, when the client If the puback of the service is not received or the service does not receive the puback of the client, the publisher will be sent all the time. 
    * qos2 can accept only one message. The main principle (for the publisher), 
    * publisher and broker are cached, and the publisher caches The message and msgID are cached, and the broker caches the msgID. Both parties make records so that the messages are not repeated. 
    * But because the records need to be deleted, the deletion process is also doubled 
*/ 
    protected int qos = 0;

    protected Boolean hasSSL = false; /* By default SSL is disabled */

    protected Integer port = 19987; /* Default port */

    protected String username = "username";

    protected String password = "password";

    protected String TCP = "tcp://";

    protected String SSL = "ssl://";


    /**
     * Custom Configuration
     */
    protected abstract void config(String ip, Integer port, Boolean ssl, Boolean withUserNamePass);

    /**
     * Default Configuration
     */
    protected abstract void config();


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public Boolean getHasSSL() {
        return hasSSL;
    }

    public void setHasSSL(Boolean hasSSL) {
        this.hasSSL = hasSSL;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTCP() {
        return TCP;
    }

    public void setTCP(String TCP) {
        this.TCP = TCP;
    }

    public String getSSL() {
        return SSL;
    }

    public void setSSL(String SSL) {
        this.SSL = SSL;
    }
}
