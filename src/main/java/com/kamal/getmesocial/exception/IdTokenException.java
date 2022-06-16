package com.kamal.getmesocial.exception;

import com.google.firebase.ErrorCode;
import com.google.firebase.IncomingHttpResponse;
import com.google.firebase.auth.AuthErrorCode;
import com.google.firebase.auth.FirebaseAuthException;

public class IdTokenException extends Exception{

    @Override
    public String getMessage() {
        return "SAD FACES: Invalid ID Token";
    }
}



