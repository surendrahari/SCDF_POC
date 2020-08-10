package com.example.sinks;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface DLQBinding {
    String MB_DLQ_INPUT = "mb_dlq_input";

    @Input("mb_dlq_input")
    SubscribableChannel mb_dlq_input();
}
