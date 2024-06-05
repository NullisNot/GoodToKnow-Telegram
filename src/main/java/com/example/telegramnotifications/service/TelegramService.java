package com.example.telegramnotifications.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Service
public class TelegramService {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.chat.id}")
    private String chatId;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendMessage(String message) {
        // Construir la URL de la API de Telegram
        String url = String.format("https://api.telegram.org/bot%s/sendMessage", botToken);

        // Configurar los headers HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // Construir el payload JSON
        String payload = String.format("{\"chat_id\": \"%s\", \"text\": \"%s\"}", chatId, message);
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        // Enviar la solicitud HTTP POST
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        // Verificar la respuesta
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Message sent successfully");
        } else {
            System.err.println("Error sending message: " + response.getBody());
        }
    }
}
