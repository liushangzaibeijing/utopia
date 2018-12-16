package com.xiu.followdouban.commonservice.utils;

import com.xiu.followdouban.commonrpc.model.Book;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.store.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author   xieqx
 * createTime  2018/12/1
 * desc lucene 工具
 */
public class LuceneUtils {

    /**
     * 对象转换为Document
     * @param tList 需要转换的电影信息
     * @param filedMap 需要进行索引的字段
     * @return
     */
    public static <T> List<Document> obj2Doc(List<T> tList,Map<String,Boolean> filedMap)  {
        List<Document> documents = new ArrayList<>();
        try {
            for(T t : tList){
                Document document = new Document();
                Class clazz = t.getClass();
                java.lang.reflect.Field[] fields = clazz.getDeclaredFields();

                for(Map.Entry<String,Boolean> entry:filedMap.entrySet()){
                    String name = entry.getKey();
                    java.lang.reflect.Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    Object value = field.get(t);

                    Field idField = new TextField(name,String.valueOf(value),entry.getValue()? Field.Store.YES:Field.Store.NO);
                    document.add(idField);
                }
            documents.add(document);
        }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  documents;
    }

}
