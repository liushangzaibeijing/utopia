package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Song;

public interface SongService {
    Page<Song> querySongList(Integer singerId, String albumMid, Integer currentPage, Integer pageSize);
}
