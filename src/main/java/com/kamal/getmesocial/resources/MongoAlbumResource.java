package com.kamal.getmesocial.resources;

import com.kamal.getmesocial.model.MongoAlbum;
import com.kamal.getmesocial.model.MongoComment;
import com.kamal.getmesocial.model.MongoPhoto;
import com.kamal.getmesocial.model.User;
import com.kamal.getmesocial.service.MongoAlbumService;
import com.kamal.getmesocial.service.MongoCommentService;
import com.kamal.getmesocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MongoAlbumResource {
    @Autowired
    private MongoAlbumService mongoAlbumService;

    @PostMapping("/album")
    public MongoAlbum createAlbum(@RequestBody MongoAlbum mongoAlbum){
        mongoAlbumService.createAlbum(mongoAlbum);
        return mongoAlbum;
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
    public MongoAlbum updateAlbum(@RequestBody MongoAlbum mongoAlbum){
        return mongoAlbumService.updateAlbum(mongoAlbum);

    }
    @DeleteMapping("/album")
    public void deleteMongoAlbum(@RequestParam(name = "id") String albumId) {
        mongoAlbumService.deleteAlbum(albumId);

    }

}
