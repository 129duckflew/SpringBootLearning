package cn.duckflew.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil
{
    private static final String SIGN="dajklhsdkl1hk32jhr234i58ihkjnsadas";

    public static String getToken(Map<String,String> map)
    {
        Calendar instance=Calendar.getInstance();
        instance.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        builder.withExpiresAt(instance.getTime());
        String token= builder
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }
    public static boolean verify(String token)
    {
        try
        {
            JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public static DecodedJWT getTokenInfo(String token)
    {
        DecodedJWT verify= JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }
    public static String getUsernameFromToken(String token)
    {
        try {
            DecodedJWT jwt = getTokenInfo(token);
            return jwt.getClaim("username").asString();
        } catch (Exception e) {
            return null;
        }
    }
}
