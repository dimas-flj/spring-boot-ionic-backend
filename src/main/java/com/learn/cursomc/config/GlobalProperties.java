package com.learn.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GlobalProperties {
	@Autowired
	Environment environment;
	
	private String aws_access_key_id;
	private String aws_secret_access_key;
	private String s3_region;
	private String jwt_secret;
	private String jwt_expiration;
	private String mail_sender;
	private String mail_recipient;
	private String img_prefix_client_profile;
	private String img_profile_size;
	private String s3_bucket;
	
	public String getAwsAccessKeyId() {
		aws_access_key_id = environment.getProperty("aws.access_key_id");
		System.out.println("aws_access_key_id = \"" + aws_access_key_id + "\"");
		return aws_access_key_id;
	}
	
	public String getAwsSecretAccessKey() {
		aws_secret_access_key = environment.getProperty("aws.secret_access_key");
		System.out.println("aws_secret_access_key = \"" + aws_secret_access_key + "\"");
		return aws_secret_access_key;
	}
	
	public String getS3Region() {
		s3_region = environment.getProperty("s3.region");
		System.out.println("s3_region = \"" + s3_region + "\"");
		return s3_region;
	}
	
	public String getJwtSecret() {
		jwt_secret = environment.getProperty("jwt.secret");
		System.out.println("jwt_secret = \"" + jwt_secret + "\"");
		return jwt_secret;
	}
	
	public String getJwtExpiration() {
		jwt_expiration = environment.getProperty("jwt.expiration");
		System.out.println("jwt_expiration = \"" + jwt_expiration + "\"");
		return jwt_expiration;
	}
	
	public String getMailSender() {
		mail_sender = environment.getProperty("default.sender");
		System.out.println("mail_sender = \"" + mail_sender + "\"");
		return mail_sender;
	}
	
	public String getMailRecipient() {
		mail_recipient = environment.getProperty("default.recipient");
		System.out.println("mail_recipient = \"" + mail_recipient + "\"");
		return mail_recipient;
	}
	
	public String getImgPrefixClientProfile() {
		img_prefix_client_profile = environment.getProperty("img.prefix.client.profile");
		System.out.println("img_prefix_client_profile = \"" + img_prefix_client_profile + "\"");
		return img_prefix_client_profile;
	}
	
	public String getImgProfileSize() {
		img_profile_size = environment.getProperty("img.profile.size");
		System.out.println("img_profile_size = \"" + img_profile_size + "\"");
		return img_profile_size;
	}
	
	public String getS3Bucket() {
		s3_bucket = environment.getProperty("s3.bucket");
		System.out.println("s3_bucket = \"" + s3_bucket + "\"");
		return s3_bucket;
	}
}