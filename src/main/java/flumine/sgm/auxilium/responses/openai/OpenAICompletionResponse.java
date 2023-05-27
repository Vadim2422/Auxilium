package flumine.sgm.auxilium.responses.openai;

public class OpenAICompletionResponse {
    protected String model;
    protected String prompt;
    protected long max_tokens;
    protected float temperature;
    protected int top_p;
    protected int n;
    protected boolean stream;
    protected int logprobs;
    protected String stop;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public long getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(long max_tokens) {
        this.max_tokens = max_tokens;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getTop_p() {
        return top_p;
    }

    public void setTop_p(int top_p) {
        this.top_p = top_p;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public int getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(int logprobs) {
        this.logprobs = logprobs;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }
}
