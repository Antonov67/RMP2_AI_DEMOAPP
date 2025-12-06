package com.example.rmp2_ai_demoapp.network.model;

public class Message {
    String role;
    String content;

    public Message(String content) {
        this.role = "user";
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
