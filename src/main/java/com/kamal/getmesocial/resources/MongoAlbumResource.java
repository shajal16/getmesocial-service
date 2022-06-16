package com.kamal.getmesocial.resources;

import com.google.firebase.auth.FirebaseAuthException;
import com.kamal.getmesocial.exception.IdTokenException;
import com.kamal.getmesocial.model.*;
import com.kamal.getmesocial.service.FirebaseAdminService;
import com.kamal.getmesocial.service.MongoAlbumService;
import com.kamal.getmesocial.service.MongoCommentService;
import com.kamal.getmesocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MongoAlbumResource {
    @Autowired
    private MongoAlbumService mongoAlbumService;

    @Autowired
    private FirebaseAdminService firebaseAdminService;

    @PostMapping("/album")
    public MongoAlbum createAlbum(@RequestBody @Valid MongoAlbum mongoAlbum, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser falbum = firebaseAdminService.authentication(idToken);
        if(falbum != null){
            mongoAlbumService.createAlbum(mongoAlbum);
            return mongoAlbum;
        }else {
            return null;
        }

    }
    @GetMapping("/albums")
    public List<MongoAlbum> getAllAlbums() {
        return mongoAlbumService.getAllAlbums();

    }
    @GetMapping("/album")
    public Optional<MongoAlbum> getById(@RequestParam (name = "id") String id) {
        return mongoAlbumService.getById(id);

    }
    @PutMapping("/album")
    public MongoAlbum updateAlbum(@RequestBody MongoAlbum mongoAlbum, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser falbum = firebaseAdminService.authentication(idToken);
        if(falbum != null){
            return mongoAlbumService.updateAlbum(mongoAlbum);
        }else {
            return null;
        }


    }
    @DeleteMapping("/album")
    public void deleteMongoAlbum(@RequestParam(name = "id") String albumId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser falbum = firebaseAdminService.authentication(idToken);
        if(falbum != null){
            mongoAlbumService.deleteAlbum(albumId);
        }


    }

}
