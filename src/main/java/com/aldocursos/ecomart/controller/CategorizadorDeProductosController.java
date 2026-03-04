package com.aldocursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorizador")
public class CategorizadorDeProductosController {

    private final ChatClient chatClient;

    public CategorizadorDeProductosController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping()
    public String categorizarProductos(String producto) {
        var system = "Eres un categorizador de productos. Solo dame la categoria.\n" +
                "ejemplo:\n" +
                "- cepillo de dientes\n" +
                "- Categoria: Higiene personal";
        return this.chatClient.prompt()
                .system(system)
                .user(producto)
                .options(ChatOptions.builder()
                        .temperature(0.90)
                        .build())
                .call()
                .content();
    }
}
