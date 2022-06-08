package com.kamal.getmesocial.exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage(){
        return "Restricted info";
    }
}
