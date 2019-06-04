package com.oscroll.configuration.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtil {

    public static final String SECRET = "7554aaasdwe";

    public static String getToken(String key) {
        return JWT.create().withAudience(key).sign(Algorithm.HMAC256(SECRET));
    }

}
