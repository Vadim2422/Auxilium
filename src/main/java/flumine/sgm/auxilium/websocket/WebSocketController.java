package flumine.sgm.auxilium.websocket;

import flumine.sgm.auxilium.models.MessageModel;
import flumine.sgm.auxilium.models.MessageRole;
import flumine.sgm.auxilium.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class WebSocketController {

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/chat/{room_id}/sendMessage")
    @SendTo("/topic/chat/{room_id}")
    @CrossOrigin
    public void sendMessage(@DestinationVariable String room_id, @Payload String message) {
        MessageModel messageModel = new MessageModel(MessageRole.user, message, Long.valueOf(room_id));
        messageRepository.save(messageModel);
        //TODO request to gpt
        String gptContent = "";
        messageModel = new MessageModel(MessageRole.system, gptContent, Long.valueOf(room_id));
        messageRepository.save(messageModel);
//        return room_id + " " + message;
    }
}
