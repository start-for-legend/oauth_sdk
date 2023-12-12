package com.example.sdk.service;

import com.example.sdk.data.KakaoResponse;
import com.example.sdk.data.KakaoTokenResponse;
import com.example.sdk.object.PrivateConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class GetKakaoUserInfoService {

    private final WebClient webClient;
    private static final String USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";
    private final GetKakaoTokenService getKakaoTokenService;

    public KakaoResponse getUserInfo(String code, PrivateConfig config) {
        KakaoTokenResponse tokenResponse = getKakaoTokenService.execute(code, config);
        Flux<KakaoResponse> response = fetchKakaoUserInfo(tokenResponse.getAccess_token());

        return response.blockFirst();
    }

    private Flux<KakaoResponse> fetchKakaoUserInfo(String accessToken) {
        return webClient.get()
                .uri(USER_INFO_URI)
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToFlux(KakaoResponse.class);
    }
}
