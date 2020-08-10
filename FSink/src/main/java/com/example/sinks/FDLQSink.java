package com.example.sinks.tmp;

import com.example.sinks.DLQBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({DLQBinding.class, Source.class})
public class FDLQSink {

    @StreamListener(DLQBinding.MB_DLQ_INPUT)
    @SendTo(Source.OUTPUT)
    public Message<String> listenMessageBridgeDeadLetterQueue(String message) {
        String key = "FDLQSink : (MB) : ";
        System.out.println(key + "Message Received : " + message);
        String failedAck = failedAck(message);
        System.out.println(key + "Ack message send back to Message bridge Queue : " + failedAck);
        return MessageBuilder.withPayload(failedAck).build();
    }

    public String failedAck(String message) {
        return "<Ack status=1, message=" + message + "/>";
    }
}
