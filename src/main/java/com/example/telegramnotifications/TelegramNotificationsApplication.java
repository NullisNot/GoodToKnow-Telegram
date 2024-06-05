package com.example.telegramnotifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.telegramnotifications.controller",
        "com.example.telegramnotifications.service"
})
public class TelegramNotificationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramNotificationsApplication.class, args);
    }
}

