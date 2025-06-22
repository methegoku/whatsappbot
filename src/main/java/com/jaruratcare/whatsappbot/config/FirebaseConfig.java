package com.jaruratcare.whatsappbot.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() {
        try {
            /*
                Here, I created Environment Variable in Render and used that for deployment on Render.
                You can also use your own JSON private key in firebase config.
                Just remove the lines from (28 to 35) and add this line

                * FileInputStream serviceAccount = new FileInputStream("src/main/resources/your-firebase-file.json"); *

            */

            String firebaseConfig = System.getenv("FIREBASE_CONFIG");

            if (firebaseConfig == null || firebaseConfig.isEmpty()) {
                System.err.println("FIREBASE_CONFIG is empty or missing.");
                return;
            }

            InputStream serviceAccount = new ByteArrayInputStream(firebaseConfig.getBytes(StandardCharsets.UTF_8));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase initialized successfully");
            }

        } catch (Exception e) {
            System.err.println("Firebase initialization failed");
            e.printStackTrace();
        }
    }
}
