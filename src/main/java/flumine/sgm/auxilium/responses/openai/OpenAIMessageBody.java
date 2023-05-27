package flumine.sgm.auxilium.responses.openai;

import java.io.Serializable;

public class OpenAIMessageBody {
    private Integer index;
    private String finish_reason;

    private OpenAIMessageContent message;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public OpenAIMessageContent getMessage() {
        return message;
    }

    public void setMessage(OpenAIMessageContent message) {
        this.message = message;
    }
}
