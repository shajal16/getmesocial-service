package com.kamal.getmesocial.resources;

import com.kamal.getmesocial.model.Album;
import com.kamal.getmesocial.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResources {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public Album getAlbum() {
        return albumService.getAlbum();

    }

    @PostMapping("/album")
    public Album createAlbum(@RequestBody Album album){
        albumService.createAlbum(album);
        return album;
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

    }


}
