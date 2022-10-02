package com.be.ecommerce.security.config;

import com.be.ecommerce.constants.Constants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Value("${jwt.token.secret}")
    private String secret;

    public String generateToken(String username){

        byte[] apiKey = DatatypeConverter.parseBase64Binary(secret);
        Key key = new SecretKeySpec(apiKey,signatureAlgorithm.getJcaName());

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constants.TIME_EXPIRATION))
                .setSubject(username)
                .claim(Constants.AUTHORITIES,
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .signWith(key)
                .compact();

        return Constants.BEARER + token;
    }

    public Boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).build();
            return true;
        } catch(MalformedJwtException e){
            logger.error(Constants.TOKEN_INVALID,e.getMessage());
        } catch(ExpiredJwtException e){
            logger.error(Constants.TOKEN_EXPIRED,e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error(Constants.TOKEN_UNSUPPORTED,e.getMessage());
        } catch( IllegalArgumentException e){
            logger.error(Constants.TOKEN_ARGUMENT,e.getMessage());
        }
        return false;
    }

    public String getUsername(String token){
        return Jwts.parserBuilder().build().parseClaimsJwt(token).getBody().getSubject();
    }
}
