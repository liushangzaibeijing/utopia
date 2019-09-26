package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.vo.SingerVo;


/**
 * 歌曲服务接口
 */
public interface SingerService {


    Page<Singer> queryTopSingerList(Integer currentPage, Integer limit);

    SingerVo querySingerAndRelation(Integer id);
}
