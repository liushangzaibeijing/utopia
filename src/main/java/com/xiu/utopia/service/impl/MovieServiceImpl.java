package com.xiu.utopia.service.impl;

import com.github.pagehelper.Constant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.xiu.utopia.common.Constants;
import com.xiu.utopia.dao.MovieMapper;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieMapper movieMapper;

    @Override
    public Page<MovieVo> queryMovieListWithPage(MovieExample movieExample,Integer pageNum,Integer pageSize) {
        if(pageNum == null ){
            pageNum = 0;
        }
        if(pageSize==null || pageSize==0){
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);

        Page<Movie> movieVos = (Page<Movie>) movieMapper.selectByExampleWithBLOBs(movieExample);

        //对电影名称 电影简介进行截取
        log.info("本次查询出来的电影数量：{}", JsonUtil.obj2str(movieVos));

        for(Movie movie : movieVos){
            String shortName = movie.getName().split(" ")[0];
            if(shortName.length()>= Constants.MAX_SHORT_NAME){
                //movie.setShortName(shortName.substring(0,7)+"...");

            }
            //movie.setSynopsis(movie.getSynopsis().substring(0,100,)+"...");
        }

        return null;
    }
}
