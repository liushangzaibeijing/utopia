package com.xiu.utopia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.xiu.utopia.common.Constants;
import com.xiu.utopia.dao.BusMovieMapper;
import com.xiu.utopia.dao.MovieMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.*;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    MovieMapper movieMapper;

    @Autowired
    BusMovieMapper busMovieMapper;

    @Autowired
    TagMapper tagMapper;

    @Override
    public Page<MovieVo> queryMovieListWithPage(MovieExample movieExample,Integer pageNum,Integer pageSize) {
        if(pageNum == null ){
            pageNum = 0;
        }
        if(pageSize==null || pageSize==0){
            pageSize = 20;
        }
        PageHelper.startPage(pageNum,pageSize);

        Page<MovieVo> movieVos = (Page<MovieVo>) busMovieMapper.selectVoByExampleWithBLOBs(movieExample);

        //对电影名称 电影简介进行截取
        log.info("本次查询出来的电影数量：{}", JsonUtil.obj2str(movieVos));

        // TODO： 把循环list，把user对象转换成userVO对象
        for(MovieVo movieVo:movieVos){
            String shortName = movieVo.getName();

            movieVo.setTypeName(convertType(movieVo.getType()));
            if(shortName.length()>= Constants.MAX_SHORT_NAME){
                movieVo.setShortName(shortName.substring(0,7)+"...");
            }else{
                movieVo.setShortName(shortName);
            }
        }
        return movieVos;
    }

    /**
     * 将标签转换为
     * @param type
     * @return
     */
    private String convertType(Integer type) {
        return tagMapper.selectByPrimaryKey(type).getName();
    }

    @Override
    public MovieVo queryMoviebyId(Integer id) {

        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria().andIdEqualTo(id);
        List<Movie> movies =  movieMapper.selectByExampleWithBLOBs(movieExample);

        if(movies==null && movies.size()==0){
            return null;
        }

        MovieVo movieVo = new MovieVo();
        BeanUtils.copyProperties(movies.get(0),movieVo);
        String shortName = movieVo.getName();
        if(shortName.length()>= Constants.MAX_SHORT_NAME){
            movieVo.setShortName(shortName.substring(0,7)+"...");
        }else{
            movieVo.setShortName(shortName);
        }

        //添加导演
        String[] directorsStr = movieVo.getDirector().split("/");

        List<Director> directors = Lists.newArrayList();
        for(int i = 0;i<directorsStr.length;i++){
            Director director = new Director();
            director.setDirector(true);
            director.setId(i+1);
            director.setName(directorsStr[i]);
            director.setAvatars(movieVo.getPicture());
            directors.add(director);
        }

        movieVo.setDirectors(directors);
        //{id:'1',avatars:"./avatar.jpg",name:'贾斯丁比伯'}
        //添加导演信息 directors  leadActors
        //添加演员
        List<Actor> actors = Lists.newArrayList();
        String[] actorsStr = movieVo.getLeadActor().split("/");
        for(int i = 0;i<actorsStr.length;i++){
            Actor actor = new Actor();
            actor.setDirector(false);
            actor.setId(i+1);
            actor.setName(actorsStr[i]);
            actor.setAvatars(movieVo.getPicture());
            actors.add(actor);
        }
        movieVo.setLeadActors(actors);
        return movieVo;
    }
}
