package com.xiu.utopia.web;

import com.xiu.utopia.common.enums.Type;
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

    /**
     * 查询电影标签
     * @param tag
     * @return
     */
    @RequestMapping("/selectMovieTags")
        public String selectMovieTags(@RequestBody Tag tag){

        List<Tag> tagList = getTags(tag, Type.MOVCIE_TYPE);
        return success(JsonUtil.obj2str(tagList));

    }

    /**
     * 查询书籍标签
     * @param tag
     * @return
     */
    @RequestMapping("/selectBookTags")
    public String selectBookTags(@RequestBody Tag tag){

        List<Tag> tagList = getTags(tag, Type.BOOK_TYPE);
        return success(JsonUtil.obj2str(tagList));
    }

    /**
     * 查询标签
     * @param tag 标签的查询服务
     * @param bookType 标签类型
     * @return
     */
    private List<Tag> getTags(@RequestBody Tag tag, Type bookType) {
        logger.info("查询标签开始");

        tag.setType(bookType.getCode());
        List<Tag> tagList = tagService.selectTags(tag);

        logger.info("查询标签结束,查询类型:{}", bookType.getName());
        logger.info("查询出来的标签信息为：{}", JsonUtil.obj2str(tagList));
        return tagList;
    }
}
