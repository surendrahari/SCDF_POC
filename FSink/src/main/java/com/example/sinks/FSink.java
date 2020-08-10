package com.example.sinks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({Sink.class, Source.class})
public class FSink {

    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public Message<String> listen(String message) {
        String key = "FTapSink : ";
        System.out.println(key + "Message Received : " + message);
        String ack = dbResponse(message);
        System.out.println(key + "Ack message send back to Message bridge Queue : " + ack);
        return MessageBuilder.withPayload(ack).build();
    }

    public String dbResponse(String message) {
        //TODO : lookup the DB and check it's already processed
        String status = "error".equalsIgnoreCase(message) ? "1" : "0";
        return "<Ack status=" + status + ", message=" + message + "/>";
    }
}
