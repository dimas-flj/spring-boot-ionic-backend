package com.learn.cursomc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learn.cursomc.utils.Constantes;

public class GlobalProperties {
	private static final Logger log = LoggerFactory.getLogger(GlobalProperties.class);
	
	public static String getAwsAccessKeyId() {
		log.info("getAwsAccessKeyId() = \"" + Constantes.AWS_ACCESS_KEY_ID + "\"");
		return Constantes.AWS_ACCESS_KEY_ID;
	}
	
	public static String getAwsSecretAccessKey() {
		log.info("getAwsSecretAccessKey() = \"" + Constantes.AWS_SECRET_ACCESS_KEY + "\"");
		return Constantes.AWS_SECRET_ACCESS_KEY;
	}
	
	public static String getS3Region() {
		log.info("getS3Region() = \"" + Constantes.S3_REGION + "\"");
		return Constantes.S3_REGION;
	}
	
	public static String getJwtSecret() {
		log.info("getJwtSecret() = \"" + Constantes.JWT_SECRET + "\"");
		return Constantes.JWT_SECRET;
	}
	
	public static String getJwtExpiration() {
		log.info("getJwtExpiration() = \"" + Constantes.JWT_EXPIRATION + "\"");
		return Constantes.JWT_EXPIRATION;
	}
	
	public static String getMailSender() {
		log.info("getMailSender() = \"" + Constantes.DEFAULT_SENDER + "\"");
		return Constantes.DEFAULT_SENDER;
	}
	
	public static String getMailRecipient() {
		log.info("getMailRecipient() = \"" + Constantes.DEFAULT_RECIPIENT + "\"");
		return Constantes.DEFAULT_RECIPIENT;
	}
	
	public static String getImgPrefixClientProfile() {
		log.info("getImgPrefixClientProfile() = \"" + Constantes.IMG_PREFIX_CLIENT_PROFILE + "\"");
		return Constantes.IMG_PREFIX_CLIENT_PROFILE;
	}
	
	public static String getImgProfileSize() {
		log.info("getImgProfileSize() = \"" + Constantes.IMG_PROFILE_SIZE + "\"");
		return Constantes.IMG_PROFILE_SIZE;
	}
	
	public static String getS3Bucket() {
		log.info("getS3Bucket() = \"" + Constantes.S3_BUCKET + "\"");
		return Constantes.S3_BUCKET;
	}
}