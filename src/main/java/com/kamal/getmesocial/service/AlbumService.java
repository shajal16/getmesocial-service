package com.kamal.getmesocial.service;

import com.kamal.getmesocial.model.Album;
import com.kamal.getmesocial.repository.AlbumRepository;
import com.kamal.getmesocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public Album getAlbum() {
        return albumRepository.getAlbum();
    }

    public Album createAlbum(Album album) {
        return albumRepository.createAlbum(album);
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
    }
}
