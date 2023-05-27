package flumine.sgm.auxilium.auth;

import flumine.sgm.auxilium.models.RoomModel;
import flumine.sgm.auxilium.repositories.MessageRepository;
import flumine.sgm.auxilium.repositories.RoomRepository;
import flumine.sgm.auxilium.services.OpenAIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    final
    RoomRepository roomRepository;
    final MessageRepository messageRepository;

    final OpenAIService service;

    public RoomController(RoomRepository roomRepository, MessageRepository messageRepository, OpenAIService openAIService) {
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
        this.service = openAIService;
    }

    @GetMapping("/createroom")
    public void createRoom(){

        this.service.sendMessageToChat(0, "Say this is a test");

//        roomRepository.save(new RoomModel(room));//TODO:add complection create
        //requestcomplection
//        return new ResponseEntity<>("201", HttpStatus.CREATED);
    }

    @PostMapping("/getumessages")
    ResponseEntity<?> getmessages(@RequestBody Long room_id){
        if (roomRepository.findById(room_id).isPresent()){
            var user = messageRepository.findAllByRoomid(room_id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>("502",HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/deleteroom")
    ResponseEntity<?> deleteRoom(@RequestBody Long room_id){
        if(roomRepository.findById(room_id).isPresent()) {
            roomRepository.deleteById(room_id);
            messageRepository.deleteAllByRoomid(room_id);
        }
        return new ResponseEntity<>("502",HttpStatus.BAD_REQUEST);
    }
}
