package com.gst.boot.shiro.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtils {

    private static final Logger logger = LoggerFactory.getLogger(JWTUtils.class);
    // 过期时间30分钟
    private static final long EXPRIE_TIME = 30*60*1000;
    // 秘钥
    private static final String SECRET = "jwt-boot";

    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Title: getUsername
     * @Description: 获取token中的信息无需secret解密也能获得
     * @Author 刘仁
     * @DateTime 2019年4月1日 下午4:42:39
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getValueByKey(String token,String key){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String sign(String username) throws UnsupportedEncodingException {
        Date date = new Date(System.currentTimeMillis()+EXPRIE_TIME);
        Algorithm algorithm = Algorithm.HMAC512(SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String username = "username";
//        System.out.println(sign("username"));
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ0ZXN0IjoidGVzdHRlc3QiLCJleHAiOjE1Nzc2OTg2ODEsInVzZXJuYW1lIjoidXNlcm5hbWUifQ.Wpwz3CH6BLOeZCEcK6p8TZqNijS-4AqQh18nPuigZVyxS-loIP7oVwM1ycDQC5CrOxWGVuTxOV3s8-Nyz2oxog";
//        System.out.println(verify(token,username));
//        System.out.println(getUsername(token));
//        System.out.println(getValueByKey(token,"test"));
//    }
}
