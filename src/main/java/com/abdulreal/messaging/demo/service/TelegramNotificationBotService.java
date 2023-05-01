/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdulreal.messaging.demo.service;

import com.abdulreal.messaging.demo.dto.Side;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Musa Dabra
 */
@Service
public class TelegramNotificationBotService {
    
    private String CHAT_ID = "-1001732550222";
    private String TOKEN = "bot5202445072:AAGB5fiPfRuJc7farMEyXzjj14DXXI9RKOo";

    private MessageQueueingService messageQueueingService;
    
    private static final Logger LOG = Logger.getLogger(TelegramNotificationBotService.class.getName());

 
    public void sendSignal(Side side, String price, String coin){
        
        String message = "";
        if(Side.BUY.equals(side))
//            message = " *TESTING NEW VERSION  \n We are trading "+coin.toUpperCase()+" today. \n POSITION: "+side.name()+", \n Price:"+price+" At \n Target 1:  \n Target 2:\n Don't forget to always set stop loss";
            message = " *TESTING NEW VERSION  \n We are trading "+coin.toUpperCase()+" today. \n POSITION: "+side.name()+", \n Price: "+price+" << \n Don't forget to always set stop loss";
        else
            message = " *TESTING NEW VERSION  \nSELL "+coin.toUpperCase()+"/USDT at PRICE: "+price+ "<<";
                
        try {
            // request url
            String url = "https://api.telegram.org/"+TOKEN+"/sendMessage?chat_id="+CHAT_ID+"&text="+message;

            // create an instance of RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // make an HTTP GET request
            //String json = restTemplate.getForObject(url, String.class);
            //Send message to RabbitMQ queue instead
            messageQueueingService.sendToTelegramQueue(url);

            // print json
           // System.out.println(json);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "FAILED TO SEND MESSAGE TO Queue");
        }
    }
       
}