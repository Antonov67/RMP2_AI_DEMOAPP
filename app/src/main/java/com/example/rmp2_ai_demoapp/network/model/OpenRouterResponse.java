package com.example.rmp2_ai_demoapp.network.model;

import java.util.List;

public class OpenRouterResponse {
    public List<Choice> choices;

    public static class Choice {
        public Message message;
    }
}
