package com.example.rmp2_ai_demoapp.service;

import androidx.annotation.NonNull;

import com.example.rmp2_ai_demoapp.network.Api;
import com.example.rmp2_ai_demoapp.network.callback.SimpleDataCallback;
import com.example.rmp2_ai_demoapp.network.model.Message;
import com.example.rmp2_ai_demoapp.network.model.OpenRouterRequest;
import com.example.rmp2_ai_demoapp.network.model.OpenRouterResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AiService {

    private final Api api;

    public AiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://openrouter.ai/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public void getHoroscope(String gender, String zodiac, SimpleDataCallback<String> callback) {
        List<Message> messages = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy, EEEE", new Locale("ru"));
        String formattedDate = sdf.format(date);
        String prompt = "Создай гороскоп для " + gender + " по знаку зодиака " + zodiac
                + " на " + formattedDate + ", ответь кратко и с юмором";
        messages.add(new Message(prompt));

        OpenRouterRequest request = new OpenRouterRequest(messages);

        Call<OpenRouterResponse> call = api.sendMessage(request);
        call.enqueue(new Callback<OpenRouterResponse>() {
            @Override
            public void onResponse(@NonNull Call<OpenRouterResponse> call, @NonNull Response<OpenRouterResponse> response) {
                if (!response.isSuccessful()) {
                    callback.onLoad(null);
                } else {
                    assert response.body() != null;
                    callback.onLoad(response.body().choices.get(0).message.getContent());
                }

            }

            @Override
            public void onFailure(Call<OpenRouterResponse> call, Throwable t) {

            }
        });

    }
}
