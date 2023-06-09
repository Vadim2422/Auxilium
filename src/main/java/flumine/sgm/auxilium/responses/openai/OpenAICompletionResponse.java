package flumine.sgm.auxilium.responses.openai;

import java.util.Vector;

public class OpenAICompletionResponse {
    protected String id;
    protected String object;
    protected Integer created;
    protected String model;

    protected Vector<OpenAICompletionChoice> choices;

    protected OpenAIUsage usage;

    public OpenAICompletionResponse() {}

    public OpenAICompletionResponse(String id, String object, Integer created, String model, Vector<OpenAICompletionChoice> choices, OpenAIUsage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vector<OpenAICompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(Vector<OpenAICompletionChoice> choices) {
        this.choices = choices;
    }

    public OpenAIUsage getUsage() {
        return usage;
    }

    public void setUsage(OpenAIUsage usage) {
        this.usage = usage;
    }
}
