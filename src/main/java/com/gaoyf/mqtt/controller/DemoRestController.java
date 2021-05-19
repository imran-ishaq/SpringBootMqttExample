package com.gaoyf.mqtt.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoyf.mqtt.core.IMQTTPublisher;
import com.gaoyf.mqtt.core.IMQTTSubscriber;
import com.gaoyf.mqtt.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 * @author Imran Ishaq
 * @since 2021/4/27 0009 16:14
 * <p>
 * controller
 */
@RestController
public class DemoRestController {
    public static String TOPIC_LOOP_TEST = "ShipperTest";

    @Autowired
    IMQTTPublisher publisher;

    @Autowired
    IMQTTSubscriber subscriber;


    /**
      * The method decorated
 by @PostConstruct will run when the server loads the Servlet, and will only be executed once by the server.      * PostConstruct is executed after the constructor and before the init() method. The PreDestroy() method is executed after the destroy() method is intelligible 
     * here to initialize and subscribe to a topic 
*/
    @PostConstruct
    public void init() {
        subscriber.subscribeMessage(TOPIC_LOOP_TEST);
    }


    /**
     * Send a message to the specified topic 
    * 
    * @param data data 
    * @return response 
*/
    @RequestMapping(value = "/mqtt/loop/message", method = RequestMethod.POST)
    public String index(@RequestBody String data) {
        publisher.publishMessage(TOPIC_LOOP_TEST, data);
        return "Success";
    }
    @RequestMapping(value = "/mqtt/loop/get", method = RequestMethod.GET)
    public List<String> getMessages() {
    	 return subscriber.getMessages();
        
    }

}
