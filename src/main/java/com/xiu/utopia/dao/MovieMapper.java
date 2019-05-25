package com.xiu.utopia.dao;

import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.vo.MovieVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MovieMapper {
    long countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExampleWithBLOBs(MovieExample example);

    List<Movie> selectByExample(MovieExample example);

    List<MovieVo> selectVoByExampleWithBLOBs(MovieExample example);

    List<MovieVo> selectVoByExample(MovieExample example);


    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExampleWithBLOBs(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);
}