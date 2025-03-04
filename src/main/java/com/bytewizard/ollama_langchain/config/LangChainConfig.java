package com.bytewizard.ollama_langchain.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LangChainConfig {

    @Bean
    ChatLanguageModel chatLanguageModel() {
        return OllamaChatModel.builder()
                .modelName("deepseek-r1")
                .baseUrl("http://localhost:11434")
                .build();
    }
}