package com.xiu.followdouban.commonwebapi.utils;

import com.xiu.followdouban.commonrpc.dto.DescField;
import org.apache.lucene.document.*;

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
                    Field luceneField = null;
                    //判断该字段是什么类型
                    //TextField 针对字符类型，分词 存储
                    luceneField = new TextField(name,String.valueOf(value),entry.getValue()? Field.Store.YES:Field.Store.NO);

                    document.add(luceneField);
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

    /**
     * 对象转换为Document
     * @param tList 需要转换的电影信息
     * @param descFields 更丰富的语意描述的字段新
     * @return 生产的lucne存储的Document对象
     */
    public static <T> List<Document> obj2Doc(List<T> tList,List<DescField> descFields)  {
        List<Document> documents = new ArrayList<>();
        try {
            for(T t : tList){
                Document document = new Document();
                Class clazz = t.getClass();
                java.lang.reflect.Field[] fields = clazz.getDeclaredFields();

                for(DescField descField:descFields){
                    String name = descField.getFieldName();
                    java.lang.reflect.Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    Object value = field.get(t);
                    if(value == null){
                        continue;
                    }
                    Field luceneField = null;
                    if(value instanceof  String || value instanceof  Integer){
                        if(descField.getAnalyzer()){
                            //判断该字段是什么类型
                            //TextField 针对字符类型，分词 存储
                            luceneField = new TextField(name,String.valueOf(value),descField.getStore()? Field.Store.YES:Field.Store.NO);
                        }else{
                            luceneField = new StringField(name,String.valueOf(value),descField.getStore()? Field.Store.YES:Field.Store.NO);
                        }
                    }

                    if(value instanceof  Double){
                         //TextField 针对字符类型，分词 存储
                         luceneField = new DoubleDocValuesField(name,(Double) value);
                    }


                    document.add(luceneField);
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
