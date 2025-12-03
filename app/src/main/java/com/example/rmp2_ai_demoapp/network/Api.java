package com.example.rmp2_ai_demoapp.network;

import com.example.rmp2_ai_demoapp.network.model.OpenRouterRequest;
import com.example.rmp2_ai_demoapp.network.model.OpenRouterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer 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"
    })
    @POST("chat/completions")
    Call<OpenRouterResponse> sendMessage(@Body OpenRouterRequest request);
}
