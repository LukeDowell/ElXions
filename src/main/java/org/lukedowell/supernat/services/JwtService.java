package org.lukedowell.supernat.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ldowell on 11/30/15.
 */

@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";


    @Value("${jwt.signingkey}")
    String signingKey;

    @Value("${jwt.algorithm}")
    String algorithm;

    @Autowired
    UserDetailsService userDetailsService;

    private UserDetails parseToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userDetailsService.loadUserByUsername(username);
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.forName(algorithm), signingKey)
                .compact();
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        logger.debug("getAuthentication - request: {}", request);
        final String token = request.getHeader(AUTH_HEADER_NAME);
        logger.debug("getAuthentication - token: {}", token);

        if(token != null) {
            final UserDetails user = parseToken(token);
            logger.debug("getAuthentication - user: {}", user);
            if(user != null) {
                return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            }
        }
        return null;
    }

}
