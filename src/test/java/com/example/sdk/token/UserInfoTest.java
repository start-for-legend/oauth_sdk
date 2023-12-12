package com.example.sdk.token;

import com.example.sdk.data.KakaoResponse;
import com.example.sdk.data.KakaoTokenResponse;
import com.example.sdk.object.PrivateConfig;
import com.example.sdk.service.GetKakaoUserInfoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class UserInfoTest {

    @Mock
    private WebClient webClient;

    @MockBean
    private GetKakaoUserInfoService getKakaoUserInfoService;

    class l {
        private String email;

        public String getEmail() {
            return email;
        }

        public l() {

        }

        public l(String email) { }
    }

    @Test
    public void test() {
        PrivateConfig config = new PrivateConfig("http://localhost:3000", "CLIENT_ID");

        KakaoResponse<l> response = getKakaoUserInfoService.getUserInfo("Test", config);

        System.out.println(response);
    }
}
