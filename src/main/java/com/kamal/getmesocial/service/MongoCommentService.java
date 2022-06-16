package com.kamal.getmesocial.service;

import com.kamal.getmesocial.model.Album;
import com.kamal.getmesocial.model.MongoComment;
import com.kamal.getmesocial.model.MongoPhoto;
import com.kamal.getmesocial.repository.MongoAlbumRepository;
import com.kamal.getmesocial.repository.MongoCommentRepository;
import com.kamal.getmesocial.repository.MongoPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoCommentService {
    @Autowired
    private MongoCommentRepository mongoCommentRepository;



    public MongoComment createComment(MongoComment mongoComment, String name) {
        mongoComment.setCreatedBy(name);
        return mongoCommentRepository.save(mongoComment);
    }

    public List<MongoComment> getAllComments() {
        return mongoCommentRepository.findAll();
    }

    public MongoComment updateComment(MongoComment mongoComment) {
        return mongoCommentRepository.save(mongoComment);
    }

    public void deleteComment(String commentId, String user) throws Exception {
        Optional<MongoComment> ph =  mongoCommentRepository.findById(user);
        if(ph.get().getCreatedBy().equals(user)){
            mongoCommentRepository.deleteById(commentId);
        }else{
            throw new Exception("WRONG USER");
        }

    }

    public Optional<MongoComment> getById(String id) {
        return mongoCommentRepository.findById(id);
    }

/*    public Album getAlbum() {
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
