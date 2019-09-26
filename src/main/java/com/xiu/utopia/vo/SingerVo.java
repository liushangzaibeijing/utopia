package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Singer;

public class SingerVo extends Singer {
    private Integer musicSize;

    private Integer albumSize;

    private Integer mvSize;

    public Integer getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(Integer musicSize) {
        this.musicSize = musicSize;
    }

    public Integer getAlbumSize() {
        return albumSize;
    }

    public void setAlbumSize(Integer albumSize) {
        this.albumSize = albumSize;
    }

    public Integer getMvSize() {
        return mvSize;
    }

    public void setMvSize(Integer mvSize) {
        this.mvSize = mvSize;
    }
}
