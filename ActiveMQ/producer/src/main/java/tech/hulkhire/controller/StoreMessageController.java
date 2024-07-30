package tech.hulkhire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hulkhire.pojo.Item;
import tech.hulkhire.producer.StoreMessageProducer;

@RestController
@RequestMapping("/api/v1")
public class StoreMessageController {

    @Autowired
    StoreMessageProducer storeMessageProducer;

    @Value("${activemq.destination}")
    private String destination;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Item item){
        storeMessageProducer.sendTo(destination,item);
        return "Success";
    }
}