package com.giuseppefrattura.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    public final ChatClient chatClient;

    public CityController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("you are a city expert, you know everything about cities of the world.")
                .build();
    }

    @GetMapping("/cities")
    public String cityFaq(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }


}
