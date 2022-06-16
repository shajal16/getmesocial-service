package com.kamal.getmesocial.model;

public class FirebaseUser {
    private String uId;
    private String name;
    private String email;

    public FirebaseUser(String uId) {

    }

    public FirebaseUser(String uId, String name, String email) {
        this.uId = uId;
        this.name = name;
        this.email = email;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
