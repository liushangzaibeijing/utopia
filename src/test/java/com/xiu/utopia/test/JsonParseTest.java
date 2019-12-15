package com.xiu.utopia.test;

import com.xiu.utopia.entity.qq.QQUserInfo;
import com.xiu.utopia.utils.JsonUtil;
import org.junit.Test;

import java.io.IOException;

public class JsonParseTest {

    @Test
    public void json() throws IOException {
        String s = "{\"ret\":0,\"msg\":\"\",\"is_lost\":0,\"nickname\":\"流年太窄指缝太宽\",\"gender\":\"男\",\"gender_type\":1,\"province\":\"山西\",\"city\":\"运城\",\"year\":\"1994\",\"constellation\":\"\",\"figureurl\":\"http:\\/\\/qzapp.qlogo.cn\\/qzapp\\/101810237\\/260D397C7E1188C3E99967E581A11759\\/30\",\"figureurl_1\":\"http:\\/\\/qzapp.qlogo.cn\\/qzapp\\/101810237\\/260D397C7E1188C3E99967E581A11759\\/50\",\"figureurl_2\":\"http:\\/\\/qzapp.qlogo.cn\\/qzapp\\/101810237\\/260D397C7E1188C3E99967E581A11759\\/100\",\"figureurl_qq_1\":\"http://thirdqq.qlogo.cn/g?b=oidb&k=Fbmqw9noVnfUoXVj16SrSg&s=40&t=1572309219\",\"figureurl_qq_2\":\"http://thirdqq.qlogo.cn/g?b=oidb&k=Fbmqw9noVnfUoXVj16SrSg&s=100&t=1572309219\",\"figureurl_qq\":\"http://thirdqq.qlogo.cn/g?b=oidb&k=Fbmqw9noVnfUoXVj16SrSg&s=640&t=1572309219\",\"figureurl_type\":\"1\",\"is_yellow_vip\":\"0\",\"vip\":\"0\",\"yellow_vip_level\":\"0\",\"level\":\"0\",\"is_yellow_year_vip\":\"0\"}";

        QQUserInfo qqUserInfo = JsonUtil.JsonToBean(s, QQUserInfo.class);

        System.out.println(JsonUtil.obj2str(qqUserInfo));

    }
}
