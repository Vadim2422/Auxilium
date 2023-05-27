package flumine.sgm.auxilium.chatcontroller;

import flumine.sgm.auxilium.responses.openai.OpenAIModelData;
import flumine.sgm.auxilium.responses.openai.OpenAIModelsResponse;
import flumine.sgm.auxilium.services.OpenAIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/models")
public class AIController
{
    final OpenAIService ai;

    public AIController(OpenAIService ai) {
        this.ai = ai;
    }

    @GetMapping("/")
    ResponseEntity<?> index(){
        return new ResponseEntity<>("200", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    ResponseEntity<?> getmodels(){
        var models = ai.getAllModels();
        var response = models.block(Duration.ofMillis(500));
            if(!response.getData().isEmpty() && !response.getObject().isEmpty()){
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
        return new ResponseEntity<>("400 checkout logs", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{model}")
    ResponseEntity<?> get(@PathVariable String model){
        var models = ai.getModelInfo(model);
        var response = models.block(Duration.ofMillis(500));
        if(!response.getObject().isEmpty()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>("400 checkout logs", HttpStatus.BAD_REQUEST);
    }




}
