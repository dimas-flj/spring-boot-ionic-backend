package com.learn.cursomc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
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
public class AppConfig {
	@Bean
	public Jwt getJwt() {
		return new Jwt();
	}
	
	@Bean
	public Email getEmail() {
		return new Email();
	}
	
	public class Email {
		private String protocol;
		private String host;
		private int port;
		private String username;
		private String password;
		private boolean auth;
		private boolean starttlsEnable;
		private boolean debug;
		private String trust;
		
		public String getProtocol() {
			return protocol;
		}
		
		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}
		public String getHost() {
			return host;
		}
		
		public void setHost(String host) {
			this.host = host;
		}
		
		public int getPort() {
			return port;
		}
		
		public void setPort(int port) {
			this.port = port;
		}
		
		public String getUserName() {
			return username;
		}
		
		public void setUserName(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public boolean isAuth() {
			return auth;
		}
		
		public void setAuth(boolean auth) {
			this.auth = auth;
		}
		
		public boolean isStarttlsEnable() {
			return starttlsEnable;
		}
		
		public void setStarttlsEnable(boolean starttlsEnable) {
			this.starttlsEnable = starttlsEnable;
		}
		
		public boolean isDebug() {
			return debug;
		}
		
		public void setDebug(boolean debug) {
			this.debug = debug;
		}
		
		public String getTrust() {
			return trust;
		}
		
		public void setTrust(String trust) {
			this.trust = trust;
		}
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