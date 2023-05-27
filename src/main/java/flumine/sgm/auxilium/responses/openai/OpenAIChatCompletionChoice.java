package flumine.sgm.auxilium.responses.openai;

public class OpenAIChatCompletionChoice {
    protected Integer index;
    protected OpenAIMessage message;
    protected String finish_reason;

    public OpenAIChatCompletionChoice() {}

    public OpenAIChatCompletionChoice(Integer index, OpenAIMessage message, String finish_reason) {
        this.index = index;
        this.message = message;
        this.finish_reason = finish_reason;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public OpenAIMessage getMessage() {
        return message;
    }

    public void setMessage(OpenAIMessage message) {
        this.message = message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
