package tech.hulkhire.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import tech.hulkhire.pojo.Item;

@Slf4j
@Component
public class StoreMessagePublisher {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTo(String destination, Item item){
        log.debug("Parameters are {} and {} : ",destination,item);
        jmsTemplate.convertAndSend(destination, item);
        log.info("Message sent to "+destination);
    }
}
