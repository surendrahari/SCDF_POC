package com.example.sinks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

// DLQ : https://www.e4developer.com/2018/02/05/handling-bad-messages-with-rabbitmq-and-spring-cloud-stream/

@EnableBinding(Sink.class)
public class DBSink {

    private final Logger logger = LoggerFactory.getLogger(DBSink.class);

    @StreamListener(Sink.INPUT)
    public void listen(String message) throws Exception {
        String key = "DBSink : ";
        System.out.println(key + "Message Received :" + message);
        if(message.startsWith("dberror")) {
            throw new Exception(key + "DB Error! message move to dead letter queue!");
        }
        System.out.println(key + "Message Consumed : " + message);
    }
}
