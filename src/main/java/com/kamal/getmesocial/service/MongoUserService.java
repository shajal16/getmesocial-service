package com.kamal.getmesocial.service;

import com.kamal.getmesocial.model.MongoUser;
import com.kamal.getmesocial.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MongoUserService {

    @Autowired
    private MongoUserRepository mongoUserRepository;

    public MongoUser createUser(MongoUser mongoUser) {
        return mongoUserRepository.save(mongoUser);
    }

    public List<MongoUser> getAllUsers() {
        return mongoUserRepository.findAll();
    }

    public List<MongoUser> getByName(String name) {
        return mongoUserRepository.findByName(name);
    }

    public MongoUser getById(String userId) {
        return mongoUserRepository.findById(userId).get();
    }


    public MongoUser updateMongoUser(MongoUser mongoUser) {
        return mongoUserRepository.save(mongoUser);
    }

    public void deleteUser(String userId) {
        mongoUserRepository.deleteById(userId);
    }



    /*public Album getAlbum() {
        return mongoAlbumRepository.getAlbum();
    }

    public List<Album> getAllAlbum() {
        return mongoAlbumRepository.getAllAlbum();
    }

    public Album getSingleAlbum(int albumId) {
        return mongoAlbumRepository.getSingleAlbum(albumId);
    }

    public Album updateAlbum(int albumId, Album album) {
        return mongoAlbumRepository.updateAlbum(albumId, album);
    }

    public Album deleteAlbum(int albumId) {
        return mongoAlbumRepository.deleteAlbum(albumId);
    }*/
}
