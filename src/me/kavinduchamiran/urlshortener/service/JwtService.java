package me.kavinduchamiran.urlshortener.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import me.kavinduchamiran.urlshortener.utils.DateUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    // this should be an account credential
    private static final String SIGNING_KEY = "VPxHnWKJfRdipArP+PR1RMJGDSfMYEPilXYPISj15DOSb5etkKcH7Q+Bz40GBAlh";

    public String extractUsername(String jwtToken) {
        return parseJwtToken(jwtToken).getSubject();
    }

    public String generateToken(UserDetails user) {
        return generateToken(user, new HashMap<>());
    }

    public String generateToken(UserDetails user, Map<String, Object> claims) {
        return Jwts.builder()
                   .setIssuer("Stormpath")
                   .setSubject(user.getUsername())
                   .claim("name", "Micah Silverman")
                   .claim("scope", "admins")
                   .setIssuedAt(DateUtils.getNow())
                   .setExpiration(DateUtils.addMinutes(100))
                   .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                   .compact();

    }

    private Claims parseJwtToken(String jwtToken) {
        return Jwts.parserBuilder()
                   .setSigningKey(getSigningKey())
                   .build()
                   .parseClaimsJws(jwtToken)
                   .getBody();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SIGNING_KEY));
    }
}
