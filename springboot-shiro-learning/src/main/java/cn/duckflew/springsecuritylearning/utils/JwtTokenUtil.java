package cn.duckflew.springsecuritylearning.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.CustomExchange;

import javax.xml.bind.DatatypeConverter;

public class JwtTokenUtil
{
    private static Logger log= LoggerFactory.getLogger(JwtTokenUtil.class );
    public static final String AUTH_HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";


//    public static Claims parseJWT(String jsonWebToken,String base64Security)
//    {
//        try
//        {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
//                    .parseClaimsJws(jsonWebToken).getBody();
//            return claims;
//        }
//        catch (ExpiredJwtException eje)
//        {
//            log.error("===========Token过期=========",eje);
//        }
//
//    }














}
