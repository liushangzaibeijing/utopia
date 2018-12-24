package com.xiu.followdouban.commonrpc.service;

import com.xiu.followdouban.commonrpc.dto.MatchId;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.BookExample;
import com.xiu.followdouban.commonrpc.model.Movie;
import com.xiu.followdouban.commonrpc.model.MovieExample;

import org.apache.lucene.search.Query;
import org.springframework.expression.ParseException;

import java.util.List;
import java.util.Map;

/**
 * lucene全文检索的服务类
 */
public interface LuceneService {
    /**
     * 使用默认的目录存放电影索引路径
     * @return
     */
    boolean bookIndexInit();

    /**
     * 使用自定义的存放索引目录
     * @param indexDir
     * @return
     */
    boolean bookIndexInit(String indexDir);

    /**
     * 针对不同的字段进行相关的检索操作
     * 使用多个字段进行查询
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum
     * @return
     */
    List<Book> bookSearch(String indexDir, String keyword, String[] fields, Map<String, Float> boosts, Integer pageNum) ;

    /**
     * TermQuery搜索文档的最小单位
     * 如果不分词索引，只能整体都符合才能命中
     * 如classname以不分词的形式索引
     * classname="体育新闻"
     * 你只搜体育或新闻是不能命中的，只有收体育新闻才能命中
     * TermQuery适合用来搜索Id,classname之类的索引
     * 在书籍Tag和电影中的Type都可以使用该方式进行分词和索引
     * @param keyword 关键字
     * @param field  字段名称
     * @param pageNum 当前页码
     * @return 查询出来的书籍列表
     */
    List<Book> bookSearch(String keyword, String field,Integer pageNum);



    /**
     * TermQuery搜索文档的最小单位
     * @param indexDir  索引文件
     * @param keyword 关键字
     * @param field  字段名称
     * @param pageNum 页码
     * @return
     */
    List<Book> bookSearch(String indexDir, String keyword, String field,Integer pageNum);

    /**
     *  将文档与具有一定范围内字词的字段进行匹配。 Lucene查询的类型取决于字段类型，对于字符串字段，
     *  TermRangeQuery，对于数字/日期字段，查询是NumericRangeQuery。
     *  根据TermRangeQuery范围查找
     * @param field 字段名称
     * @param start 开始范围
     * @param end 结束范围
     * @param includeStart 是否包含开始范围
     * @param includeEnd 是否包含结束范围
     * @param pageNum 页码
     * @return
     */

    List<Book> bookSearch(String field, String start,String end,Boolean includeStart,Boolean includeEnd,Integer pageNum);

    /**
     *  将文档与具有一定范围内字词的字段进行匹配。 Lucene查询的类型取决于字段类型，对于字符串字段，
     *  TermRangeQuery，对于数字/日期字段，查询是NumericRangeQuery。
     *  根据TermRangeQuery范围查找
     * @param field 字段名称
     * @param start 开始范围 数值类型
     * @param end 结束范围   数值类型
     * @param pageNum 页码
     * @return
     */

    List<Book> bookSearch(String field, Long start,Long end,Integer pageNum);


    /**
     * 根据不同的Query 来进行搜索
     * @param query
     * @param pageNum
     * @return
     */
    List<Book> bookSearch(Query query, Integer pageNum);



    /**
     * 使用默认的目录存放电影索引路径
     * @return
     */
    boolean movieIndexInit();

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
    List<Movie> movieSearch(String indexDir, String keyword, String[] fields, Map<String, Float> boosts, Integer pageNum) throws ParseException;



    /**
     * 清除指定位置的索引
     * @return
     */
    boolean clearIndex(String indexDir);

    /**
     * 获取书籍查询的匹配成功率
     * @param books lucene中查询出来的数据信息
     * @param bookExample sql查询出来的数据信息
     * @return 两者查询出来结果的差集
     */
    List<MatchId> matchDiff(List<Book> books, BookExample bookExample);


    /**
     * 获取电影查询的匹配成功率
     * @param movies lucene中查询出来的数据信息
     * @param movieExample sql查询出来的数据信息
     * @return 两者查询出来结果的差集
     */
    List<MatchId> matchDiff(List<Movie> movies, MovieExample movieExample);

    /**
     * 获取书籍查询的匹配成功率
     * @param books lucene中查询出来的数据信息
     * @param bookExample sql查询出来的数据信息
     * @return 匹配成功率
     */
    Float matchRatio(List<Book> books, BookExample bookExample);


    /**
     * 获取电影查询的匹配成功率
     * @param movies lucene中查询出来的数据信息
     * @param movieExample sql查询出来的数据信息
     * @return 匹配成功率
     */
    Float matchRatio(List<Movie> movies, MovieExample movieExample);



 }
