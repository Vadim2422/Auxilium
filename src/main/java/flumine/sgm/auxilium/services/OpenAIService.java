package flumine.sgm.auxilium.services;

import flumine.sgm.auxilium.requests.openai.OpenAIChatCompletionRequest;
import flumine.sgm.auxilium.requests.openai.OpenAICompletionRequest;
import flumine.sgm.auxilium.requests.openai.OpenAIMessage;
import flumine.sgm.auxilium.requests.openai.OpenAIRequestBody;
import flumine.sgm.auxilium.responses.openai.OpenAIChatCompletionResponse;
import flumine.sgm.auxilium.responses.openai.OpenAICompletionResponse;
import flumine.sgm.auxilium.repositories.ModelClassificationRepository;
import flumine.sgm.auxilium.repositories.UserRepository;

import flumine.sgm.auxilium.responses.openai.OpenAIModelData;
import flumine.sgm.auxilium.responses.openai.OpenAIModelsResponse;
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

    protected String _baseUrl = "https://api.openai.com/v1";

    protected WebClient _webClient;

    protected long _defaultTemperature = 1;

    public OpenAIService() {
        this._webClient = WebClient.builder()
                .baseUrl(this._baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization",  "Bearer " + this.token)
                .build();
    }

    public Mono<OpenAICompletionResponse> sendCompletion(
            String model,
            String prompt) throws WebClientException {
        var body = new OpenAICompletionRequest(
                model,
                prompt,
                100,
                this._defaultTemperature
        );

        return this._webClient
                .method(HttpMethod.POST)
                .uri("/completions")
                .body(Mono.just(body), OpenAICompletionRequest.class)
                .retrieve()
                .bodyToMono(OpenAICompletionResponse.class);
    }

    public Mono<OpenAIChatCompletionResponse> sendChatCompletionWithContext(
        String model,
        Vector<OpenAIMessage> messages
    ) {
        var body = new OpenAIChatCompletionRequest(model, messages);

        return this._webClient
                .method(HttpMethod.POST)
                .uri("/chat/completions")
                .body(Mono.just(body), OpenAIChatCompletionRequest.class)
                .retrieve()
                .bodyToMono(OpenAIChatCompletionResponse.class);
    }

    public Mono<OpenAIModelsResponse> getAllModels() {
        return this._webClient
                .method(HttpMethod.GET)
                .uri("/models")
                .retrieve()
                .bodyToMono(OpenAIModelsResponse.class);
    }

    public Mono<OpenAIModelData> getModelInfo(String modelName) {
        return this._webClient
                .method(HttpMethod.GET)
                .uri("/models/" + modelName)
                .retrieve()
                .bodyToMono(OpenAIModelData.class);
    }
}
