package in.ineuron.controller;

import in.ineuron.dto.MessageRequest;
import in.ineuron.dto.MessageResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@CrossOrigin(origins = "")
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<MessageResponse> sendMessageHandler( @RequestBody MessageRequest msgReq) {
        MessageResponse msgRes = new MessageResponse();
        BeanUtils.copyProperties(msgReq, msgRes);

        // Send the message to "/topic/message" destination
        messagingTemplate.convertAndSend("/topic/message", msgRes);

        return ResponseEntity.ok(msgRes);
    }
}
