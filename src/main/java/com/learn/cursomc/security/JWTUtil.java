package com.learn.cursomc.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.learn.cursomc.utils.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${jwt.secret}")
	private String jwt_secret;
	
	@Value("${jwt.expiration}")
	private Long jwt_expiration;
	
	@Autowired
	private Environment env;
	
	public String getJwtSecret() {
		if (!Util.isValidString(jwt_secret)) {
			jwt_secret = env.getProperty("jwt.secret");
			System.out.println("jwt_secret(Enviroment) = " + jwt_secret);
		}
		else {
			System.out.println("jwt_secret(@Value) = " + jwt_secret);
		}
		return jwt_secret;
	}
	
	public Long getJwtExpiration() {
		if (!Util.isValidString(jwt_expiration)) {
			jwt_expiration = env.getProperty("jwt.expiration", Long.class);
			System.out.println("jwt_expiration(Enviroment) = " + jwt_expiration);
		}
		else {
			System.out.println("jwt_expiration(@Value) = " + jwt_expiration);
		}
		return jwt_expiration;
	}
	
	public String generateToken(String username) throws IOException {
		
		System.out.println("USERNAME = " + username);
		System.out.println("jwt_secret = " + getJwtSecret());
		System.out.println("jwt_expiration = " + getJwtExpiration());
		
		return Jwts.
			builder().
			setSubject(username).
			setExpiration(new Date(System.currentTimeMillis() + getJwtExpiration())).
			signWith(SignatureAlgorithm.HS512, getJwtSecret().getBytes()).
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
			return Jwts.parser().setSigningKey(getJwtSecret().getBytes()).parseClaimsJws(token).getBody();
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