package flumine.sgm.auxilium.responses.openai;

import jakarta.annotation.Nullable;

import java.util.Vector;


/// Primary response from OpenAI API
@Nullable
public class OpenAIMessageResponse {

    private Long id;
    private String object;
    private Long created;
    private String model;

    private OpenAIMessageUsage usage;
    private Vector<OpenAIMessageBody> choices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OpenAIMessageUsage getUsage() {
        return usage;
    }

    public void setUsage(OpenAIMessageUsage usage) {
        this.usage = usage;
    }

    public Vector<OpenAIMessageBody> getChoices() {
        return choices;
    }

    public void setChoices(Vector<OpenAIMessageBody> choices) {
        this.choices = choices;
    }
}
