package org.gfs.order.server.controller;

import org.gfs.order.server.dto.OrderDto;
import org.gfs.order.server.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StreamController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("stream")
    public String sendMsg(){
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("AAA");
        streamClient.output().send(MessageBuilder.withPayload(orderDto).build());
        return "Success";
    }
}
