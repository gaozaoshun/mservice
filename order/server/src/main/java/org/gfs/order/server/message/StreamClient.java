package org.gfs.order.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface StreamClient {

    String INPUT = "input";
    String OUTPUT = "output";

    String INPUT_ORDER = "inputOrder";
    String OUTPUT_ORDER = "outputOrder";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT_ORDER)
    SubscribableChannel inputOrder();

    @Output(OUTPUT_ORDER)
    MessageChannel outputOrder();

}
