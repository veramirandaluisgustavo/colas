package com.SERVER_CONTROLLER.CONTROLLER.firebase_config;

import java.io.FileInputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;


@Configuration
public class FireBaseConfig {
    @Bean
    public Firestore firestore()throws Exception{
        
    

    FileInputStream refreshToken = new FileInputStream("farmacia-be78e-firebase-adminsdk-k0g7v-2864cf653e.json");

FirebaseOptions options = FirebaseOptions.builder()
    .setCredentials(GoogleCredentials.fromStream(refreshToken))
    .build();

    FirebaseApp app =FirebaseApp.initializeApp(options);
    return FirestoreClient.getFirestore(app);

    }
 
}
