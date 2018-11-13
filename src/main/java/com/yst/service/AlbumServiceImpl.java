package com.yst.service;

import com.yst.dao.AlbumDAO;
import com.yst.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements  AlbumService {
    @Autowired
    private AlbumDAO albumDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album findOne(String id) {
        return albumDAO.queryOne(id);
    }

    @Override
    public void add(Album album) {
        album.setAlbumId(UUID.randomUUID().toString());
        album.setAlbumPublishDate(new Date());
        albumDAO.insert(album);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Album> findAll() {
        return albumDAO.queryAll();
    }
}
