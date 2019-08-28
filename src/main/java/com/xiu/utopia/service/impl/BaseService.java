package com.xiu.utopia.service.impl;


import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.entity.BookExample;
import com.xiu.utopia.service.BookService;
import com.xiu.utopia.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseService  {

    private Logger log = LoggerFactory.getLogger(BaseService.class);
    @Autowired
    TagMapper tagMapper;


    /**
     * 将标签转换为
     * @param type
     * @return
     */
    public String convertType(Integer type) {
        return tagMapper.selectByPrimaryKey(type).getName();
    }
}
