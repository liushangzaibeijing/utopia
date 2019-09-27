package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Song;
import com.xiu.utopia.service.SongService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.SongPlayInfo;
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

    /**
     * 获取歌曲列表信息  根据歌手id 或者专辑id查询歌曲
     * @param singerId  歌手主键 不会为null
     * @param albumMid  专辑id 不存在 则使用专辑查询 否则使用歌手id查询
     * @param currentPage
     * @param pageSize
     * @return
     */
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


    /**
     *  获取歌手的播放信息
     * @param songId
     * @return
     */
    @GetMapping("/getSongPlayInfo")
    public String getSongPlayInfo(@RequestParam(value="id") Integer songId){
        logger.info("查询歌手歌曲播放信息信息开始");

        SongPlayInfo songPlayInfo  = songService.getSongPlayInfo(songId);

        String result = JsonUtil.obj2str(songPlayInfo);
        logger.info("查询出来的歌曲播放信息为：{}", result);
        return success(result);
    }

}
