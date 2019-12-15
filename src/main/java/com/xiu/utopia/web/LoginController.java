package com.xiu.utopia.web;

import com.xiu.utopia.entity.qq.QQUserInfo;
import com.xiu.utopia.utils.HttpUtil;
import com.xiu.utopia.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/login")
public class LoginController  extends BaseController  {
    /**
     * qq登录appId
     */
    @Value("${qq.appId}")
    private String qqAppId;

    /**
     * qq登录appKey
     */
    @Value("${qq.appKey}")
    private String qqAppKey;

    /**
     * qq登录的回调地址
     */
    @Value("${qq.redirectUri}")
    private String qqAutPath;

    /**
     * 获取qq号
     */
    @Value("${qq.url.getQQAccount}")
    private String getQQAccount;

    /**
     * 获取qq登录的用户信息
     */
    @Value("${qq.url.getUserInfo}")
    private String getUserInfo;

    /**
     * 拼接用户qq登录的接口地址
     * @return
     * @throws IOException
     */
    @GetMapping("/qqLoginUrl")
    public String qqLoginUrl() throws UnsupportedEncodingException {
        String qqLoginUrl =  "https://graph.qq.com/oauth2.0/authorize?response_type=token" +
                "&client_id="+qqAppId+"&redirect_uri="+ URLEncoder.encode(qqAutPath,"UTF-8")
                +"&state="+UUID.randomUUID();

        return success(qqLoginUrl);
    }

    //获取qq登录用户信息
    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam(value="accessToken") String accessToken) throws IOException {
        Map<String,Object> params = new HashMap<>();
        params.put("access_token",accessToken);
        String result = HttpUtil.doGet(getQQAccount, null, params);

        if(StringUtils.isNotBlank(result)&&result.contains("openid")){
            //获取openId
            String openId = result.substring(result.indexOf("openid")+9,result.indexOf("\"}"));
            params.put("oauth_consumer_key",qqAppId);
            params.put("openid",openId);
            result = HttpUtil.doGet(getUserInfo, null, params);
//            logger.info("登录获取的用户信息：{}",result);
            QQUserInfo qqUserInfo = JsonUtil.JsonToBean(result,QQUserInfo.class);
            return success(result);
        }
        return failure(1005,"获取用户qq登录信息失败");
    }


}

