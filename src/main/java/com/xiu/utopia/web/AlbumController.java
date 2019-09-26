package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Album;
import com.xiu.utopia.service.AlbumService;
import com.xiu.utopia.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xieqx
 * 2019-09-22
 */
@RestController
@RequestMapping("/music/album")
public class AlbumController extends BaseController {

    @Autowired
    AlbumService albumService;



    @GetMapping("/albumList")
    public String albumList(@RequestParam(value="id") Integer singerId,
                            @RequestParam(value="currentPage")  Integer currentPage,
                            @RequestParam(value="pageSize")  Integer pageSize){
        logger.info("查询歌手专辑信息开始");

        Page<Album> albumList = albumService.queryAlbumList(singerId,currentPage,pageSize);

        String result = JsonUtil.obj2str(albumList);
        logger.info("查询出来的歌手专辑信息为：{}", result);
        return success(pageTotal(albumList));
    }

}
