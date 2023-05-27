package flumine.sgm.auxilium.requests.openai;

import java.util.Vector;

public class OpenAIChatCompletionRequest {
    protected String model;
    protected Vector<OpenAIMessage> messages;

    public OpenAIChatCompletionRequest() {}

    public OpenAIChatCompletionRequest(String model, Vector<OpenAIMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vector<OpenAIMessage> getMessages() {
        return messages;
    }

    public void setMessages(Vector<OpenAIMessage> messages) {
        this.messages = messages;
    }
}
