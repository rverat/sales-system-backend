package com.mycompany.system.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private static final Map<String, Instant> invalidatedTokens = new HashMap<>();
    private static final String SECRET = generateRandomSecret();
    private static final Duration EXPIRATION_DURATION = Duration.ofHours(10);

    private static String generateRandomSecret() {
        byte[] secretBytes = new byte[32]; // 256 bits
        new SecureRandom().nextBytes(secretBytes);
        return Base64.getEncoder().encodeToString(secretBytes);
    }

    public static String generateToken(String username) throws JOSEException {
        Instant now = Instant.now();
        Instant expirationTime = now.plus(EXPIRATION_DURATION);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issueTime(Date.from(now))
                .expirationTime(Date.from(expirationTime))
                .build();

        JWSSigner signer = new MACSigner(SECRET.getBytes());
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
        signedJWT.sign(signer);

        return signedJWT.serialize();
    }

    public static String getUsernameFromToken(String token) throws JOSEException, ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        if (signedJWT.verify(new MACVerifier(SECRET.getBytes()))) {
            return signedJWT.getJWTClaimsSet().getSubject();
        } else {
            throw new JOSEException("Invalid token signature");
        }
    }

    public static ResponseEntity validateToken(String token) throws JOSEException, ParseException {

        if(isTokenValid(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        if(token == null || token.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            if (!signedJWT.verify(new MACVerifier(SECRET.getBytes()))) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public static ResponseEntity invalidateToken(String token) {
        invalidatedTokens.put(token, Instant.now());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private static boolean isTokenValid(String token) {
        return invalidatedTokens.containsKey(token);
    }

}