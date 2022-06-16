package com.kamal.getmesocial.service;

import com.kamal.getmesocial.model.MongoPhoto;
import com.kamal.getmesocial.repository.MongoPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoPhotoService {
    @Autowired
    private MongoPhotoRepository mongoPhotoRepository;



    public MongoPhoto createPhoto(MongoPhoto mongoPhoto, String name) {
        mongoPhoto.setCreatedBy(name);
        return mongoPhotoRepository.save(mongoPhoto);
    }

    public List<MongoPhoto> getAllPhotos() {
        return mongoPhotoRepository.findAll();
    }

    public MongoPhoto updateMongoPhotos(MongoPhoto mongoPhoto) {
        return mongoPhotoRepository.save(mongoPhoto);
    }

    public void deletePhoto(String id, String user) throws Exception {
        Optional<MongoPhoto> ph =  mongoPhotoRepository.findById(id);
        if(ph.get().getCreatedBy().equals(user)){
            mongoPhotoRepository.deleteById(id);
        }else{
            throw new Exception("WRONG USER");
        }

    }

    public Optional<MongoPhoto> getById(String id) {
        return mongoPhotoRepository.findById(id);
    }



/*public Album getAlbum() {
        return albumRepository.getAlbum();
    }

  public List<Album> getAllAlbum() {
        return albumRepository.getAllAlbum();
    }

    public Album getSingleAlbum(int albumId) {
        return albumRepository.getSingleAlbum(albumId);
    }

    public Album updateAlbum(int albumId, Album album) {
        return albumRepository.updateAlbum(albumId, album);
    }

    public Album deleteAlbum(int albumId) {
        return albumRepository.deleteAlbum(albumId);
    }*/
}
