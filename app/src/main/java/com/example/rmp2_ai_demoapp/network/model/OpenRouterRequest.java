package com.example.rmp2_ai_demoapp.network.model;

import java.util.List;

public class OpenRouterRequest {
    private String model;
    private List<Message> messages;

    public OpenRouterRequest(List<Message> messages) {
        this.model = "tngtech/deepseek-r1t2-chimera:free";
        this.messages = messages;
    }
}

