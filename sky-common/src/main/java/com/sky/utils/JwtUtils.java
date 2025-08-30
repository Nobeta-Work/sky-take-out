package com.sky.utils;


import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;


import org.springframework.stereotype.Component;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtUtils {
    /**
     * 生成jwt
     * Hs256
     * @param secret
     * @param ttlMills
     * @param claims
     * @return
     */
    public static String createJwt(String secret, Long ttlMillis, Map<String, Object> claims) {
        // 指定签名算法
        // SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成Jwt时间
        Long expMills = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMills);
        // 生成HMAC密钥
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        // 设置body
        JwtBuilder builder = Jwts.builder()
                                // 声明签名算法和密钥
                                .signWith(key)
                                // 私有声明
                                .claims(claims)
                                // 过期时间
                                .expiration(exp);
        return builder.compact();
    }
    /**
     * Token 解密
     * 
     * @param secret
     * @param token
     * @return
     */
    public static Claims parseJWT(String secret, String token) {
        // 生成HMAC密钥
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        // 得到DefaultJwtParser
        JwtParser jwtParser = Jwts.parser()
                                // 设置签名密钥
                                .verifyWith(key)
                                .build();
        Jws<Claims> jws = jwtParser.parseSignedClaims(token);
        Claims claims = jws.getPayload();
        return claims;
    }
}