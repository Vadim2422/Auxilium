package flumine.sgm.auxilium.requests.openai;

import java.io.Serializable;

public class OpenAIMessage implements Serializable {
    protected String role;
    protected String content;


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
