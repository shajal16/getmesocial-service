package com.kamal.getmesocial.model;

import com.kamal.getmesocial.validation.ValidCreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;

@Document(collection = "Album")

public class MongoAlbum {
    @Id
    private String id;
    @Max(value = 10) @ValidCreatedBy
    private String name;
    private String email;
    private String profilePhotoUrl;

    public MongoAlbum() {
        super();
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
