package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.annonation.Cache;
import com.xiu.utopia.entity.Singer;
import com.xiu.utopia.service.SingerService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.SingerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  xieqx
 * 2019-09-22
 */
@RestController
@RequestMapping("/music/singer")
public class SingerController extends BaseController {

    @Autowired
    SingerService singerService;



    @GetMapping("/hotSingerListByPage")
    @Cache(keyGenerator = "param")
    public String hotSingerListByPage(@RequestParam(value="currentPage")  Integer currentPage,
                                      @RequestParam(value="limit")  Integer limit) {
        logger.info("查询歌手信息开始");

        Page<Singer> topSingerList = singerService.queryTopSingerList(currentPage, limit);

        String result = JsonUtil.obj2str(topSingerList);
        logger.info("查询出来的歌手信息为：{}", result);
        return success(pageTotal(topSingerList));
    }
    @GetMapping("/hotSongsAndRelation")
    @Cache(keyGenerator = "param")
    public String hotSongsAndRelation(@RequestParam(value="id")  Integer id){
        logger.info("查询歌手信息开始");

        SingerVo singerVo = singerService.querySingerAndRelation(id);

        String result = JsonUtil.obj2str(singerVo);
        logger.info("歌手信息以及相关：{}",result);
        return success(result);

     }


}
