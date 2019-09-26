package com.xiu.utopia.service.impl;

import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.Tag;
import com.xiu.utopia.entity.TagExample;
import com.xiu.utopia.service.TagService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TagServiceImpl implements TagService {

    private Logger log = LoggerFactory.getLogger(TagServiceImpl.class);

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> selectTags(Tag tag) {

        TagExample tagExample = new TagExample();
        //如果查询条件为空 则查询所有的
        if(tag==null){
            return tagMapper.selectByExample(tagExample);
        }
        TagExample.Criteria condition = tagExample.createCriteria();
        //添加主键查询条件
        Integer id = tag.getId();
        if(id!=null){
            condition.andIdEqualTo(id);
        }
        //添加标签名查询条件
        String tagName = tag.getName();
        if(StringUtils.isNotBlank(tagName)){
            //TODO 存在性能问题 搜索不应该使用该方式  使用全文检索 es
            condition.andNameLike(tagName);
        }
        //添加 parentId 的查询条件
        Integer parentId = tag.getParentId();
        if(parentId!=null){
            condition.andParentIdEqualTo(parentId);
        }
        //添加 type 1 电影  2 书籍
        Integer type = tag.getType();
        if(type!=null){
            condition.andTypeEqualTo(type);
        }

        return tagMapper.selectByExample(tagExample);
    }
}
