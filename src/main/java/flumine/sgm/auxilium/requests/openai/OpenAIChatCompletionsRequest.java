package flumine.sgm.auxilium.requests.openai;

import java.util.Vector;

/**
 * OpenAIChatCompletionsRequest
 */
public class OpenAIChatCompletionsRequest {
  protected String model;
  protected Vector<OpenAIMessage> messages;

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Vector<OpenAIMessage> getMessages() {
    return this.messages;
  }

  public void setMessages(Vector<OpenAIMessage> messages) {
    this.messages = messages;
  }
}
