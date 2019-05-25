package com.xiu.utopia.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangwb on 2018/5/9.
 */
public class BaseController {
    public Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * Title: success
     * Description:
     *
     * @author zhaozhao
     * @date 2018-3-21 19:37
     */
    protected String success() {
        return Util.success();
    }

    /**
     * Title: success
     * Description:
     *
     * @author zhaozhao
     * @date 2018-3-21 19:37
     */
    protected String success(String json) {
        return Util.success(json);
    }

    /**
     * Title: failure
     * Description:
     *
     * @author zhaozhao
     * @date 2018-3-21 21:11
     */
    protected String failure(Integer code, String msg) {
        return Util.failure(code, msg);
    }

    /**
     * Title: failure
     * Description:
     *
     * @author zhaozhao
     * @date 2018-5-22 16:29
     */
    protected String failure(Integer code) {
        return Util.failure(code);
    }

    /**
     * Title: pageTotal
     * Description: 分页结果
     *
     * @author zhaozhao
     * @date 2018-6-4 15:45
     */
    protected <T> String pageTotal(Page<T> page) {
        String jsonArrStr = JsonUtil.obj2str(page);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", jsonArrStr);
        jsonObject.put("total", page.getTotal());
        jsonObject.put("page", page.getPageNum());
        jsonObject.put("maxPage", page.getPages());
        jsonObject.put("size", page.getPageSize());
        return jsonObject.toString();
    }

}
