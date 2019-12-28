package com.learn.cursomc.config;

import com.learn.cursomc.utils.Constantes;

public class AppConfig {
	private String jwt_secret = Constantes.JWT_SECRET;
	private long jwt_expiration = Constantes.JWT_EXPIRATION;
	
	private String s3_bucket = Constantes.S3_BUCKET;
	private String s3_region = Constantes.S3_REGION;
	
	private String aws_access_key = Constantes.AWS_ACCESS_KEY;
	private String aws_secret_access_key = Constantes.AWS_SECRET_ACCESS_KEY;
	
	private String mail_sender = Constantes.MAIL_SENDER;
	private String mail_recipient = Constantes.MAIL_RECIPIENT;
	
	private String img_prefix_profile = Constantes.IMG_PREFIX_PROFILE;
	private int img_profile_size = Constantes.IMG_PROFILE_SIZE;
	
	public String getJwtSecret() {
		System.out.println("jwt_secret = " + jwt_secret);
		return jwt_secret;
	}
	
	public void setJwtSecret(String jwt_secret) {
		this.jwt_secret = jwt_secret;
	}
	
	public long getJwtExpiration() {
		System.out.println("jwt_expiration = " + jwt_expiration);
		return jwt_expiration;
	}
	
	public void setJwtExpiration(long jwt_expiration) {
		this.jwt_expiration = jwt_expiration;
	}
	
	public String getS3Bucket() {
		System.out.println("s3_bucket = " + s3_bucket);
		return s3_bucket;
	}
	
	public void setS3Bucket(String s3_bucket) {
		this.s3_bucket = s3_bucket;
	}
	
	public String getS3Region() {
		System.out.println("s3_region = " + s3_region);
		return s3_region;
	}
	
	public void setS3Region(String s3_region) {
		this.s3_region = s3_region;
	}
	
	public String getAwsAccessKey() {
		System.out.println("aws_access_key = " + aws_access_key);
		return aws_access_key;
	}
	
	public void setAwsAccessKey(String aws_access_key) {
		this.aws_access_key = aws_access_key;
	}
	
	public String getAwsSecretAccessKey() {
		System.out.println("aws_secret_access_key = " + aws_secret_access_key);
		return aws_secret_access_key;
	}
	
	public void setAwsSecretAccessKey(String aws_secret_access_key) {
		this.aws_secret_access_key = aws_secret_access_key;
	}
	
	public String getMailSender() {
		System.out.println("mail_sender = " + mail_sender);
		return mail_sender;
	}
	
	public void setMailSender(String mail_sender) {
		this.mail_sender = mail_sender;
	}
	
	public String getMailRecipient() {
		System.out.println("mail_recipient = " + mail_recipient);
		return mail_recipient;
	}
	
	public void setMailRecipient(String mail_recipient) {
		this.mail_recipient = mail_recipient;
	}
	
	public String getImgPrefixProfile() {
		System.out.println("img_prefix_profile = " + img_prefix_profile);
		return img_prefix_profile;
	}
	
	public void setImgPrefixProfile(String img_prefix_profile) {
		this.img_prefix_profile = img_prefix_profile;
	}
	
	public int getImgProfileSize() {
		System.out.println("img_profile_size = " + img_profile_size);
		return img_profile_size;
	}
	
	public void setImgProfileSize(int img_profile_size) {
		this.img_profile_size = img_profile_size;
	}
}