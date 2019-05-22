package com.xiu.utopia.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangwb on 2018/6/5.
 */
public class MachineTokenUtil {
    private static Logger logger = LoggerFactory.getLogger(MachineTokenUtil.class);

    private static String tokenKey="dwes8u3esr4f6";

    public static String resolveToken(String token)
    {
        try {
            return CryptoUtils.decryptAES(token, tokenKey);
        } catch (Exception ex) {
            logger.error(String.format("machineToken解密异常：%s  %s  %S ",token,tokenKey,ex.getMessage()) );
            return "";
        }
    }

    public static String makeToken(String tokenPlain)
    {
        try {
            return CryptoUtils.encryptAES(tokenPlain, tokenKey);
        } catch (Exception ex) {
            logger.error(String.format("machineToken加密异常：%s  %s  %S ",tokenPlain,tokenKey,ex.getMessage()) );
            return "";
        }

    }

    public static boolean checkSignature(String signature,String timestamp,String nonce,String token)
    {
        String str=String.format("nonce=%s&timestapm=%s&token=%s",nonce,timestamp,token);
        String mySignature=SHA1.encode(str);

        return signature.equals(mySignature);
    }
}
