package com.aldocursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorizador")
public class CategorizadorDeProductosController {

    private final ChatClient chatClient;

    public CategorizadorDeProductosController(@Qualifier("gpt-4o-mini")  ChatClient chatClient) {
        this.chatClient =  chatClient;
    }

    @GetMapping()
    public String categorizarProductos(String producto) {
        var system = """
                Actúa como un categorizador de productos y debes responder solo el nombre de la categoría del producto informado
                
                                Escoge una categoría de la siguiente lista:
                
                                1. Higiene Personal
                                2. Electrónicos
                                3. Deportes
                                4 Otros
                
                                Ejemplo de uso:
                
                                Producto: Pelota de fútbol
                                Respuesta: Deportes
                """;
        return this.chatClient.prompt()
                .system(system)
                .user(producto)
                .options(ChatOptions.builder()
                        .model("gpt-4o")
                        .temperature(0.90)
                        .build())
                .call()
                .content();
    }
}
