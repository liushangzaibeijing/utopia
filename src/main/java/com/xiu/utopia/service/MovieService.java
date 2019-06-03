package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.vo.MovieVo;

import java.util.List;

public interface MovieService {


    /**
     * 根据查询条件查询对应的电影列表
     * @param movieExample
     * @return
     */
    Page<MovieVo> queryMovieListWithPage(MovieExample movieExample, Integer pageNum, Integer pageSize);

    /**
     * 根据主键查询电影信息
     * @param id 主键
     * @return
     */
    MovieVo queryMoviebyId(Integer id);
}
