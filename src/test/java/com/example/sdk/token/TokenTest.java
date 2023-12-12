package com.example.sdk.token;

import com.example.sdk.data.KakaoTokenResponse;
import com.example.sdk.object.PrivateConfig;
import com.example.sdk.service.GetKakaoTokenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class TokenTest {

    @Mock
    private WebClient webClient;

    @MockBean
    private GetKakaoTokenService getKakaoTokenService;

    @Test
    public void test() {
        PrivateConfig config = new PrivateConfig("http://localhost:3000", "CLIENT_ID");

        KakaoTokenResponse response = getKakaoTokenService.execute("Test", config);
        System.out.println(response);
    }
}
