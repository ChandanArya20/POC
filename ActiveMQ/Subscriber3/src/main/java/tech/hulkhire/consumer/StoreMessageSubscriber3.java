package tech.hulkhire.consumer;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tech.hulkhire.pojo.Item;

@Component
@Slf4j
public class StoreMessageSubscriber3 {

    @JmsListener(destination = "${activemq.destination}")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Item item = (Item) objectMessage.getObject();
            // do additional processing
            log.info("Received Message: " + item);
        } catch (Exception e) {
            log.error("Received Exception: " + e);
        }
    }
}
