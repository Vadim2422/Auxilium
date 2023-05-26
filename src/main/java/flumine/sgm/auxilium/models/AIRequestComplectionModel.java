package flumine.sgm.auxilium.models;

/*
{
  "model": "text-davinci-003",
  "prompt": "Say this is a test",
  "max_tokens": 7,
  "temperature": 0,
  "top_p": 1,
  "n": 1,
  "stream": false,
  "logprobs": null,
  "stop": "\n"
}*/
public class AIRequestComplectionModel {
    Long id;//room_id
    String model;//type AI

    String prompt;

    int max_tokens;

    double temperature;

    double t_top;

    int n;

    boolean stream;

    int logprobs;


    public AIRequestComplectionModel() {
    }


    public AIRequestComplectionModel(Long id, String model, String prompt) {
        this.id = id;
        this.model = model;
        this.prompt = prompt;
        this.max_tokens = 10;
        this.temperature = 0.7;
        this.t_top = 1;
        this.n = 10;
        this.stream = false;
        this.logprobs = 0;

    }
}
