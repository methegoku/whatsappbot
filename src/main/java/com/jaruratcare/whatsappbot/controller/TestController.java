package com.jaruratcare.whatsappbot.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello From Jarurat Care..!";
    }

    @GetMapping("/firetest")
    public String testFireBase(){
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object>  data = new HashMap<>();
        data.put("name", "Gokul");
        data.put("message", "Testing Firebase");

        ApiFuture<WriteResult> result = db.collection("chats").document("test1").set(data);
        return "Data sent to Firebase";
    }
}
