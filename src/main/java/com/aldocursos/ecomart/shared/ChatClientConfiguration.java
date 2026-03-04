package com.aldocursos.ecomart.shared;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfiguration {

    @Bean
    @Qualifier("gpt-4o-mini")
    public ChatClient gpt4oMiniChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .defaultOptions(ChatOptions
                        .builder()
                        .model("gpt-4o-mini")
                        .build())
                .build();
    }

    @Bean
    @Qualifier("gpt-4o")
    public ChatClient gpt4oChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .defaultOptions(ChatOptions
                        .builder()
                        .model("gpt-4o")
                        .build())
                .build();
    }
}
