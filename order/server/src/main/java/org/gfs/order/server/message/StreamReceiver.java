package org.gfs.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.gfs.order.server.dto.OrderDto;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {
    /**
     * 接收方
     * @param message
     */
    @StreamListener(value = StreamClient.INPUT)
    public void receive(OrderDto message) {
        log.info("消息队列[{}] : {}", StreamClient.INPUT, message);
    }

}
