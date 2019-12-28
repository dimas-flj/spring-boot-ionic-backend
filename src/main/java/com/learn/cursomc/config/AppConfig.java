package com.learn.cursomc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learn.cursomc.utils.Util;

public class AppConfig {
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	private static AppConfig app;
	
	public static AppConfig getInstance() {
		log.info("Solicita nova instancia");
		if (Util.isNull(app)) {
			log.info("app eh nulo. Cria nova instancia");
			app = new AppConfig();
			log.info("app =\r\n" + app.toString());
		}
		else {
			log.info("app nao eh nulo. Devolve instancia atual =\r\n" + app.toString());
		}
		return app;
	}
	
	public String getJwtSecret() {
		String jwt_secret = "";
		return jwt_secret;
	}
	
	public long getJwtExpiration() {
		long jwt_expiration = 0L;
		return jwt_expiration;
	}
	
	public String getS3Bucket() {
		String s3_bucket = "";
		return s3_bucket;
	}
	
	public String getS3Region() {
		String s3_region = "";
		return s3_region;
	}
	
	public String getAwsAccessKey() {
		String aws_access_key = "";
		return aws_access_key;
	}
	
	public String getAwsSecretAccessKey() {
		String aws_secret_access_key = "";
		return aws_secret_access_key;
	}
	
	public String getMailSender() {
		String mail_sender = "";
		return mail_sender;
	}
	
	public String getMailRecipient() {
		String mail_recipient = "";
		return mail_recipient;
	}
	
	public String getImgPrefixProfile() {
		String img_prefix_profile = "";
		return img_prefix_profile;
	}
	
	public int getImgProfileSize() {
		int img_profile_size = 0;
		return img_profile_size;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppConfig\r\n[\r\n\tgetJwtSecret() = ");
		builder.append(getJwtSecret());
		builder.append(",\r\n\tgetJwtExpiration() = ");
		builder.append(getJwtExpiration());
		builder.append(",\r\n\tgetS3Bucket() = ");
		builder.append(getS3Bucket());
		builder.append(",\r\n\tgetS3Region() = ");
		builder.append(getS3Region());
		builder.append(",\r\n\tgetAwsAccessKey() = ");
		builder.append(getAwsAccessKey());
		builder.append(",\r\n\tgetAwsSecretAccessKey() = ");
		builder.append(getAwsSecretAccessKey());
		builder.append(",\r\n\tgetMailSender() = ");
		builder.append(getMailSender());
		builder.append(",\r\n\tgetMailRecipient() = ");
		builder.append(getMailRecipient());
		builder.append(",\r\n\tgetImgPrefixProfile() = ");
		builder.append(getImgPrefixProfile());
		builder.append(",\r\n\tgetImgProfileSize() = ");
		builder.append(getImgProfileSize());
		builder.append("\r\n]");
		return builder.toString();
	}
}