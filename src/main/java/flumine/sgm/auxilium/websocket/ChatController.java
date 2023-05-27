package flumine.sgm.auxilium.websocket;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    @MessageMapping("/chat/{roomId}")
    public String chat(@DestinationVariable("roomId") String roomId,
                           @Payload String message)  {

        return message + " " + roomId;
    }

}
