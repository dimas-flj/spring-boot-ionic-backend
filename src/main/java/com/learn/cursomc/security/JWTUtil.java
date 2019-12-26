package com.learn.cursomc.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.learn.cursomc.config.GlobalProperties;
import com.learn.cursomc.utils.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	public String generateToken(String username) throws IOException {
		return Jwts.
			builder().
			setSubject(username).
			setExpiration(new Date(System.currentTimeMillis() + Long.getLong(GlobalProperties.getJwtExpiration()))).
			signWith(SignatureAlgorithm.HS512, GlobalProperties.getJwtSecret().getBytes()).
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
			return Jwts.parser().setSigningKey(GlobalProperties.getJwtSecret().getBytes()).parseClaimsJws(token).getBody();
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