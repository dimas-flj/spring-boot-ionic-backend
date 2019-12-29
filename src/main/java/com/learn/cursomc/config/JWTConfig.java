package com.learn.cursomc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
	{
		"classpath:/application.properties", 
		"classpath:/application-${spring.profiles.active}.properties"
	}
)
@ConfigurationProperties(prefix = "app")
public class JWTConfig {
	private Jwt jwt = new Jwt();
	
	public Jwt getJwt() {
		return jwt;
	}
	
	public class Jwt {
		private String secret;
		private Long expiration;
		
		public String getSecret() {
			return secret;
		}
		
		public void setSecret(String secret) {
			this.secret = secret;
		}
		
		public Long getExpiration() {
			return expiration;
		}
		
		public void setExpiration(Long expiration) {
			this.expiration = expiration;
		}
	}
}