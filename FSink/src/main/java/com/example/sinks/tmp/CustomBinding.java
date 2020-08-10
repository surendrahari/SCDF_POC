//package com.example.sinks.tmp;
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.messaging.SubscribableChannel;
//
//public interface CustomBinding {
//    String MB_DLQ_INPUT = "mb_dlq_input";
//
//    @Input("mb_dlq_input")
//    SubscribableChannel mb_dlq_input();
//    //=================
//    String SINK_DLQ_INPUT = "sink_dlq_input";
//
//    @Input("sink_dlq_input")
//    SubscribableChannel sink_dlq_input();
//}
