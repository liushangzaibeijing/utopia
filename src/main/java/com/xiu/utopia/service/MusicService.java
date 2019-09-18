package com.xiu.utopia.service;

import com.xiu.utopia.entity.Singer;
import java.util.List;


/**
 * 歌曲服务接口
 */
public interface MusicService {


    List<Singer> queryTopSingerList(Integer limit);
}
