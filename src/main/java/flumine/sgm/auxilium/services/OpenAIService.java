package flumine.sgm.auxilium.services;

import flumine.sgm.auxilium.requests.openai.OpenAIChatCompletionsRequest;
import flumine.sgm.auxilium.requests.openai.OpenAIMessage;
import flumine.sgm.auxilium.requests.openai.OpenAIRequestBody;
import flumine.sgm.auxilium.responses.openai.OpenAICompletionResponse;
import flumine.sgm.auxilium.responses.openai.OpenAIMessageBody;
import flumine.sgm.auxilium.responses.openai.OpenAIMessageResponse;
import flumine.sgm.auxilium.repositories.ModelClassificationRepository;
import flumine.sgm.auxilium.repositories.UserRepository;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

import java.util.Vector;


@Service
public class OpenAIService {
    // Token for OpenAI
    // protected String token = "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";
    protected String token = "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";

    protected String _baseUrl = "https://api.openai.com/v1/";

    // Injected repositories
    protected UserRepository _userRepository;
    protected ModelClassificationRepository _modelRepository;

    protected WebClient _webClient;

    /// Temperature controls flow of fantasies of model. Let's use something in the
    /// middle for proper work
    protected long _defaultTemperature = 1;

    // NOTE: for some reason this shit don't work, will do this latter
    // static protected Logger _openAILogger;

    // Constructor

    public OpenAIService(UserRepository userRepository,
                         ModelClassificationRepository modelClassificationRepository) {
        this._userRepository = userRepository;
        this._modelRepository = modelClassificationRepository;
        this._webClient = WebClient.builder()
                .baseUrl(this._baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization",  "Bearer " + this.token)
                .build();
    }

    // TODO: Void -> ?Model?
    public void sendMessageToChat(Integer id, String message_text) {
        try {
            var response = this.sendMessage("gpt-3.5-turbo", message_text);
            response.subscribe(openAIMessageResponse ->
                    System.out.println(openAIMessageResponse
                            .getPrompt())
            );
        } catch (WebClientException exception) {
            System.out.println(exception);
        }
    }

    protected Mono<OpenAICompletionResponse> sendMessage(
            String model,
            String msg) throws WebClientException {
        var body = new OpenAIChatCompletionsRequest();
        body.setModel("model");
        var messages = new Vector<OpenAIMessage>();
        var message = new OpenAIMessage();
        message.setRole("user");
        message.setContent(msg);
        messages.add(message);
        body.setMessages(messages);

        return this._webClient
                .method(HttpMethod.POST)
                .uri("/chat/completions")
                .body(Mono.just(body), OpenAIRequestBody.class)
                .bodyToMono(mono -> {
                  if (mono.getStatus() == HttpStatus.OK) {

                  }
                });
    }
}
