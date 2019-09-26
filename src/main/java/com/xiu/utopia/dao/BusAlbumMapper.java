package com.xiu.utopia.dao;

import com.xiu.utopia.entity.Album;

import java.util.List;

public interface BusAlbumMapper  extends AlbumMapper {
    List<Album> queryAlbumList(Integer id);
}