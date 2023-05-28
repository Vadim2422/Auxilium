package flumine.sgm.auxilium.requests.openai;

import flumine.sgm.auxilium.models.MessageModel;

import java.util.List;

public class OpenAIChatCompletionRequest {
    protected String model;
    protected List<OpenAIMessage> messages;

    public OpenAIChatCompletionRequest(String model, List<MessageModel> messages) {}

    public OpenAIChatCompletionRequest(String model, List<OpenAIMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<OpenAIMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<OpenAIMessage> messages) {
        this.messages = messages;
    }
}
