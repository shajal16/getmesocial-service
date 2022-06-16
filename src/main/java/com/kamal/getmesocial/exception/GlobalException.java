package com.kamal.getmesocial.exception;

import com.google.firebase.ErrorCode;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity<String> RestrictedInfoError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(IdTokenException.class)
    public ResponseEntity<String> IdTokenError(IdTokenException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }


    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementEx(){
        return "Data Doesn't Exist";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValid(){
        return "Please Provide Proper Data";
    }


}
