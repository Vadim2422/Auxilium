package flumine.sgm.auxilium.websocket;

import flumine.sgm.auxilium.models.MessageModel;
import flumine.sgm.auxilium.models.MessageRole;
import flumine.sgm.auxilium.repositories.MessageRepository;
import flumine.sgm.auxilium.repositories.RoomRepository;
import flumine.sgm.auxilium.services.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Duration;

@Controller
public class WebSocketController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private OpenAIService ai;

    @MessageMapping("/chat/{room_id}/sendMessage")
    @SendTo("/topic/chat/{room_id}")
    @CrossOrigin
    public void sendMessage(@DestinationVariable Long room_id, @Payload String message) {
        MessageModel messageModel = new MessageModel(MessageRole.user, message, Long.valueOf(room_id));
        messageRepository.save(messageModel);
        var gptContent = ai.sendChatCompletionWithContext(roomRepository.findById(room_id).get().getModel(),messageRepository.findAllByRoomid(room_id));
        var gptContentResponse = gptContent.block(Duration.ofMillis(500)).getObject();
        messageModel = new MessageModel(MessageRole.system, gptContentResponse, Long.valueOf(room_id));
        messageRepository.save(messageModel);
//        return room_id + " " + message;
    }
}
