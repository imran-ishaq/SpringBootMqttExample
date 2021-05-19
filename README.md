## Structure

Server side constitute

- broker (mqtt Core: used for message sending management)
- Application Server is used to process RestFul requests and forward them as Mqtt messages
  -Publisher **essentially Mqtt client** is used to publish server-side messages
  - Subscriber **essentially Mqtt client** is used to subscribe to client-side messages and display
- Client side
  - Publisher is used to publish client-side messages
  - Subscriber is used to subscribe to server-side messages.
   -Client is used to send RestFul request to Application Server to trigger message pub/sub

**Summary**: From the structural point of view, Broker is the essentially Server side of Mqtt. From the business point of view, the Application server and Broker that encapsulate the Mqtt Client pub/sub together form the server side of the business.

### Build the springboot project

#### 1. Use the idea springboot initializer to initialize the springboot project

Use springboot version **2.1.5.RELEASE**

#### 2. add in pom

```xml

<dependency>
    <groupId>org.springframework.integration</groupId>
    <artifactId>spring-integration-stream</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.integration</groupId>
    <artifactId>spring-integration-mqtt</artifactId>
</dependency>

```

#### 3. MQTT Configuration

* Configure the broker address,
* The port number,
* Whether to use ssl,
* username
* Password



#### 4. Use postman to call port 8200 for debugging or use MQTTX tool for debugging.
[MQTTX download address]( https://github.com/emqx/MQTTX/releases/tag/v1.3.0)

