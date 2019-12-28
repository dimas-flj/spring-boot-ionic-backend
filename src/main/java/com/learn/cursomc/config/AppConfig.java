package com.learn.cursomc.config;

import com.learn.cursomc.utils.Constantes;
import com.learn.cursomc.utils.Util;

public class AppConfig {
	private static Constantes prop;
	private static AppConfig app;
	
	public static AppConfig getInstance() {
		if (Util.isNull(app)) {
			app = new AppConfig();
			prop = new Constantes();
		}
		return app;
	}
	
	public String getJwtSecret() {
		String jwt_secret = (String) prop.getPropriedade("jwt_secret");
		System.out.println("jwt_secret = " + jwt_secret);
		return jwt_secret;
	}
	
	public long getJwtExpiration() {
		long jwt_expiration = (long) prop.getPropriedade("jwt_expiration");
		System.out.println("jwt_expiration = " + jwt_expiration);
		return jwt_expiration;
	}
	
	public String getS3Bucket() {
		String s3_bucket = (String) prop.getPropriedade("s3_bucket");
		System.out.println("s3_bucket = " + s3_bucket);
		return s3_bucket;
	}
	
	public String getS3Region() {
		String s3_region = (String) prop.getPropriedade("s3_region");
		System.out.println("s3_region = " + s3_region);
		return s3_region;
	}
	
	public String getAwsAccessKey() {
		String aws_access_key = (String) prop.getPropriedade("aws_access_key");
		System.out.println("aws_access_key = " + aws_access_key);
		return aws_access_key;
	}
	
	public String getAwsSecretAccessKey() {
		String aws_secret_access_key = (String) prop.getPropriedade("aws_secret_access_key");
		System.out.println("aws_secret_access_key = " + aws_secret_access_key);
		return aws_secret_access_key;
	}
	
	public String getMailSender() {
		String mail_sender = (String) prop.getPropriedade("mail_sender");
		System.out.println("mail_sender = " + mail_sender);
		return mail_sender;
	}
	
	public String getMailRecipient() {
		String mail_recipient = (String) prop.getPropriedade("mail_recipient");
		System.out.println("mail_recipient = " + mail_recipient);
		return mail_recipient;
	}
	
	public String getImgPrefixProfile() {
		String img_prefix_profile = (String) prop.getPropriedade("img_prefix_profile");
		System.out.println("img_prefix_profile = " + img_prefix_profile);
		return img_prefix_profile;
	}
	
	public int getImgProfileSize() {
		int img_profile_size = (int) prop.getPropriedade("img_profile_size");
		System.out.println("img_profile_size = " + img_profile_size);
		return img_profile_size;
	}
}