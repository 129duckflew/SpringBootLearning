package cn.duckflew.springsecuritylearning.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil
{
    private static final String secret="jdklasdjlskajd";


    public static String getToken(Map<String,String>map)
    {
        Calendar instance=Calendar.getInstance();
        instance.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(secret));
    }
    public static DecodedJWT validateToken(String token)
    {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}
