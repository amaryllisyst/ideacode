package com.yst.service;

import com.yst.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> findAll();
    public void add(Album album);
    public Album findOne(String id);
}
