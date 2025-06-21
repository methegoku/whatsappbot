package com.jaruratcare.whatsappbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatsappbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsappbotApplication.class, args);
		System.out.println("Whatsapp Backend is Running");
	}
}
