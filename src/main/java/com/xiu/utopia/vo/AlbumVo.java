package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Album;
import com.xiu.utopia.entity.Song;

import java.util.List;

public class AlbumVo extends Album {
   List<Song>  songData;

    public List<Song> getSongData() {
        return songData;
    }

    public void setSongData(List<Song> songData) {
        this.songData = songData;
    }
}
