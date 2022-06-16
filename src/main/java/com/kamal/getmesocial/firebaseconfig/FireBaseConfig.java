package com.kamal.getmesocial.firebaseconfig;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireBaseConfig {
    @Bean
    public FirebaseApp firebaseAdmin() throws IOException {
        PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
        Resource resource = path.getResource("classpath:getmesocial-firebase.json");

        FileInputStream serviceAccount = new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://getmesocial.firebaseio.com/")
                .build();

        return FirebaseApp.initializeApp(options);

    }
}
