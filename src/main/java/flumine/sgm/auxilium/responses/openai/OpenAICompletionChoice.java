package flumine.sgm.auxilium.responses.openai;

import jakarta.annotation.Nullable;

public class OpenAICompletionChoice {
    protected String text;
    protected Integer index;

    @Nullable
    protected String logprobs;

    protected String finish_reason;

    public OpenAICompletionChoice() {}

    public OpenAICompletionChoice(String text, Integer index, @Nullable String logprobs, String finish_reason) {
        this.text = text;
        this.index = index;
        this.logprobs = logprobs;
        this.finish_reason = finish_reason;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Nullable
    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(@Nullable String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
