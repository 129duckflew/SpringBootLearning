package cn.duckflew.springsecuritylearning;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class JwtTest
{
    @Test
    public void gengerateToken()
    {
        Calendar instance =Calendar.getInstance();
        instance.add(Calendar.SECOND,60);
        Map<String,Object> map=new HashMap<>();
        String token = JWT.create().withHeader(map).withClaim("username", "123456").withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
    }
    @Test
    public void validToken()
    {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("secret")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTk1NDM0MzksInVzZXJuYW1lIjoiMTIzNDU2In0.LRdw_rTozhUYJHQqkAPJnOKVIie8XChZHwz7YRvK8VE");
        System.out.println(decodedJWT.getClaim("username").asString());

    }
}
