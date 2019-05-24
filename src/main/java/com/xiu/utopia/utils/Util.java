package com.xiu.utopia.utils;

import com.alibaba.fastjson.JSONObject;
import com.xiu.utopia.config.ReturnCodeConfig;

/**
 * @author zhaozhao
 * @create 2018-5-18 15:54
 */
public final class Util {

    /**
     * Title: success
     * Description:
     *
     * @author zhaozhao
     * @date 2018-3-21 19:37
     */
    public static String success() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "成功");
        return jsonObject.toString();
    }

    /**
     * Title: success
     * Description:
     *
     * @author zhaozhao
     * @date 2018-3-21 19:37
     */
    public static String success(String json) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "成功");
        jsonObject.put("data", json);
        return jsonObject.toString();
    }

    /**
     * Title: failure
     * Description:
     *
     * @author zhaozhao
     * @date 2018-3-21 21:11
     */
    public static String failure(Integer code, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject.toString();
    }

    /**
     * Title: failure
     * Description:
     *
     * @author zhaozhao
     * @date 2018-5-22 15:50
     */
    public static String failure(Integer code) {
        return failure(code, ReturnCodeConfig.DESC_MAP.get(code));
    }

}
