package com.learn.cursomc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.cursomc.utils.Constantes;

@Configuration
public class GlobalProperties {
	private static final Logger log = LoggerFactory.getLogger(GlobalProperties.class);
	
	@Bean
	public String getAwsAccessKeyId() {
		log.info("getAwsAccessKeyId() = \"" + Constantes.AWS_ACCESS_KEY_ID + "\"");
		return Constantes.AWS_ACCESS_KEY_ID;
	}
	
	@Bean
	public String getAwsSecretAccessKey() {
		log.info("getAwsSecretAccessKey() = \"" + Constantes.AWS_SECRET_ACCESS_KEY + "\"");
		return Constantes.AWS_SECRET_ACCESS_KEY;
	}
	
	@Bean
	public String getS3Region() {
		log.info("getS3Region() = \"" + Constantes.S3_REGION + "\"");
		return Constantes.S3_REGION;
	}
	
	@Bean
	public String getJwtSecret() {
		log.info("getJwtSecret() = \"" + Constantes.JWT_SECRET + "\"");
		return Constantes.JWT_SECRET;
	}
	
	@Bean
	public String getJwtExpiration() {
		log.info("getJwtExpiration() = \"" + Constantes.JWT_EXPIRATION + "\"");
		return Constantes.JWT_EXPIRATION;
	}
	
	@Bean
	public String getMailSender() {
		log.info("getMailSender() = \"" + Constantes.DEFAULT_SENDER + "\"");
		return Constantes.DEFAULT_SENDER;
	}
	
	@Bean
	public String getMailRecipient() {
		log.info("getMailRecipient() = \"" + Constantes.DEFAULT_RECIPIENT + "\"");
		return Constantes.DEFAULT_RECIPIENT;
	}
	
	@Bean
	public String getImgPrefixClientProfile() {
		log.info("getImgPrefixClientProfile() = \"" + Constantes.IMG_PREFIX_CLIENT_PROFILE + "\"");
		return Constantes.IMG_PREFIX_CLIENT_PROFILE;
	}
	
	@Bean
	public String getImgProfileSize() {
		log.info("getImgProfileSize() = \"" + Constantes.IMG_PROFILE_SIZE + "\"");
		return Constantes.IMG_PROFILE_SIZE;
	}
	
	@Bean
	public String getS3Bucket() {
		log.info("getS3Bucket() = \"" + Constantes.S3_BUCKET + "\"");
		return Constantes.S3_BUCKET;
	}
}