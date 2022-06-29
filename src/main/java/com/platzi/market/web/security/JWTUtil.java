package com.platzi.market.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    public boolean validateToken(String jwt, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(jwt)) && !isTokenExpired(jwt);
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey("plotzi").parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *30))
                .signWith(SignatureAlgorithm.HS256, "plotzi")
                .compact();
    }
}
