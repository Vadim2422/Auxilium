package flumine.sgm.auxilium.requests.openai;


import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;
import java.util.Vector;

public class OpenAIRequestBody {

    protected String model;

    protected String prompt;

//    protected Vector<OpenAIMessage> messages;

    protected Long temperature;

    protected long max_tokens;

    public long getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(long max_tokens) {
        this.max_tokens = max_tokens;
    }

    public String getModel() {
        return model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public Vector<OpenAIMessage> getMessages() {
//        return messages;
//    }

//    public void setMessages(Vector<OpenAIMessage> messages) {
//        this.messages = messages;
//    }


    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }
}
