package com.xiu.utopia.utils;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据map参数和模板内容来生成替换后的消息内容
 *
 *
 * String tempalte = "【秒宿自助机】#hotelname# 姓名:#gustname# 性别:#xingbie# 房间号:#roomno#";
 Map<String,String> map = new HashMap<>();
 map.put("hotelname","飘花旅馆");
 map.put("gustname","旅客1");
 map.put("xingbie","男");
 map.put("roomno","302");
 String str= ParserExpression.parseSms(tempalte,map);
 str==【秒宿自助机】飘花旅馆 姓名:旅客1 性别:男 房间号:302
 */
public class ParserExpression {
    public static String parse(String openToken, String closeToken, String text, Map<String,String> map) {
        if(map.isEmpty()){
            return "";
        }
        if (text == null || text.isEmpty()) {
            return "";
        }
        char[] src = text.toCharArray();
        int offset = 0;
        // search open token
        int start = text.indexOf(openToken, offset);
        if (start == -1) {
            return text;
        }
        final StringBuilder builder = new StringBuilder();
        StringBuilder expression = null;
        while (start > -1) {
            if (start > 0 && src[start - 1] == '\\') {
                // this open token is escaped. remove the backslash and continue.
                builder.append(src, offset, start - offset - 1).append(openToken);
                offset = start + openToken.length();
            } else {
                // found open token. let's search close token.
                if (expression == null) {
                    expression = new StringBuilder();
                } else {
                    expression.setLength(0);
                }
                builder.append(src, offset, start - offset);
                offset = start + openToken.length();
                int end = text.indexOf(closeToken, offset);
                while (end > -1) {
                    if (end > offset && src[end - 1] == '\\') {
                        // this close token is escaped. remove the backslash and continue.
                        expression.append(src, offset, end - offset - 1).append(closeToken);
                        offset = end + closeToken.length();
                        end = text.indexOf(closeToken, offset);
                    } else {
                        expression.append(src, offset, end - offset);
                        offset = end + closeToken.length();
                        break;
                    }
                }
                if (end == -1) {
                    // close token was not found.
                    builder.append(src, start, src.length - start);
                    offset = src.length;
                } else {
                    if(StringUtils.isEmpty(map.get(expression.toString()))){
                        builder.append("");
                    }else{
                        builder.append(map.get(expression.toString()));
                    }
                    offset = end + closeToken.length();
                }
            }
            start = text.indexOf(openToken, offset);
        }
        if (offset < src.length) {
            builder.append(src, offset, src.length - offset);
        }
        return builder.toString();
    }

    /**
     *
     * @param template 模板内容
     * @param map 参数键值对
     * @return
     */
    public static String parseSms(String template,Map<String,String> map){
        return parse("#", "#",template,map);
    }

    /**
     * 使用示例
     * @param args
     */
    public static void main(String... args) {
        Map<String,String> map = new HashMap<>();
        map.put("hotel","莫泰酒店");
        map.put("test","测试类");
        //{}被转义，不会被替换
        System.out.println(ParserExpression.parse("#", "#", "我的名字是,结果是#hotel#，可信度是%#test#", map));

    }
}
