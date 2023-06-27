package com.unicordoba.gps.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.unicordoba.gps.security.config.ConfigJwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
   
   @Autowired
   private final ConfigJwt configJwt;

   private Key KEY;

   JwtUtil(ConfigJwt configuracionJwt){
      this.configJwt = configuracionJwt;
      KEY = new SecretKeySpec(this.configJwt.getJWT_SECRET().getBytes(), 0, this.configJwt.getJWT_SECRET().getBytes().length, "HmacSHA256");
   }

   public String createToken(UserDetails userDetails){
      String username = userDetails.getUsername();

      Map<String, Object> claims = new HashMap<>();
      claims.put("username", userDetails.getUsername());

      return Jwts.builder()
              .setSubject(username)
              .addClaims(claims)
              .setExpiration(new Date(System.currentTimeMillis() + configJwt.getJWT_EXPIRATION_TIME()))
              .signWith(KEY, SignatureAlgorithm.HS256)
              .compact();
   }

   public Boolean hasTokenExpired(String token){
      return Jwts.parserBuilder()
              .setSigningKey(KEY)
              .build()
              .parseClaimsJws(token)
              .getBody()
              .getExpiration()
              .before(new Date());
   }

   public Boolean validateToken(String token, UserDetails userDetails){
      String username = extractUsername(token);
      return (userDetails.getUsername().equals(username) && !hasTokenExpired(token));
   }

   public String extractUsername(String token){
      return Jwts.parserBuilder()
              .setSigningKey(KEY)
              .build()
              .parseClaimsJws(token)
              .getBody()
              .getSubject();
   }

}
