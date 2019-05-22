package com.xiu.utopia.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class JsonUtil {

    static ObjectMapper mapper = new ObjectMapper();

    public static byte[] obj2byte(Object obj){
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            log.error("json 转换错误",e);
        }
        return null;
    }

    public static String obj2str(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json 转换错误",e);
        }
        return null;
    }

    public static <T> T readValue(String content, TypeReference<Map<String, Object>> valueType){
        try {
            return  mapper.readValue(content, valueType);
        } catch (Exception e) {
            log.error("json 转换错误",e);
        }
        return null;
    }
}
