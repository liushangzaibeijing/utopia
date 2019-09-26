package com.xiu.utopia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.utopia.dao.AlbumMapper;
import com.xiu.utopia.dao.BusSongMapper;
import com.xiu.utopia.dao.SingerMapper;
import com.xiu.utopia.entity.AlbumExample;
import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.entity.SongExample;
import com.xiu.utopia.service.SingerService;
import com.xiu.utopia.vo.SingerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SingerServiceImpl implements SingerService {
    /**
     * 歌手信息持久化
     */
    @Autowired
    SingerMapper singerMapper;
    /**
     * 歌曲信息持久化类
     */
    @Autowired
    BusSongMapper busSongMapper;
    /**
     * 专辑信息持久化类
     */
    @Autowired
    AlbumMapper albumMapper;
    /**
     * 查询热门歌手信息
     * @param limit
     * @return
     */
    @Override
    public Page<Singer> queryTopSingerList(Integer currentPage, Integer limit) {
        PageHelper.startPage(currentPage,limit);

        Page<Singer> singers = (Page<Singer>) singerMapper.selectByExample(null);

        return singers;
    }

    @Override
    public SingerVo querySingerAndRelation(Integer id) {
        //获取歌手信息
        Singer singer = singerMapper.selectByPrimaryKey(id);
        String singerMid = singer.getSignerMid();

        //歌手其他属性信息填充
        SingerVo singerVo = new SingerVo();
        BeanUtils.copyProperties(singer,singerVo);
        //歌曲总数量
        Integer musicSize = getMusicSize(singerMid);
        singerVo.setMusicSize(musicSize);
        //查询专辑数量
        Integer albumSize = getAlbumSize(singerMid);
        singerVo.setAlbumSize(albumSize);
        //查询MV数量 都为0目前没有mv
        singerVo.setMvSize(0);
        //构造前台需要的参数信息
        return singerVo;
    }

    private Integer getMusicSize(String singerMid) {
        //查询歌曲数量
        SongExample countQuery = new SongExample();
        countQuery.createCriteria().andSingerMidEqualTo(singerMid);
        final Integer musicSize = busSongMapper.countByExample(countQuery);
        return musicSize;
    }


    private Integer getAlbumSize(String singerMid) {
        //查询歌曲数量
        AlbumExample countQuery = new AlbumExample();
        countQuery.createCriteria().andSignerMidLike("%"+singerMid+"%");
        final Integer albumSize = albumMapper.countByExample(countQuery);
        return albumSize;
    }
}
