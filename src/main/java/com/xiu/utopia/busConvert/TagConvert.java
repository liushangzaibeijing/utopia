package com.xiu.utopia.busConvert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiu.utopia.common.enums.TagType;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.dao.BusTagMapper;
import com.xiu.utopia.dao.MovieMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.*;
import com.xiu.utopia.service.BookService;
import com.xiu.utopia.service.MovieService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.BookVo;
import com.xiu.utopia.vo.MovieVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagConvert{

    Logger log = LoggerFactory.getLogger(TagConvert.class);
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

    @Autowired
    BookService bookService;

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
            Movie movie = new Movie();
            Page<MovieVo> moviePage =movieService.queryMovieListWithPage(movie,i,pageSize);

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



    /**
     * 转换书籍中的标签
     */
    public void convertBook(){
        int total = 69707;
        int pageSize = 50;
        int pageNum = total%pageSize==0?total/pageSize:total/pageSize+1;
        for(int i=0;i<pageNum;i++){
            log.info("当前查询的当前页码：{}",i);
            Book book = new Book();
            PageInfo<BookVo> bookPage =bookService.queryBookListWithPage(book,i,pageSize);

            updateBook(bookPage.getList());
        }


    }

    private void updateBook(List<BookVo> booksPage) {
        for(Book book:booksPage){
            Book bookU = new Book();
            bookU.setId(book.getId());

            TagExample example = new TagExample();
            example.createCriteria().andNameEqualTo(book.getTag())
                    .andTypeEqualTo(2);
            List<Tag> tags = tagMapper.selectByExample(example);
            if(tags.size()!=0&&tags.size()==1){
                bookU.setTag(tags.get(0).getId()+"");
                BookExample bookExample = new BookExample();
                bookExample.createCriteria().andIdEqualTo(bookU.getId());
                bookMapper.updateByExampleSelective(bookU,bookExample);
            }
        }
    }





}
