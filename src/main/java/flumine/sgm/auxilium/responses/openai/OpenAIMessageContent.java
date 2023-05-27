package flumine.sgm.auxilium.responses.openai;

import java.io.Serializable;

public class OpenAIMessageContent {
    private String role;
    private String content;

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
