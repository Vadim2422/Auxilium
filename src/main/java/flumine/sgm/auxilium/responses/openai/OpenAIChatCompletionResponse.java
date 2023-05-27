package flumine.sgm.auxilium.responses.openai;

import java.util.Vector;

public class OpenAIChatCompletionResponse {
    protected String id;
    protected String object;
    protected Integer created;
    protected Vector<OpenAIChatCompletionChoice> choices;
    protected OpenAIUsage usage;

    public OpenAIChatCompletionResponse() {}

    public OpenAIChatCompletionResponse(String id, String object, Integer created, Vector<OpenAIChatCompletionChoice> choices, OpenAIUsage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
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

    public Vector<OpenAIChatCompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(Vector<OpenAIChatCompletionChoice> choices) {
        this.choices = choices;
    }

    public OpenAIUsage getUsage() {
        return usage;
    }

    public void setUsage(OpenAIUsage usage) {
        this.usage = usage;
    }
}
