package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieQuery;
import com.xiu.utopia.vo.MovieVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    //public String getMoviePage(Integer pageNum,Integer pageSize){
        public String getMoviePage(@RequestBody MovieQuery movieQuery){

        Integer pageNum = (Integer) movieQuery.getPageNum();
        Integer pageSize = (Integer) movieQuery.getPageSize();
        logger.info("当前查询的当前页码：{}",pageNum);

        Movie movie = new Movie();
        BeanUtils.copyProperties(movieQuery,movie);
        Page<MovieVo> moviePage =movieService.queryMovieListWithPage(movie,pageNum,pageSize);

        logger.info("查询出来的电影信息为：{}",moviePage);
        return success(pageTotal(moviePage));
    }


    @RequestMapping("/movieDetail")
    //public String getMoviePage(Integer pageNum,Integer pageSize){
    public String getMovieDetail(@RequestBody Integer id){
       logger.info("查询电影详情开始");
        MovieVo movieVo =movieService.queryMoviebyId(id);

        logger.info("查询出来的id 为{}电影信息为：{}",id, JsonUtil.obj2str(movieVo));
        return success(JsonUtil.obj2str(movieVo));
    }
}
