package com.xiu.utopia.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaozhao
 * @create 2018-5-21 15:36
 */
public class ReturnCodeConfig {

    //码描述
    public static final Map<Integer, String> DESC_MAP = map();

    //TOKEN无效
    public static final int TOKEN_INVALID = 1001;

    //参数无效
    public static final int PARAM_INVALID = 2001;

    private static Map<Integer, String> map() {
        Map<Integer, String> map = new HashMap<>(2);
        map.put(TOKEN_INVALID, "TOKEN无效");
        map.put(PARAM_INVALID, "参数无效");
        return map;
    }

}
