package com.example.sdk.service;


import com.example.sdk.data.KakaoTokenResponse;
import com.example.sdk.object.PrivateConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class GetKakaoTokenService {

    private static final String GRANT_TYPE = "authorization_code";
    private final WebClient webClient;

    public KakaoTokenResponse execute(String code, PrivateConfig config) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", GRANT_TYPE);
        formData.add("client_id", config.CLIENT_ID());
        formData.add("redirect_uri", config.REDIRECT_URI());
        formData.add("code", code);

        Flux<KakaoTokenResponse> response = webClient.post()
                .uri("/oauth/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .bodyValue(formData)
                .retrieve()
                .bodyToFlux(KakaoTokenResponse.class);

        return response.blockFirst();
    }
}
