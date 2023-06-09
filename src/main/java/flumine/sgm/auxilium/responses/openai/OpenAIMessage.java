package flumine.sgm.auxilium.responses.openai;

import flumine.sgm.auxilium.models.MessageModel;

public class OpenAIMessage {
    protected String role;
    protected String content;

    public OpenAIMessage() {}

    public OpenAIMessage(String role, String content) {
        this.role = role;
        this.content = content;
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
