package com.xiu.utopia.service.impl;


import com.xiu.utopia.dao.TagMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
