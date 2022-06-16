package com.kamal.getmesocial.resources;

import com.google.firebase.auth.FirebaseAuthException;
import com.kamal.getmesocial.exception.IdTokenException;
import com.kamal.getmesocial.exception.RestrictedInfoException;
import com.kamal.getmesocial.model.FirebaseUser;
import com.kamal.getmesocial.model.MongoUser;
import com.kamal.getmesocial.service.FirebaseAdminService;
import com.kamal.getmesocial.service.MongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MongoUserResource {
    @Autowired
    private MongoUserService mongoUserService;

    @Autowired
    private FirebaseAdminService firebaseAdminService;



    @PostMapping("/user")
    public MongoUser createUser(@RequestBody @Valid MongoUser mongoUser, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser fuser = firebaseAdminService.authentication(idToken);
        if(fuser != null){
            mongoUserService.createUser(mongoUser);
            return mongoUser;
        }else {
            return null;
        }


    }
    @GetMapping("/users")
    public List<MongoUser> getAllUsers() {
        return mongoUserService.getAllUsers();

    }
    @GetMapping("/user/name")
    public List<MongoUser> getByName(@RequestParam (name = "name") String name) throws RestrictedInfoException {
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return mongoUserService.getByName(name);

    }

    @GetMapping("/user")
    public MongoUser getById(@RequestParam (name = "id") String userId) {
        return mongoUserService.getById(userId);

    }

    @PutMapping("/user")
    public MongoUser updateMongoUser(@RequestBody MongoUser mongoUser, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser fuser = firebaseAdminService.authentication(idToken);
        if(fuser != null){
            return mongoUserService.updateMongoUser(mongoUser);
        }else {
            return null;
        }



    }
    @DeleteMapping("/user")
    public void deleteMongoUser(@RequestParam(name = "id") String userId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser fuser = firebaseAdminService.authentication(idToken);
        if(fuser != null){
            mongoUserService.deleteUser(userId);
        }


    }

}
