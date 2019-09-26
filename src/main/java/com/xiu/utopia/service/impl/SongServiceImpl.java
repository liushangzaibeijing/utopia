package com.xiu.utopia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.utopia.dao.BusSongMapper;
import com.xiu.utopia.dao.SingerMapper;
import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.entity.Song;
import com.xiu.utopia.entity.SongExample;
import com.xiu.utopia.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SongServiceImpl implements SongService {
    /**
     * 歌曲信息持久化类
     */
    @Autowired
    SingerMapper singerMapper;
    /**
     * 歌手信息持久化类
     */
    @Autowired
    BusSongMapper busSongMapper;

    @Override
    public Page<Song> querySongList(Integer singerId, String albumMid, Integer currentPage, Integer pageSize) {
        SongExample songExample = new SongExample();
        SongExample.Criteria criteria = songExample.createCriteria();

        if(!StringUtils.isEmpty(albumMid)){
            criteria.andAlbumIdEqualTo(albumMid);
        }else{
            //获取歌手信息
            Singer singer = singerMapper.selectByPrimaryKey(singerId);
            String singerMid = singer.getSignerMid();
            criteria.andSingerMidEqualTo(singerMid);
        }
        //获取歌曲列表信息 50首歌曲
        PageHelper.startPage(currentPage,pageSize);
        Page<Song> songs = (Page<Song>) busSongMapper.selectSongPage(songExample);

        return songs;
    }
}