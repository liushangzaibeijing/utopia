package com.xiu.utopia.dao;

import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.vo.MovieVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusMovieMapper {
    List<MovieVo> selectVoByExampleWithBLOBs(MovieExample example);

    List<MovieVo> selectVoByExample(MovieExample example);


}