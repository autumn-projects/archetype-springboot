package com.oscroll.configuration.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    public static final String SECRET = "7554aaasdwe";

    public static String getToken(Integer key) {
        return JWT.create().withClaim("userId", key).sign(Algorithm.HMAC256(SECRET));
    }

    public static Integer parseToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims().get("userId").asInt();
    }

}
