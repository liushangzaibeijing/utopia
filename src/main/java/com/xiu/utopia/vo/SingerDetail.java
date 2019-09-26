package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.entity.Song;

import java.io.Serializable;
import java.util.List;

/**
 * 歌手详细信息 包括歌手和热门歌曲信息
 */
public class SingerDetail implements Serializable{

    private SingerVo singer;

    private List<Song> hotSongs;

    public List<Song> getHotSongs() {
        return hotSongs;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(SingerVo singer) {
        this.singer = singer;
    }

    public void setHotSongs(List<Song> hotSongs) {
        this.hotSongs = hotSongs;
    }
}
