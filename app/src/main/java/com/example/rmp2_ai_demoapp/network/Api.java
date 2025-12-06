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
            "Authorization: Bearer "
    })
    @POST("chat/completions")
    Call<OpenRouterResponse> sendMessage(@Body OpenRouterRequest request);
}
