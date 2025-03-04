package com.bytewizard.ollama_langchain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatbotController {

    @GetMapping("/chatbot")
    public String chatbot() {
        return "chatbot"; // Maps to src/main/resources/templates/chatbot.html
    }
}