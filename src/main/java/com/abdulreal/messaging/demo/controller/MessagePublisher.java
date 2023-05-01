package com.abdulreal.messaging.demo.controller;

import com.abdulreal.messaging.demo.config.MessagingConfig;
import com.abdulreal.messaging.demo.dto.Asset;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MessagePublisher {

    Asset asset = new Asset();

    @Autowired
    private RabbitTemplate template;

    @GetMapping("/send")
    public String publishMessage(){


        asset.setId(UUID.randomUUID().toString());
        asset.setSymbol("btc");
        asset.setCoinName("Bitcoin");
        asset.setMarketCap(11233.554);
        asset.setDailyVolume(32343.343);
        asset.setDailyPerformance(223.324);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, asset);

        return "Success";
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "hiiiii...";
    }

}
