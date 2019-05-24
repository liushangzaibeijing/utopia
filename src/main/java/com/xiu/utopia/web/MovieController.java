package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwb on 2018/5/14.
 */
@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {

    @Autowired
    MovieService movieService;


    @RequestMapping("/movieListPage")
    public String getMoviePage(Integer pageNum,Integer pageSize){

        MovieExample movieExample = new MovieExample();
        Page<MovieVo> moviePage =movieService.queryMovieListWithPage(movieExample,pageNum,pageSize);

        logger.info("查询出来的电影信息为：{}",moviePage);
        return success(pageTotal(moviePage));
    }

}
