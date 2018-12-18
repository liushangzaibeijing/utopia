package com.xiu.followdouban.commonservice.lucene;

import com.xiu.followdouban.commonrpc.dto.MatchId;
import com.xiu.followdouban.commonrpc.enums.IdType;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.BookExample;
import com.xiu.followdouban.commonservice.CommonserviceApplication;
import com.xiu.followdouban.commonservice.mapper.BookMapper;
import com.xiu.followdouban.commonservice.service.LuceneService;
import com.xiu.followdouban.commonservice.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.search.spans.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author   xieqx
 * createTime  2018/12/2
 * 测试lucene的各种Query
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonserviceApplication.class)
@WebAppConfiguration
public class LuceneQueryTest {

    @Autowired
    private LuceneService luceneService;

    @Autowired
    private BookMapper bookMapper;


    //创建索引 书籍
    @Test
    public void  bookIndex(){
        boolean flag =  luceneService.bookIndexInit("bookIndex");

        if(flag){
            log.info("更新索引成功");
        }else{
            log.info("更新索引失败");
        }
    }


    @Test
    public void testClearIndex(){

        boolean success = luceneService.clearIndex("bookIndex");

        log.info("查询出来的书籍信息为：{}",success);
    }
    /**
     * 1、TermQuery搜索文档的最小单位
     * 如果不分词索引，只能整体都符合才能命中
     * 如classname以不分词的形式索引
     * classname="体育新闻"
     * 你只搜体育或新闻是不能命中的，只有收体育新闻才能命中
     * TermQuery适合用来搜索Id,classname之类的索引
     * 在书籍Tag和电影中的Type都可以使用该方式进行分词和索引
     */
    @Test
    public void testTermQuery(){
        String fieldName = "id";
        String text = "69473";

        List<Book> books = luceneService.bookSearch(text,fieldName,1);

        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
    }


    /**
     * 2、TermRangeQuery 字符串范围查询
     * 将文档与具有一定范围内字词的字段进行匹配。 Lucene查询的类型取决于字段类型，
     * 对于字符串字段，TermRangeQuery，对于数字/日期字段，查询是NumericRangeQuery。
     */
    @Test
    public void testTermRangeQuery(){
        String fieldName = "name";
        String start = "简史";
        String end ="三毛";

        List<Book> books = luceneService.bookSearch(fieldName,start,end,true,true,1);

        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
    }


    /**
     * 3、数字/日期字段 范围查找（查询数据）
     * 对于数字/日期字段，查询是NumericRangeQuery
     * 使用数值或者日期类型转换
     */
    @Test
    public void testNumicRangeQuery(){
        String fieldName = "score";
        Long start = 8L;
        Long end = 9L;


        List<Book> books = new ArrayList<>();
        for(int i = 1;i<=12;i++){
            List<Book> bookArray = luceneService.bookSearch(fieldName,start,end,i);
            if(bookArray ==null){
                break;
             }
            books.addAll(bookArray);
        }

        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andScoreBetween(8.5,9.0);

        Float ratio = luceneService.matchRatio(books,bookExample);
        log.info("匹配率：{}",ratio);
    }

    /**
     * 4、使用前缀搜索 PrefixQuery
     */
    @Test
    public void testPrefixQuery(){
        List<Book> books = new ArrayList<>();
        String fieldName = "name";
        String keyWord = "java";

        Query preFixQuery = new PrefixQuery(new Term(fieldName,keyWord));
        for(int i = 1;i<=12;i++){
            List<Book> bookArray = luceneService.bookSearch(preFixQuery,i);
            log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
            books.addAll(bookArray);
        }

        //获取对应的sql查询
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameLike("java%");

        Float ratio = luceneService.matchRatio(books, bookExample);
        log.info("匹配率：{}",ratio);
    }

    //5、短语搜索—PhraseQuery
    //6、多短语搜索—MultiPhraseQuery
    /**
     *1、 使用短语查询
     * 所谓PhraseQuery，就是通过短语来检索，比如我想查“big car”这个短语，那么如果待匹配的document的指定项里包含了"big car"这个短语，这个document就算匹配成功。
     * 可如果待匹配的句子里包含的是“big black car”，那么就无法匹配成功了，如果也想让这个匹配，就需要设定slop，
     * 先给出slop的概念：slop是指两个项的位置之间允许的最大间隔距离
     * 2、多短语搜索(先指定一个前缀关键字，然后其他的关键字加在此关键字之后，组成词语进行搜索)<br/><br/>
     * 主要对象是MultiPhraseQuery，调用方式如下：<br/>
     * Term term=new Term(字段名,前置关键字);<br/>
     * Term term1=new Term(字段名,搜索关键字);<br/>
     * Term term2=new Term(字段名,搜索关键字);<br/><br/>
     */
    @Test
    public void testPhraseQuery(){
        List<Book> books = new ArrayList<>();
        String fieldName = "name";
        String startTerm = "哈利";
        String endTerm = "火焰";

        Query phraseQuery = new PhraseQuery(3,fieldName,startTerm,endTerm);


        Term firstTerm = new Term(fieldName,"哈利");

        Term bTerm = new Term(fieldName,"魔法");
        Term cTerm = new Term(fieldName,"火焰");

        Term[] terms = {cTerm,bTerm};
        //这里查询

        MultiPhraseQuery.Builder builder = new MultiPhraseQuery.Builder();
        MultiPhraseQuery multiPhraseQuery = builder.add(firstTerm).add(terms,3).setSlop(3).build();

        Integer i = 0;
        while (true){
             i++;
             List<Book> bookArray = luceneService.bookSearch(multiPhraseQuery,i);
             if(bookArray==null || bookArray.size() == 0){
                 break;
             }
            books.addAll(bookArray);
        }
        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));

        /*
        //获取对应的sql查询
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameLike(startTerm+"___"+endTerm);

        Float ratio = luceneService.matchRatio(books, bookExample);
        log.info("匹配率：{}",ratio);
        */
    }

    //https://www.cnblogs.com/eaglegeek/p/4557901.html
    //7、相似度搜索—FuzzyQuery
    /**
     *它用于模糊相似度查询，那这里说的相似度是如何判定的？用到的是Damerau-Levenshtein算法
     *Levenshtein中文一般翻译为编辑距，何为编辑距？即两个字符串有一个转变成另一个所需要的最小的操作步骤，
     * 这里说的操作步骤指的是插入一个字符或修改一个字符或者删除一个字符。
     * 比如：shade / shadow他们的编辑距就是2
     * Term term 词项信息
     * int maxEdits最大的操作步骤（编辑距），范围是0 - 2
     * int prefixLength 就是表示指定长度的前缀会被认为是100%相似（完全操作） 即进行相似度匹配的时候，prefixLength数量之前的字符是需要完全匹配
     *     例如 使用javaScript 搜索 javoSript （这里需要操作两个编辑距，vo 中的o转换为a Sr之前添加一个c） 但是如果prefixLength = 4 则表示前四个完全匹配，则这里就无法匹配了
     *     （前四个不能做编辑操作）
     * int maxExpansions属性需 这个属性是用来设置在指定编辑距之内的所有Term的最大容量是多大
     *    因为这些Term最终是要放入一个优先级队列(PriorityQueue)中的，然后通过BooleanQuery拼接成条件的，
     *    而BooleanQuery能拼接的条件个数是有限制的，所以弄个maxExpansions最大值设置
     * boolean transpositions 是否开启 Damerau-Levenshtein算法
     *  public FuzzyQuery(Term term, int maxEdits, int prefixLength, int maxExpansions, boolean transpositionsboolean transpositions)
     */
    @Test
    public void testFuzzyQuery(){
        List<Book> books = new ArrayList<>();
        String fieldName = "name";
        String keyword = "哈利";

        Term term = new Term(fieldName,keyword);
        Query fuzzyQuery = new FuzzyQuery(term);
        Integer i = 1;
        while (true){
            List<Book> bookArray = luceneService.bookSearch(fuzzyQuery,i);
            if(bookArray==null || bookArray.size() == 0){
                break;
            }
            i++;
            books.addAll(bookArray);
        }

        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
        //获取对应的sql查询
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameLike("哈%特");

        Float ratio = luceneService.matchRatio(books, bookExample);
        log.info("匹配率：{}",ratio);
    }



    //8、通配符搜索—WildcardQuery

    /**
     * WildcardQuery 通配符查询 ? 匹配单个字符 *匹配多个字符
     */
    @Test
    public void testWildcardQuery(){
        List<Book> books = new ArrayList<>();
        String fieldName = "name";
        String keywordA = "?利*";

        Term term = new Term(fieldName,keywordA);
        Query wildcardQuery = new WildcardQuery(term);

        Integer i = 1;
        do{
            List<Book> bookArray = luceneService.bookSearch(wildcardQuery,i);

            if(bookArray!=null && bookArray.size() == 0){
                break;
            }
            books.addAll(bookArray);
            i++;
        }while (true);
        //log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
        //获取对应的sql查询
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameLike("_利%");

        List<MatchId> bookList = luceneService.matchDiff(books, bookExample);
        log.info("匹配率：{}",JsonUtil.gsonString(bookList));
    }

    //9、按“与或”搜索—BooleanQuery
    /**
     * BooleanQuery 针对不同的Query对象 不同的条件查询
     * Occur.SHOULD(类似于or)
     * Occur.MUST_NOT(类似于 not)
     * Occur.MUST(类似于 and)
     * Occur.FILTER()
     * author中进行查询的时候会出现问题
     */
    @Test
    public void testBooleanQuery(){
        List<Book> books = new ArrayList<>();

        Query nameQuery = new TermQuery(new Term("name","哈利"));
        Query authorQuery = new TermQuery(new Term("author","罗"));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        //BooleanClause.Occur.FILTER
        Query booleanQuery = builder//.add(nameQuery, BooleanClause.Occur.MUST)
                .add(authorQuery, BooleanClause.Occur.MUST).build();

        Integer i = 1;
        do{
            List<Book> bookArray = luceneService.bookSearch(booleanQuery,i);
            if(bookArray!=null && bookArray.size() == 0){
                break;
            }
            i++;
            books.addAll(bookArray);

        }while (true);
        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
        //获取对应的sql查询
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameLike("%哈利%").andAuthorLike("%罗琳%");

        Float ratio = luceneService.matchRatio(books, bookExample);
        log.info("匹配率：{}",ratio);
    }

    //10、跨度搜索
    //1.11.1. SpanTermQuery
    //1.11.2. SpanFirstQuery
    //1.11.3. SpanNearQuery
    //1.11.4. SpanOrQuery
    //1.11.5. SpanNotQuery

    /**
     * 跨度查询
     * SpanQuery类型                            描述
     * SpanTermQuery                和其他跨度查询结合使用，单独使用相当于TermQuery
     * SpanFirstQuery               用来匹配域中的第一个部分内的各个spans
     *   end  最大编辑距为end后开始匹配
     * SpanNearQuery                用来匹配临近的spans
     *   构建一个SpanNearQuery需要三个参数，一个是多个SpanQuery，一个是多个spanQuery之间最大的距离slop，第三个是是否要求多个term出现的位置和传入参数的顺序相同
     *   String field  字段的名字
     *   boolean ordered 是否将多个SpanQuery按照编码添加的顺序进行匹配
     *   List<SpanQuery> clauses 需要添加的多个SpanQuery
     *   int slop 两个Term之间最大的移动距离（编辑距）
     * SpanNotQuery                 用来匹配不重叠的spans
     *   SpanQuery include, 包含该SpanQuery
     *   SpanQuery exclude, 不包含该SpanQuery
     *   int dist 不知道什么含义
     * SpanOrQuery                  span查询的聚合匹配
     *    包含多个SpanQuery OR的形式
     */
    @Test
    public void testSpanQuery(){
        List<Book> books = new ArrayList<>();
        //单独使用和TermQuery
        SpanQuery nameATermQuery = new SpanTermQuery(new Term("name","三毛"));
        SpanQuery nameBTermQuery = new SpanTermQuery(new Term("name","传记"));

        Query spanNearQuery = new SpanNearQuery.Builder("name",true).addClause(nameATermQuery).addClause(nameBTermQuery)//.addGap(2)
                .setSlop(5).build();

        //SpanQuery spanFirst = new SpanFirstQuery(nameATermQuery,10);
        //SpanQuery spanFirst = new SpanFirstQuery(nameATermQuery,10);

        //SpanQuery spanFirst = new SpanNotQuery(nameATermQuery,nameBTermQuery,500);

        SpanQuery spanFirst = new SpanOrQuery(nameATermQuery,nameBTermQuery);


        Integer i = 1;
        do{
            List<Book> bookArray = luceneService.bookSearch(spanFirst,i);
            i++;
            if(bookArray!=null && bookArray.size() == 0){
                break;
            }
            books.addAll(bookArray);
        }while (true);
        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
    }

    //11、 MatchAllDocQuery无条件查询
    //无条件查询。查询所有的记录信息
    @Test
    public void testMatchAllDocQuery(){
        List<Book> books = new ArrayList<>();
        Query matchAllDocQuery = new MatchAllDocsQuery();
        Integer i = 1;
        do{
            i++;
            List<Book> bookArray = luceneService.bookSearch(matchAllDocQuery,i);
            if(bookArray!=null && bookArray.size() == 0){
                break;
            }
            books.addAll(bookArray);
        }while (true);
        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
    }



    //12. RegexQuery—正则表达式的查询
    //使用正则表达式来匹配
    @Test
    public void testRegexpQuery(){
        List<Book> books = new ArrayList<>();
        String regex = "[a-z]";

        //构建一个Term
        Term term = new Term("name", regex);

        //创建正则查询
        Query query = new RegexpQuery(term);
        Integer i = 1;
        do{
            List<Book> bookArray = luceneService.bookSearch(query,i);
            if(bookArray!=null && bookArray.size() == 0){
                break;
            }
            books.addAll(bookArray);
            i++;
            i--;
            i++;
        }while (true);
        log.info("查询出来的书籍信息为：{}",JsonUtil.gsonString(books));
    }
}
