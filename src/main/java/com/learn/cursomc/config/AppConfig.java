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
public class AppConfig {
	@Bean
	@ConfigurationProperties(prefix = "jwt")
	public Jwt getJwt() {
		return new Jwt();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "s3")
	public S3 getS3() {
		return new S3();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "aws")
	public Aws getAws() {
		return new Aws();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mail")
	public Mail getMail() {
		return new Mail();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "img")
	public Img getImg() {
		return new Img();
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
	
	public class S3 {
		private String bucket;
		private String region;
		
		public String getBucket() {
			return bucket;
		}
		
		public void setBucket(String bucket) {
			this.bucket = bucket;
		}
		
		public String getRegion() {
			return region;
		}
		
		public void setRegion(String region) {
			this.region = region;
		}
	}
	
	public class Aws {
		private String accessKey;
		private String secretAccessKey;
		
		public String getAccessKey() {
			return accessKey;
		}
		
		public void setAccessKey(String access_key) {
			this.accessKey = access_key;
		}
		
		public String getSecretAccessKey() {
			return secretAccessKey;
		}
		
		public void setSecretAccessKey(String secret_access_key) {
			this.secretAccessKey = secret_access_key;
		}
	}
	
	public class Mail {
		private String sender;
		private String recipient;
		
		public String getSender() {
			return sender;
		}
		
		public void setSender(String sender) {
			this.sender = sender;
		}
		
		public String getRecipient() {
			return recipient;
		}
		
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
	}
	
	public class Img {
		private String prefixProfile;
		private int profileSize;
		
		public String getPrefixProfile() {
			return prefixProfile;
		}
		
		public void setPrefixProfile(String prefix_profile) {
			this.prefixProfile = prefix_profile;
		}
		
		public int getProfileSize() {
			return profileSize;
		}
		
		public void setProfileSize(int profile_size) {
			this.profileSize = profile_size;
		}
	}
}