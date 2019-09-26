package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Album;


public interface AlbumService {
    Page<Album> queryAlbumList(Integer singerId, Integer currentPage, Integer pageSize);
}
