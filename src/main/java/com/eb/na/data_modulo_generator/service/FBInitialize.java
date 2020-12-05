package com.eb.na.data_modulo_generator.service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

@Service
public class FBInitialize {
    
    @PostConstruct
    public void initialize() throws IOException{
        try {
        InputStream serviceAccount = this.getClass().getClassLoader()
            .getResourceAsStream("./keeper-bd-firebase-adminsdk-x9x4q-35ed8fd10c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://keeper-bd.firebaseio.com")
            .build();

        FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Firestore getFirebase(){
        return FirestoreClient.getFirestore();
    }
}
