package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Song;
import com.xiu.utopia.vo.SongPlayInfo;

public interface SongService {
    Page<Song> querySongList(Integer singerId, String albumMid, Integer currentPage, Integer pageSize);


    /**
     * 获取歌曲信息
     * @param songId 歌曲id
     * @return 歌曲播放信息
     */
    SongPlayInfo getSongPlayInfo(Integer songId);
}
