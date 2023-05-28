package flumine.sgm.auxilium.requests.openai;

import flumine.sgm.auxilium.models.MessageModel;
import jakarta.mail.Message;

public class OpenAIMessage {//toString?
    protected String role;
    protected String content;

    public OpenAIMessage() {}

    public OpenAIMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }
    public OpenAIMessage(MessageModel model){
        this.role = model.getRole().name();
        this.content = model.getContent();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
