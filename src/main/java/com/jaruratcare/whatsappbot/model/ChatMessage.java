package com.jaruratcare.whatsappbot.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private String from;        //user phone number (or) ID
    private String message;     //user message
    private String botReply;    //chatbot reply
    private String timestamp;   //message time
}
