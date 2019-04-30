package org.gfs.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @Autowired
    private StreamClient streamClient;
    /**
     * 接收方
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT_ORDER)
    public String receive(Object message) {
        log.info("消息队列{} : {}", StreamClient.INPUT,message);
        return  "高灶顺~~~";
    }

    @StreamListener(StreamClient.INPUT_ORDER)
    public void receiveA(Object message) {
        log.info("消息队列{} : {}", StreamClient.INPUT_ORDER,message);
    }


}
