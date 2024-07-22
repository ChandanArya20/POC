package in.ineuron.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@Configuration
public class TaskScheduler {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedDelay = 2000)
    public void sendContinuousMessage() {
        Random random = new Random();
        Long l = random.nextLong(100000);
        messagingTemplate.convertAndSend("/topic/message2", l.toString());
        System.out.println("Sent: " + l);
    }
}
