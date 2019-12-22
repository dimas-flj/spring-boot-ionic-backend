package com.learn.cursomc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppGlobalConfigurations {
	private Jwt jwt = new Jwt();
	private Aws aws = new Aws();
	private S3 s3 = new S3();
	private Img img = new Img();
	private Mail mail = new Mail();
	
	public static class Jwt {
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
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Jwt [secret=");
			builder.append(secret);
			builder.append(", expiration=");
			builder.append(expiration);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static class Aws {
		private String access_key_id;
		private String secret_access_key;
		
		public String getAccesskeyId() {
			return access_key_id;
		}
		
		public void setAccesskeyId(String access_key_id) {
			this.access_key_id = access_key_id;
		}
		
		public String getSecretAccessKey() {
			return secret_access_key;
		}
		
		public void setSecretAccessKey(String secret_access_key) {
			this.secret_access_key = secret_access_key;
		}
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Aws [access_key_id=");
			builder.append(access_key_id);
			builder.append(", secret_access_key=");
			builder.append(secret_access_key);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static class S3 {
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
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("S3 [bucket=");
			builder.append(bucket);
			builder.append(", region=");
			builder.append(region);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static class Img {
		private String prefixClientProfile;
		private String profileSize;
		
		public String getPrefixClientProfile() {
			return prefixClientProfile;
		}
		
		public void setPrefixClientProfile(String prefixClientProfile) {
			this.prefixClientProfile = prefixClientProfile;
		}
		
		public String getProfileSize() {
			return profileSize;
		}
		
		public void setProfileSize(String profileSize) {
			this.profileSize = profileSize;
		}
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Img [prefixClientProfile=");
			builder.append(prefixClientProfile);
			builder.append(", profileSize=");
			builder.append(profileSize);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static class Mail {
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
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Mail [sender=");
			builder.append(sender);
			builder.append(", recipient=");
			builder.append(recipient);
			builder.append("]");
			return builder.toString();
		}
	}

	
	public Jwt getJwt() {
		return jwt;
	}

	
	public void setJwt(Jwt jwt) {
		this.jwt = jwt;
	}

	
	public Aws getAws() {
		return aws;
	}

	
	public void setAws(Aws aws) {
		this.aws = aws;
	}

	
	public S3 getS3() {
		return s3;
	}

	
	public void setS3(S3 s3) {
		this.s3 = s3;
	}

	
	public Img getImg() {
		return img;
	}

	
	public void setImg(Img img) {
		this.img = img;
	}

	
	public Mail getMail() {
		return mail;
	}

	
	public void setMail(Mail mail) {
		this.mail = mail;
	}
}