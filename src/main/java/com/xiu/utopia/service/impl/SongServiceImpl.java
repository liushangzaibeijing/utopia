package com.xiu.utopia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.xiu.utopia.common.enums.DeleteType;
import com.xiu.utopia.dao.AlbumMapper;
import com.xiu.utopia.dao.BusSongMapper;
import com.xiu.utopia.dao.SingerMapper;
import com.xiu.utopia.entity.*;
import com.xiu.utopia.service.SongService;
import com.xiu.utopia.vo.SongPlayInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    /**
     * 专辑信息持久化类
     */
    @Autowired
    AlbumMapper albumMapper;

    @Override
    public Page<Song> querySongList(Integer singerId, String albumMid, Integer currentPage, Integer pageSize) {
        SongExample songExample = new SongExample();
        SongExample.Criteria criteria = songExample.createCriteria();
        criteria.andIsDeleteEqualTo(DeleteType.NO_DELETE.getCode());
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

    @Override
    public SongPlayInfo getSongPlayInfo(Integer songId) {
        Song song = busSongMapper.selectLyric(songId);
        String lyricEncoder = song.getLyric();
        SongPlayInfo songPlayInfo = new SongPlayInfo();
        if(StringUtils.isBlank(lyricEncoder)){
            songPlayInfo.setNolyric(true);
        }else{
              //获取歌词信息
              String lyric = new String (Base64.decode(lyricEncoder));
              songPlayInfo.setLyric(lyric);
              songPlayInfo.setNolyric(false);
        }
        //设置专辑信息
        String albumId = song.getAlbumId();
        songPlayInfo.setAlbumId(albumId);
        AlbumExample albumQuery = new AlbumExample();
        albumQuery.createCriteria().andAlbumMidEqualTo(albumId);
        List<Album> albums = albumMapper.selectByExample(albumQuery);

        if(albums!=null && albums.size()!=0){
            Album album = albums.get(0);
            String albumName = album.getAlbumName();
            songPlayInfo.setAlbumName(albumName);
            songPlayInfo.setAlbumUrl(album.getAlbumPic());
        }
        String singerMid = song.getSingerMid();

        SingerExample singerQuery = new SingerExample();
        singerQuery.createCriteria().andSignerMidEqualTo(singerMid);
        List<Singer> singers = singerMapper.selectByExample(singerQuery);
        if(singers!=null && singers.size()!=0){
            String singerUrl = singers.get(0).getPicLocal();
            songPlayInfo.setSingerUrl(singerUrl);
        }
        return songPlayInfo;
    }
}