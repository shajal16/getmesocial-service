package com.kamal.getmesocial.repository;

import com.kamal.getmesocial.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {
    List<Album> albumList = new ArrayList<>();

    public Album getAlbum() {
        Album album = new Album(1, "Recent Photos", "All photos within one month", "https://avatars.githubusercontent.com/u/11277764?v=4");
        return album;
    }

    public Album createAlbum(Album album) {
        album.setAlbumId(albumList.size() + 1);
        albumList.add(album);
        return album;

    }
    public List<Album> getAllAlbum() {
        return albumList;

    }

    public Album getSingleAlbum(int albumId) {
        for(Album album:albumList){
            if(album.getAlbumId() == albumId){
                return album;
            }
        }
        return null;
    }
    public Album updateAlbum(int albumId, Album album) {
        for(Album album1:albumList){
            if(album1.getAlbumId() == albumId){
                album1.setName(album.getName());
                album1.setDescription(album.getDescription());
                album1.setCoverPicUrl(album.getCoverPicUrl());
                return album1;
            }

        }
        return null;
    }

    public Album deleteAlbum(int albumId) {
        for(Album album: albumList){
            if(album.getAlbumId() == albumId){
                albumList.remove(album);
                return album;
            }
        }
        return null;
    }
}
