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
			System.out.println("jwt_secret = " + secret);
			return secret;
		}
		
		public void setSecret(String secret) {
			this.secret = secret;
		}
		
		public Long getExpiration() {
			System.out.println("jwt_expiration = " + expiration);
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
			System.out.println("s3_bucket = " + bucket);
			return bucket;
		}
		
		public void setBucket(String bucket) {
			this.bucket = bucket;
		}
		
		public String getRegion() {
			System.out.println("s3_region = " + region);
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
			System.out.println("aws_access_key = " + accessKey);
			return accessKey;
		}
		
		public void setAccessKey(String access_key) {
			this.accessKey = access_key;
		}
		
		public String getSecretAccessKey() {
			System.out.println("aws_secret_access_key = " + secretAccessKey);
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
			System.out.println("mail_sender = " + sender);
			return sender;
		}
		
		public void setSender(String sender) {
			this.sender = sender;
		}
		
		public String getRecipient() {
			System.out.println("mail_recipient = " + recipient);
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
			System.out.println("img_prefix_profile = " + prefixProfile);
			return prefixProfile;
		}
		
		public void setPrefixProfile(String prefix_profile) {
			this.prefixProfile = prefix_profile;
		}
		
		public int getProfileSize() {
			System.out.println("img_profile_size = " + profileSize);
			return profileSize;
		}
		
		public void setProfileSize(int profile_size) {
			this.profileSize = profile_size;
		}
	}
}