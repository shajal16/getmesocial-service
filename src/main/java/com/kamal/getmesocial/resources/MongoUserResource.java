package com.kamal.getmesocial.resources;

import com.kamal.getmesocial.model.MongoUser;
import com.kamal.getmesocial.service.MongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MongoUserResource {
    @Autowired
    private MongoUserService mongoUserService;



    @PostMapping("/user")
    public MongoUser createUser(@RequestBody MongoUser mongoUser){
        mongoUserService.createUser(mongoUser);
        return mongoUser;
    }
    @GetMapping("/users")
    public List<MongoUser> getAllUsers() {
        return mongoUserService.getAllUsers();

    }
    @GetMapping("/user")
    public Optional<MongoUser> getById(@RequestParam (name = "id") String userId) {
        return mongoUserService.getById(userId);

    }
    @PutMapping("/user")
    public MongoUser updateMongoUser(@RequestBody MongoUser mongoUser) {
        return mongoUserService.updateMongoUser(mongoUser);

    }
    @DeleteMapping("/user")
    public void deleteMongoUser(@RequestParam(name = "id") String userId) {
        mongoUserService.deleteUser(userId);

    }
    /*
    @GetMapping("/album")
    public Album getAlbum() {
        return albumService.getAlbum();

    }
    @GetMapping("/albums")
    public List<Album> getAllAlbum() {
        return albumService.getAllAlbum();

    }
    @GetMapping("/album/{id}")
    public Album getSingleAlbum(@PathVariable("id") int albumId) {
        return albumService.getSingleAlbum(albumId);

    }

    @PutMapping("/album/{id}")
    public Album updateAlbum(@PathVariable("id") int albumId, @RequestBody Album album) {
        return albumService.updateAlbum(albumId, album);

    }

    @DeleteMapping("/album/delete/{id}")
    public Album deleteAlbum(@PathVariable("id") int albumId) {
        return albumService.deleteAlbum(albumId);

    }
    @DeleteMapping("/album")
    public Album deleteAlbumWithParam(@RequestParam(name = "id") int albumId) {
        return albumService.deleteAlbum(albumId);

    }*/


}
