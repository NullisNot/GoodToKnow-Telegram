package com.example.telegramnotifications.controller;

import com.example.telegramnotifications.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelegramController {

    @Autowired
    private TelegramService telegramService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageRequest messageRequest) {
        System.out.println("Received request to send message: " + messageRequest.getMessage());
        telegramService.sendMessage(messageRequest.getMessage());
        return "Message sent to Telegram!";
    }
}
