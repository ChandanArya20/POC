package tech.hulkhire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hulkhire.pojo.Item;
import tech.hulkhire.publisher.StoreMessagePublisher;

@RestController
@RequestMapping("/api/v1")
public class StoreMessageController {

    @Autowired
    StoreMessagePublisher storeMessageProducer;

    @Value("${activemq.destination}")
    private String destination;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Item item){
        storeMessageProducer.sendTo(destination,item);
        return "Success";
    }
}