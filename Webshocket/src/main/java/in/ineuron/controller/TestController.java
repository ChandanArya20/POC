package in.ineuron.controller;

import in.ineuron.dto.MessageRequest;
import in.ineuron.dto.MessageResponse;
import in.ineuron.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @MessageMapping("/hello")
    @SendTo("/topic/message1")
    public Message sendMessage(@Payload Message msg){
        return msg;
    }

    @MessageMapping("/continue")
    @SendTo("/topic/message2")
    public String sendContinuousMessage(@Payload String msg){
        return "Ram";
    }

    @MessageMapping("/spread")
    @SendTo("/topic/message")
    public MessageResponse sendMessages(@Payload MessageRequest msg){
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage(msg.getMessage());
        messageResponse.setSender(msg.getSender());
        return messageResponse;

    }



}
