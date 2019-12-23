package com.learn.cursomc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class ConfigProperties {
	// Configuracoes de envio de email
	private String mail_sender;
	private String mail_recipient;
	
	// Configuracoes de autenticacao do usuario no APP
	private String jwt_secret;
	private String jwt_expiration;
	
	// Configuracoes de autenticacao do usuario no AWS/S3
	private String aws_access_key_id;
	private String aws_secret_access_key;
	
	// Configuracoes de acesso aos recursos do AWS/S3
	private String s3_bucket;
	private String s3_region;
	
	// Configuracoes de acesso as imagens do bucket AWS/S3
	private String img_prefix_client_profile;
	private String img_profile_size;
	
	public String getMailSender() {
		return mail_sender;
	}
	
	public void setMailSender(String mail_sender) {
		this.mail_sender = mail_sender;
	}
	
	public String getMailRecipient() {
		return mail_recipient;
	}
	
	public void setMailRecipient(String mail_recipient) {
		this.mail_recipient = mail_recipient;
	}
	
	public String getJWTSecret() {
		return jwt_secret;
	}
	
	public void setJWTSecret(String jwt_secret) {
		this.jwt_secret = jwt_secret;
	}
	
	public String geJWTExpiration() {
		return jwt_expiration;
	}
	
	public void setJWTExpiration(String jwt_expiration) {
		this.jwt_expiration = jwt_expiration;
	}
	
	public String getAWSAccessKeyId() {
		return aws_access_key_id;
	}
	
	public void setAWSAccessKeyId(String aws_access_key_id) {
		this.aws_access_key_id = aws_access_key_id;
	}
	
	public String getAWSSecretAccessKey() {
		return aws_secret_access_key;
	}
	
	public void setAWSSecretAccessKey(String aws_secret_access_key) {
		this.aws_secret_access_key = aws_secret_access_key;
	}
	
	public String getS3Bucket() {
		return s3_bucket;
	}
	
	public void setS3Bucket(String s3_bucket) {
		this.s3_bucket = s3_bucket;
	}
	
	public String getS3Region() {
		return s3_region;
	}
	
	public void setS3Region(String s3_region) {
		this.s3_region = s3_region;
	}
	
	public String getImgPrefixClientProfile() {
		return img_prefix_client_profile;
	}
	
	public void setImgPrefixClientProfile(String img_prefix_client_profile) {
		this.img_prefix_client_profile = img_prefix_client_profile;
	}
	
	public String getImgProfileSize() {
		return img_profile_size;
	}
	
	public void setImgProfileSize(String img_profile_size) {
		this.img_profile_size = img_profile_size;
	}
}