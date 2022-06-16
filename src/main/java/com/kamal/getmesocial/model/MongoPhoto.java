package com.kamal.getmesocial.model;

import com.kamal.getmesocial.validation.ValidCreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Photo")


public class MongoPhoto {
    @Id
    private String id;
    private String albumId;
    private String photoUrl;
    @ValidCreatedBy
    private String createdBy;
    private String dateCreated;

    public MongoPhoto() {

    }

    public MongoPhoto(String albumId, String photoUrl, String createdBy, String dateCreated) {
        this.albumId = albumId;
        this.photoUrl = photoUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
