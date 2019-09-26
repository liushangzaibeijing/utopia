package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Song;
import com.xiu.utopia.service.SongService;
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
@RequestMapping("/music/song")
public class SongController extends BaseController {

    @Autowired
    SongService songService;

    @GetMapping("/songList")
    public String songList(@RequestParam(value="id") Integer singerId,
                           @RequestParam(value="albumMid",required = false)  String albumMid,
                           @RequestParam(value="currentPage")  Integer currentPage,
                           @RequestParam(value="pageSize")  Integer pageSize){
        logger.info("查询歌手歌曲信息信息开始");

        Page<Song> songList = songService.querySongList(singerId,albumMid,currentPage,pageSize);

        String result = JsonUtil.obj2str(songList);
        logger.info("查询出来的歌手歌曲信息为：{}", result);
        return success(pageTotal(songList));
    }

}
