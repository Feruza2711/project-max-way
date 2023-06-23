package uz.pdp.projectmaxway.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import uz.pdp.projectmaxway.utils.Constants;

import java.util.Date;

@Component
public class JwtProvider {

    public String generateAccessToken(UserPrinsipal userPrinsipal){
        Date accessExpirationDate = new Date(System.currentTimeMillis()
                + Constants.ACCESS_TOKEN_EXPIRATION);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, Constants.ACCESS_TOKEN_KEY)
                .setSubject(userPrinsipal.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(accessExpirationDate)
                .compact();

    }

    public String generateRefreshToken(UserPrinsipal userPrinsipal){
        Date refreshExpirationDate = new Date(System.currentTimeMillis()
                + Constants.REFRESH_TOKEN_EXPIRATION);

     return Jwts
                .builder()
                .signWith(SignatureAlgorithm.HS256, Constants.REFRESH_TOKEN_KEY)
                .setSubject(userPrinsipal.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(refreshExpirationDate)
                .compact();

    }


}
