package flumine.sgm.auxilium.requests.openai;

public class OpenAIMessage {
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
