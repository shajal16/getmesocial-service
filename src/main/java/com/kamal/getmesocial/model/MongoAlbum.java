package com.kamal.getmesocial.model;

import com.kamal.getmesocial.validation.ValidCreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Document(collection = "Album")

public class MongoAlbum {
    @Id
    private String id;
    @Size(max = 10, message = "Max size Must be 10") @ValidCreatedBy
    private String name;
    private String email;
    private String profilePhotoUrl;

    public MongoAlbum() {

    }

    public MongoAlbum(String name, String email, String profilePhotoUrl) {
        this.name = name;
        this.email = email;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
