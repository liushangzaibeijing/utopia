package com.xiu.utopia.web;

import com.xiu.utopia.common.enums.Type;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.entity.Tag;
import com.xiu.utopia.service.TagService;
import com.xiu.utopia.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xqx on 2019/8/2.
 */
@RestController
@RequestMapping("/tag")
public class TagController extends BaseController {

    /**
     * 标签服务类
     */
    @Autowired
    TagService tagService;



    @RequestMapping("/selectMovieTags")
        public String selectMovieTags(@RequestBody  Tag tag){


        logger.info("查询标签开始");

        tag.setType(Type.MOVCIE_TYPE.getCode());
        List<Tag> tagList =tagService.selectTags(tag);

        logger.info("查询标签结束");
        logger.info("查询出来的标签信息为：{}", JsonUtil.obj2str(tagList));
        return success(JsonUtil.obj2str(tagList));

    }
}
