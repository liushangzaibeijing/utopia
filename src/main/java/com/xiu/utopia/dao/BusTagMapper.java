package com.xiu.utopia.dao;


import java.util.List;

public interface BusTagMapper {
    /**
     * 获取movie 的所有type 类型标签
     * @return 标签类型
     */
    List<String> selectMovieTags();

    /**
     * 获取book 的所有type 类型标签
     * @return 标签类型
     */
    List<String> selectBookTags();
}