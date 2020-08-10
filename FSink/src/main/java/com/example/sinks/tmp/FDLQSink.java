//package com.example.sinks.tmp;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.support.MessageBuilder;
//
//@EnableBinding({CustomBinding.class, Source.class})
//public class FDLQSink {
//
//    @StreamListener(CustomBinding.MB_DLQ_INPUT)
//    @SendTo(Source.OUTPUT)
//    public Message<String> listenMessageBridgeDeadLetterQueue(String message) {
//        String key = "FDLQSink : (MB) : ";
//        System.out.println(key + "Message Received : " + message);
//        String failedAck = failedAck(message);
//        System.out.println(key + "Ack message send back to Message bridge Queue : " + failedAck);
//        return MessageBuilder.withPayload(failedAck).build();
//    }
//
//    @StreamListener(CustomBinding.SINK_DLQ_INPUT)
//    @SendTo(Source.OUTPUT)
//    public Message<String> listenSinkDeadLetterQueue(String message) {
//        String key = "FDLQSink : (Sink) : ";
//        System.out.println(key + "Message Received : " + message);
//        String failedAck = failedAck(message);
//        System.out.println(key + "Ack message send back to Message bridge Queue : " + failedAck);
//        return MessageBuilder.withPayload(failedAck).build();
//    }
//
//    public String failedAck(String message) {
//        return "<Ack status=1, message=" + message + "/>";
//    }
//}
