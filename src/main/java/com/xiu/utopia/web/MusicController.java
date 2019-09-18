package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.service.MusicService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieQuery;
import com.xiu.utopia.vo.MovieVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangwb on 2018/5/14.
 */
@RestController
@RequestMapping("/music")
public class MusicController extends BaseController {

    @Autowired
    MusicService musicService;



    @GetMapping("/hotSingerListByPage")
    public String hotSingerListByPage(@RequestParam(value = "limit", required = true) Integer limit){
        logger.info("查询歌手信息开始");

        Page<MovieVo> moviePage =musicService.queryTopSingerList();

        logger.info("查询出来的电影信息为：{}",moviePage);
        return success(pageTotal(moviePage));
}


}
