package com.xiu.utopia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.utopia.dao.BusAlbumMapper;
import com.xiu.utopia.dao.SingerMapper;
import com.xiu.utopia.dao.SongMapper;
import com.xiu.utopia.entity.Album;
import com.xiu.utopia.entity.AlbumExample;
import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AblumServiceImpl implements AlbumService {

    /**
     * 歌曲信息持久化类
     */
    @Autowired
    SongMapper songMapper;

    /**
     * 歌手信息持久化类
     */
    @Autowired
    SingerMapper singerMapper;

    /**
     * 专辑信息持久化类
     */
    @Autowired
    BusAlbumMapper albumMapper;


    @Override
    public Page<Album> queryAlbumList(Integer singerId
    , Integer currentPage, Integer pageSize) {
        Long startTime = System.currentTimeMillis();
        Singer singer = singerMapper.selectByPrimaryKey(singerId);
        
        AlbumExample albumQuery = new AlbumExample();
        PageHelper.startPage(currentPage,pageSize);
        albumQuery.createCriteria().andSignerMidEqualTo(singer.getSignerMid());
        Page<Album> albums = (Page<Album>) albumMapper.selectByExample(albumQuery);

        Long endTime = System.currentTimeMillis();
        log.info("总共用时：{}",(endTime-startTime)/100);
        return albums;
    }
}
