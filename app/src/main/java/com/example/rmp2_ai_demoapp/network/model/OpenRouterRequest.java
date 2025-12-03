package com.example.rmp2_ai_demoapp.network.model;

import java.util.List;

public class OpenRouterRequest {
    private String model;
    private List<Message> messages;

    public OpenRouterRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }
}

