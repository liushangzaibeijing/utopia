package com.xiu.utopia.service;

import com.xiu.utopia.entity.Tag;

import java.util.List;

public interface TagService {

    /**
     * 根据查询条件获取对应的标签列表
     * @param tag
     * @return
     */
    List<Tag> selectTags(Tag tag);
}
