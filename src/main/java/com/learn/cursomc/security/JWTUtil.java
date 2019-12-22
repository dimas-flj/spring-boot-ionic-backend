package com.learn.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.cursomc.config.AppGlobalConfigurations;
import com.learn.cursomc.utils.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Autowired
	private AppGlobalConfigurations gConfig;
	
	private String secret;
	private Long expiration;
	
	public String generateToken(String username) {
		secret = gConfig.getJwt().getSecret();
		expiration = gConfig.getJwt().getExpiration();
		
		return Jwts.
				builder().
				setSubject(username).
				setExpiration(new Date(System.currentTimeMillis() + expiration)).
				signWith(SignatureAlgorithm.HS512, secret.getBytes()).
				compact();
	}
	
	public boolean isTokenValido(String token) {
		Claims claims = getClaims(token);
		if (!Util.isNull(claims)) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (Util.isValidString(username) && !Util.isNull(expirationDate) && now.before(expirationDate)) {
				return true;
			}
		}
		
		return false;
	}
	
	private Claims getClaims(String token) {
		try {
			secret = gConfig.getJwt().getSecret();
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch(Exception e) {
			return null;
		}
	}

	public String getUserName(String token) {
		Claims claims = getClaims(token);
		if (!Util.isNull(claims)) {
			String username = claims.getSubject();
			if (Util.isValidString(username)) {
				return username;
			}
		}
		return null;
	}
}