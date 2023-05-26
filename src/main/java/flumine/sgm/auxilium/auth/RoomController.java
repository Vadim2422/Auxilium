package flumine.sgm.auxilium.auth;

import flumine.sgm.auxilium.models.RoomModel;
import flumine.sgm.auxilium.repositories.MessageAIRepository;
import flumine.sgm.auxilium.repositories.MessageUserRepository;
import flumine.sgm.auxilium.repositories.RoomRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RoomController {
    final
    RoomRepository roomRepository;
    final
    MessageAIRepository aiRepository;
    final
    MessageUserRepository userRepository;


    public RoomController(RoomRepository roomRepository, MessageAIRepository aiRepository, MessageUserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.aiRepository = aiRepository;
        this.userRepository = userRepository;
    }
    @PostMapping("/createroom")
    ResponseEntity<?> createRoom(@RequestBody RoomModel room){
        roomRepository.save(new RoomModel(room));//TODO:add complection create
        return new ResponseEntity<>("201", HttpStatus.CREATED);
    }
    @PostMapping("/getaimessages")
    ResponseEntity<?> getaimessages(@RequestBody Long room_id){
        if (roomRepository.findById(room_id).isPresent()){
            var user = userRepository.findAllByRoomID(room_id);
            var ai = aiRepository.findAllByRoomID(room_id);
            return new ResponseEntity<>(ai,HttpStatus.OK);
        }
        return new ResponseEntity<>("502",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/getusermessages")
    ResponseEntity<?> getusermessages(@RequestBody Long room_id){
        if (roomRepository.findById(room_id).isPresent()){
            var user = userRepository.findAllByRoomID(room_id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>("502",HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/deleteroom")
    ResponseEntity<?> deleteRoom(@RequestBody Long room_id){
        if(roomRepository.findById(room_id).isPresent()) {
            roomRepository.deleteById(room_id);
            userRepository.deleteAllByRoomID(room_id);
            aiRepository.deleteAllByRoomID(room_id);
        }
        return new ResponseEntity<>("502",HttpStatus.BAD_REQUEST);
    }




}
