package com.kamal.getmesocial.resources;

import com.google.firebase.auth.FirebaseAuthException;
import com.kamal.getmesocial.exception.IdTokenException;
import com.kamal.getmesocial.model.FirebaseUser;
import com.kamal.getmesocial.model.MongoPhoto;
import com.kamal.getmesocial.model.MongoUser;
import com.kamal.getmesocial.model.User;
import com.kamal.getmesocial.service.FirebaseAdminService;
import com.kamal.getmesocial.service.MongoPhotoService;
import com.kamal.getmesocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MongoPhotoResource {
    @Autowired
    private MongoPhotoService mongoPhotoService;

    @Autowired
    private FirebaseAdminService firebaseAdminService;

    @PostMapping("/photo")
    public MongoPhoto createPhoto(@RequestBody @Valid MongoPhoto mongoPhoto, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser fphoto = firebaseAdminService.authentication(idToken);
        if(fphoto != null){
            mongoPhotoService.createPhoto(mongoPhoto, fphoto.getName());
            return mongoPhoto;
        }else {
            return null;
        }

    }
    @GetMapping("/photos")
    public List<MongoPhoto> getAllPhotos() {
        return mongoPhotoService.getAllPhotos();

    }

    @GetMapping("/photo")
    public Optional<MongoPhoto> getById(@RequestParam (name = "id") String id) {
        return mongoPhotoService.getById(id);

    }
    @PutMapping("/photos")
    public MongoPhoto updateMongoPhotos(@RequestBody MongoPhoto mongoPhoto, @RequestHeader(name = "idToken") String idToken) throws Exception {

        FirebaseUser fphoto = firebaseAdminService.authentication(idToken);

        if(fphoto != null){

            String user = mongoPhoto.getCreatedBy();
            if(fphoto.getName().equals(user)){
                return mongoPhotoService.updateMongoPhotos(mongoPhoto);
            }else{
                throw new Exception("WRONG USER");
            }
        }else {
            return null;
        }

    }
    @DeleteMapping("/photo")
    public void deleteMongoPhoto(@RequestParam(name = "id") String photoId, @RequestHeader(name = "idToken") String idToken) throws Exception {
        FirebaseUser fphoto = firebaseAdminService.authentication(idToken);
        if(fphoto != null){

            mongoPhotoService.deletePhoto(photoId, fphoto.getName());
        }


    }


}
