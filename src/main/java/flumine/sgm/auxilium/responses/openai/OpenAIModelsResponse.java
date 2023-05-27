package flumine.sgm.auxilium.responses.openai;

import java.util.Vector;

public class OpenAIModelsResponse {
    protected Vector<OpenAIModelData> data;
    protected String object;

    public OpenAIModelsResponse() {}

    public OpenAIModelsResponse(Vector<OpenAIModelData> data, String object) {
        this.data = data;
        this.object = object;
    }

    public Vector<OpenAIModelData> getData() {
        return data;
    }

    public void setData(Vector<OpenAIModelData> data) {
        this.data = data;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
