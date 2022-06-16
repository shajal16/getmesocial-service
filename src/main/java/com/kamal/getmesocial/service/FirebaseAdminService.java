package com.kamal.getmesocial.service;

import com.google.firebase.auth.AuthErrorCode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.kamal.getmesocial.exception.IdTokenException;
import com.kamal.getmesocial.model.FirebaseUser;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FirebaseAdminService {

    public FirebaseUser authentication(String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        try {
            String uId = FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
            String name = FirebaseAuth.getInstance().verifyIdToken(idToken).getName();
            String email = FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();
            return new FirebaseUser(uId, name, email);

        } catch (FirebaseAuthException ex) {
            if(ex.getAuthErrorCode() == AuthErrorCode.INVALID_ID_TOKEN){
                throw new IdTokenException();
            }
        }
        return null;
    }
}
