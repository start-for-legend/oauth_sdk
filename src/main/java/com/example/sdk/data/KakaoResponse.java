package com.example.sdk.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class KakaoResponse<T> {
    private Long id;
    private String connected_at;
    private T account;
}
