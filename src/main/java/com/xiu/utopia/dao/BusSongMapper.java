package com.xiu.utopia.dao;

import com.xiu.utopia.entity.Song;
import com.xiu.utopia.entity.SongExample;

import java.util.List;

public interface BusSongMapper extends SongMapper {
    List<Song> selectSongPage(SongExample example);


}