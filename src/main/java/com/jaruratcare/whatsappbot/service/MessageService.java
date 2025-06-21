package com.jaruratcare.whatsappbot.service;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.jaruratcare.whatsappbot.model.ChatMessage;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MessageService {

    public String saveMessage(ChatMessage chat) {
        try{
            Firestore db = FirestoreClient.getFirestore();

            //WE ARE ASSIGNING UNIQUE ID FOR EACH CHAT ENTRY
            String docId = UUID.randomUUID().toString();

            ApiFuture<com.google.cloud.firestore.WriteResult> result =
                    db.collection("message").document(docId).set(chat);

            return "Message Saved to Firebase at: " + result.get().getUpdateTime();
        }
        catch (Exception e){
           return "Failed to Save Message to Database";
        }
    }
}
