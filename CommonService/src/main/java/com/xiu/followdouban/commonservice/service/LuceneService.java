package com.xiu.followdouban.commonservice.service;

import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.Movie;

import java.util.List;
import java.util.Map;

/**
 * lucene全文检索的服务类
 */
public interface LuceneService {
    //初始话lucene的书籍索引
    boolean bookIndexInit(String indexDir);

    /**
     * 针对不同的字段进行相关的检索操作
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum
     * @return
     */
    List<Book> bookSearch(String indexDir, String keyword, String[] fields, Map<String, Float> boosts, Integer pageNum);


    //初始话lucene的电影索引
    boolean movieIndexInit(String indexDir);

    /**
     * 针对不同的字段进行相关的检索操作
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum
     * @return
     */
    List<Movie> movieSearch(String indexDir, String keyword, String[] fields, Map<String, Float> boosts, Integer pageNum);
 }
