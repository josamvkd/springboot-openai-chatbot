package com.josamtechie.api.controller;

import com.josamtechie.api.dto.ChatGPTRequest;
import com.josamtechie.api.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class ChatBotController
{
    @Autowired
    private RestTemplate template;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt){
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        ChatGptResponse response = template.postForObject(apiUrl,request,ChatGptResponse.class);
        assert response != null;
        return response.getChoices().getFirst().getMessage().getContent();
    }
}
