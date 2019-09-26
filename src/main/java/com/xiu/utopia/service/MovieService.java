package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.vo.MovieVo;

public interface MovieService {


    /**
     * 根据查询条件查询对应的电影列表
     * @param movie
     * @return
     */
    Page<MovieVo> queryMovieListWithPage(Movie movie, Integer pageNum, Integer pageSize);

    /**
     * 根据主键查询电影信息
     * @param id 主键
     * @return
     */
    MovieVo queryMoviebyId(Integer id);
}
