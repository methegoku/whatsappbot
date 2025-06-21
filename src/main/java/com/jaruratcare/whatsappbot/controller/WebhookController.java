package com.jaruratcare.whatsappbot.controller;
import com.jaruratcare.whatsappbot.model.ChatMessage;
import com.jaruratcare.whatsappbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> recieveMessage(@RequestBody Map<String, Object> payload){
        System.out.println("Recieved Message Payload: "+payload);

        String from = payload.get("from").toString();
        String userMessage = payload.get("message").toString(); // ✅ dynamic from input

        String replyMessage = getString(userMessage);

        //SAVING TO FIREBASE
        ChatMessage chat = new ChatMessage(from, userMessage, replyMessage, java.time.LocalDate.now().toString());
        messageService.saveMessage(chat);

        return ResponseEntity.ok(replyMessage);
    }

    private static String getString(String userMessage) {
        String replyMessage;

        if(userMessage.equalsIgnoreCase("hi")){
            replyMessage = "Welcome to Jarurat Care! Type 1 for Services, 2 for Contact Info";
        }
        else if(userMessage.equals("1")){
            replyMessage = "We offer health checkups, medicine delivery, and home care services.";
        }
        else if(userMessage.equals("2")){
            replyMessage = "You can reach us at +91-1234567890 or care@jarurat.com";
        }
        else{
            replyMessage = "Sorry, I didn't understand that. Please type 1 or 2.";
        }
        return replyMessage;
    }
}
