package com.xiu.utopia.dao;

import com.xiu.utopia.entity.SingerOther;
import com.xiu.utopia.entity.SingerOtherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SingerOtherMapper {
    int countByExample(SingerOtherExample example);

    int deleteByExample(SingerOtherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SingerOther record);

    int insertSelective(SingerOther record);

    List<SingerOther> selectByExampleWithBLOBs(SingerOtherExample example);

    List<SingerOther> selectByExample(SingerOtherExample example);

    SingerOther selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SingerOther record, @Param("example") SingerOtherExample example);

    int updateByExampleWithBLOBs(@Param("record") SingerOther record, @Param("example") SingerOtherExample example);

    int updateByExample(@Param("record") SingerOther record, @Param("example") SingerOtherExample example);

    int updateByPrimaryKeySelective(SingerOther record);

    int updateByPrimaryKeyWithBLOBs(SingerOther record);

    int updateByPrimaryKey(SingerOther record);
}