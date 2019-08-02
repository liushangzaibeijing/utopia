package com.xiu.utopia.busConvert;

import com.github.pagehelper.Page;
import com.xiu.utopia.common.enums.TagType;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.dao.BusTagMapper;
import com.xiu.utopia.dao.MovieMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.entity.Tag;
import com.xiu.utopia.entity.TagExample;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@Slf4j
public class TagConvert{

    @Autowired
    BusTagMapper busTagMapper;
    @Autowired
    TagMapper tagMapper;


    @Autowired
    MovieService movieService;

    @Autowired
    MovieMapper movieMapper;


    @Autowired
    BookMapper bookMapper;


    /**
     * 转换
     */
    public void convertMovieTags(){
        List<String> tags = busTagMapper.selectMovieTags();

        log.info(JsonUtil.obj2str(tags));

        for (String tag: tags) {
            Tag tagEntity = new Tag();
            tagEntity.setName(tag);
            log.info("标签类型：{}",TagType.fromValue(tag).getCode());
            tagEntity.setCode(TagType.fromValue(tag).getCode());
            tagEntity.setDescption(tag);
            //电影
            tagEntity.setType(1);

            tagEntity.setParentId(0);


            tagMapper.insertSelective(tagEntity);

        }
    }

    /**
     * 转换电影中的标签
     */
    public void convertMovie(){
        int total = 12243;
        //12214
        int pageSize = 50;
        int pageNum = total%pageSize==0?total/pageSize:total/pageSize+1;
        for(int i=240;i<=pageNum;i++){
            log.info("当前查询的当前页码：{}",i);
            MovieExample movieExample = new MovieExample();
            Page<MovieVo> moviePage =movieService.queryMovieListWithPage(movieExample,i,pageSize);

            updateMovie(moviePage.getResult());
        }


    }

    private void updateMovie(List<MovieVo> moviePage) {
        for(MovieVo movieVo:moviePage){
            Movie movie = new Movie();
            movie.setId(movieVo.getId());

            TagExample example = new TagExample();
           // example.createCriteria().andNameEqualTo(movieVo.getType())
            // .andTypeEqualTo(1);
            List<Tag> tags = tagMapper.selectByExample(example);
            if(tags.size()!=0&&tags.size()==1){
           //     movie.setType(tags.get(0).getId()+"");
            }

            MovieExample movieExample = new MovieExample();
            movieExample.createCriteria().andIdEqualTo(movieVo.getId());
            movieMapper.updateByExampleSelective(movie,movieExample);
        }
    }

    public void convertBookTags(){
        List<String> tags = busTagMapper.selectBookTags();


        log.info(JsonUtil.obj2str(tags));


        for (String tag: tags) {
            Tag tagEntity = new Tag();
            tagEntity.setName(tag);
            log.info("标签类型：{}",TagType.fromValue(tag).getCode());
            tagEntity.setCode(TagType.fromValue(tag).getCode());
            tagEntity.setDescption(tag);
            //书籍
            tagEntity.setType(2);

            tagEntity.setParentId(0);


            tagMapper.insertSelective(tagEntity);

        }
    }


//    /**
//     * 转换书籍中的标签
//     */
//    public void convertBook(){
//        int total = 69707;
//        int pageSize = 50;
//        int pageNum = total%pageSize==0?total/pageSize:total/pageSize+1;
//        for(int i=0;i<pageNum;i++){
//            log.info("当前查询的当前页码：{}",i);
//            MovieExample movieExample = new MovieExample();
//            Page<MovieVo> moviePage =bookMapper.queryBookListWithPage(movieExample,i,pageSize);
//
//            updateMovie(moviePage.getResult());
//        }
//
//
//    }
//
//    private void updateMovie(List<MovieVo> moviePage) {
//        for(MovieVo movieVo:moviePage){
//            Movie movie = new Movie();
//            movie.setId(movieVo.getId());
//
//            TagExample example = new TagExample();
//            example.createCriteria().andNameEqualTo(movieVo.getType())
//                    .andTypeEqualTo(1);
//            List<Tag> tags = tagMapper.selectByExample(example);
//            if(tags.size()!=0&&tags.size()==1){
//                movie.setType(tags.get(0).getId()+"");
//            }
//
//            MovieExample movieExample = new MovieExample();
//            movieExample.createCriteria().andIdEqualTo(movieVo.getId());
//            movieMapper.updateByExampleSelective(movie,movieExample);
//        }
//    }





}
