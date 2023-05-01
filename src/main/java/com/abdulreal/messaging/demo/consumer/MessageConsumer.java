package com.abdulreal.messaging.demo.consumer;

import com.abdulreal.messaging.demo.config.MessagingConfig;
import com.abdulreal.messaging.demo.dto.Asset;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = MessagingConfig.MY_QUEUE)
    public void listener(Asset asset){
        System.out.printf("Asset profile%n%s%n%s%n%s%n%f%n%f%n%f",
                asset.getId(), asset.getSymbol(), asset.getCoinName(), asset.getMarketCap(),
                asset.getDailyVolume(), asset.getDailyPerformance());
    }
}
