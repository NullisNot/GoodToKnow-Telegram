package com.example.telegramnotifications.controller;

import com.example.telegramnotifications.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelegramController {

    @Autowired
    private TelegramService telegramService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        System.out.println("Received request to send message: " + message);
        telegramService.sendMessage(message);
        return "Message sent to Telegram!";
    }
}
