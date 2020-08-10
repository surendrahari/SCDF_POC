package com.example.sources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({Sink.class, Source.class})
public class FSource {

    private Logger logger = LoggerFactory.getLogger(FSource.class);

    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public Message<String> listen(String message) throws Exception {
        System.out.println("Message received :" + message);
        if(message.startsWith("parseerror")) {
            throw new Exception("Parsing error! Moved message to message bridge dead letter queue!");
        }
        System.out.println("Message send to sink rabbit MQ :" + message);
        return MessageBuilder.withPayload(message).build();
    }
}
