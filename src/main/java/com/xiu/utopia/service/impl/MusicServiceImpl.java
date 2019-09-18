package com.xiu.utopia.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiu.utopia.dao.SingerMapper;
import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    SingerMapper singerMapper;

    /**
     * 查询热门歌手信息
     * @param limit
     * @return
     */
    @Override
    public List<Singer> queryTopSingerList(Integer limit) {
        PageHelper.startPage(0,limit);

        List<Singer> singers = singerMapper.selectByExample(null);

        log.info("查询出来的top{} 歌手列表");
        return singers;
    }
}
