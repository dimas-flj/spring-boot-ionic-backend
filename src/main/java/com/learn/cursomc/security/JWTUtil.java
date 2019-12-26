package com.learn.cursomc.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.learn.cursomc.utils.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${app_jwt_secret}")
	private String app_jwt_secret;
	@Value("${app_jwt_expiration}")
	private String app_jwt_expiration;
	
//	public JWTUtil() {
//		super();
//		System.out.println("app_jwt_secret = " + app_jwt_secret);
//		System.out.println("app_jwt_expiration = " + app_jwt_expiration);
////		app_jwt_secret = ConfigProperties.getInstance().getValue(app_jwt_secret, "app_jwt_secret");
////		app_jwt_expiration = ConfigProperties.getInstance().getValue(app_jwt_expiration, "app_jwt_expiration");
//	}
	
	public String generateToken(String username) throws IOException {
		System.out.println("app_jwt_secret = " + app_jwt_secret);
		System.out.println("app_jwt_expiration = " + app_jwt_expiration);
		return Jwts.
			builder().
			setSubject(username).
			setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(app_jwt_expiration))).
			signWith(SignatureAlgorithm.HS512, app_jwt_secret.getBytes()).
			compact();
	}
	
	public boolean isTokenValido(String token) throws IOException {
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
	
	private Claims getClaims(String token) throws IOException {
		try {
			return Jwts.parser().setSigningKey(app_jwt_secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch(Exception e) {
			return null;
		}
	}

	public String getUserName(String token) throws IOException {
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