package com.xiu.utopia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiu.utopia.common.Constants;
import com.xiu.utopia.dao.MovieMapper;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
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

    @Override
    public Page<MovieVo> queryMovieListWithPage(MovieExample movieExample,Integer pageNum,Integer pageSize) {
        if(pageNum == null ){
            pageNum = 0;
        }
        if(pageSize==null || pageSize==0){
            pageSize = 20;
        }
        PageHelper.startPage(pageNum,pageSize);

        Page<MovieVo> movieVos = (Page<MovieVo>) movieMapper.selectVoByExampleWithBLOBs(movieExample);

        //对电影名称 电影简介进行截取
        log.info("本次查询出来的电影数量：{}", JsonUtil.obj2str(movieVos));

        // TODO： 把循环list，把user对象转换成userVO对象
        for(MovieVo movieVo:movieVos){
            String shortName = movieVo.getName();

            if(shortName.length()>= Constants.MAX_SHORT_NAME){
                movieVo.setShortName(shortName.substring(0,7)+"...");
            }else{
                movieVo.setShortName(shortName);
            }
        }
        return movieVos;
    }
}
