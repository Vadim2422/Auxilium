package flumine.sgm.auxilium.requests.openai;

/**
 * OpenAIChatCompletionsRequest
 */
public class OpenAICompletionRequest {
  protected String model;
  protected String prompt;
  protected Integer max_tokens;
  protected Long temperature;

  public OpenAICompletionRequest() {}

  public OpenAICompletionRequest(String model, String prompt, Integer max_tokens, Long temperature) {
    this.model = model;
    this.prompt = prompt;
    this.max_tokens = max_tokens;
    this.temperature = temperature;
  }

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

  public Integer getMax_tokens() {
    return max_tokens;
  }

  public void setMax_tokens(Integer max_tokens) {
    this.max_tokens = max_tokens;
  }

  public Long getTemperature() {
    return temperature;
  }

  public void setTemperature(Long temperature) {
    this.temperature = temperature;
  }
}
