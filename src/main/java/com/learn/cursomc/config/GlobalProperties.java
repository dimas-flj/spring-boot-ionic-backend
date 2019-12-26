package com.learn.cursomc.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learn.cursomc.utils.Constantes;
import com.learn.cursomc.utils.Util;

public class GlobalProperties {
	private static final Logger log = LoggerFactory.getLogger(GlobalProperties.class);
	private static Properties prop;
	
	public static void init(String activeProfile) throws IOException {
		if (Util.isNull(prop)) {
			prop = new Properties();
			
			setActiveProfile(activeProfile);
			
			URL urlProp = GlobalProperties.class.getClassLoader().getResource("application-prod.properties");
			if (Util.isNull(urlProp)) {
				throw new IOException("Nao achou arquivo de propriedades.");
			}
			
			InputStream resourceAsStream = GlobalProperties.class.getClassLoader().getResourceAsStream("application-prod.properties");
			if (Util.isNull(resourceAsStream)) {
				throw new IOException("Nao achou arquivo de propriedades.");
			}
			
			prop.load(resourceAsStream);
			if (prop.isEmpty()) {
				throw new IOException("Nao achou arquivo de propriedades.");
			}
		}
	}
	
	private static void setActiveProfile(String prof) throws IOException {
		URL urlProp = null;
		String profile_file = "";
		if (prof.equals("test")) {
			urlProp = GlobalProperties.class.getClassLoader().getResource("application-test.properties");
			profile_file = "application-test.properties";
		}
		else if (prof.equals("dev")) {
			urlProp = GlobalProperties.class.getClassLoader().getResource("application-dev.properties");
			profile_file = "application-dev.properties";
		}
		else if (prof.equals("prod")) {
			urlProp = GlobalProperties.class.getClassLoader().getResource("application-prod.properties");
			profile_file = "application-prod.properties";
		}
		else {
			throw new IOException("Nao achou arquivo \"" + prof + "\" de propriedades.");
		}
		
		if (Util.isNull(urlProp)) {
			throw new IOException("Nao achou arquivo \"" + prof + "\" de propriedades.");
		}
		log.info("URL Profile = " + urlProp.toString());
		
		InputStream resourceAsStream = GlobalProperties.class.getClassLoader().getResourceAsStream(profile_file);
		if (Util.isNull(resourceAsStream)) {
			throw new IOException("Nao achou arquivo \"" + prof + "\" de propriedades.");
		}
		
		prop.load(resourceAsStream);
		if (prop.isEmpty()) {
			throw new IOException("Nao achou arquivo \"" + prof + "\" de propriedades.");
		}
	}
	
	private static String aws_access_key_id;
	private static String aws_secret_access_key;
	private static String s3_region;
	private static String jwt_secret;
	private static String jwt_expiration;
	private static String mail_sender;
	private static String mail_recipient;
	private static String img_prefix_client_profile;
	private static String img_profile_size;
	private static String s3_bucket;
	
	public static String getAwsAccessKeyId() {
		aws_access_key_id = prop.getProperty("aws.access_key_id");
		if (Util.isValidString(aws_access_key_id)) {
			log.info("[PROP] aws_access_key_id = \"" + aws_access_key_id + "\"");
		}
		else {
			aws_access_key_id = Constantes.AWS_ACCESS_KEY_ID;
			log.warn("[CONST] aws_access_key_id = \"" + aws_access_key_id + "\"");
		}
		return aws_access_key_id;
	}
	
	public static String getAwsSecretAccessKey() {
		aws_secret_access_key = prop.getProperty("aws.secret_access_key");
		if (Util.isValidString(aws_secret_access_key)) {
			log.info("[PROP] aws_secret_access_key = \"" + aws_secret_access_key + "\"");
		}
		else {
			aws_secret_access_key = Constantes.AWS_SECRET_ACCESS_KEY;
			log.warn("[CONST] aws_secret_access_key = \"" + aws_secret_access_key + "\"");
		}
		return aws_secret_access_key;
	}
	
	public static String getS3Region() {
		s3_region = prop.getProperty("s3.region");
		if (Util.isValidString(s3_region)) {
			log.info("[PROP] s3_region = \"" + s3_region + "\"");
		}
		else {
			s3_region = Constantes.S3_REGION;
			log.warn("[CONST] s3_region = \"" + s3_region + "\"");
		}
		return s3_region;
	}
	
	public static String getJwtSecret() {
		jwt_secret = prop.getProperty("jwt.secret");
		if (Util.isValidString(jwt_secret)) {
			log.info("[PROP] jwt_secret = \"" + jwt_secret + "\"");
		}
		else {
			jwt_secret = Constantes.JWT_SECRET;
			log.warn("[CONST] jwt_secret = \"" + jwt_secret + "\"");
		}
		return jwt_secret;
	}
	
	public static String getJwtExpiration() {
		jwt_expiration = prop.getProperty("jwt.expiration");
		if (Util.isValidString(jwt_expiration)) {
			log.info("[PROP] jwt_expiration = \"" + jwt_expiration + "\"");
		}
		else {
			jwt_expiration = Constantes.JWT_EXPIRATION;
			log.warn("[CONST] jwt_expiration = \"" + jwt_expiration + "\"");
		}
		return jwt_expiration;
	}
	
	public static String getMailSender() {
		mail_sender = prop.getProperty("default.sender");
		if (Util.isValidString(mail_sender)) {
			log.info("[PROP] mail_sender = \"" + mail_sender + "\"");
		}
		else {
			mail_sender = Constantes.DEFAULT_SENDER;
			log.warn("[CONST] mail_sender = \"" + mail_sender + "\"");
		}
		return mail_sender;
	}
	
	public static String getMailRecipient() {
		mail_recipient = prop.getProperty("default.recipient");
		if (Util.isValidString(mail_recipient)) {
			log.info("[PROP] mail_recipient = \"" + mail_recipient + "\"");
		}
		else {
			mail_recipient = Constantes.DEFAULT_RECIPIENT;
			log.warn("[CONST] mail_recipient = \"" + mail_recipient + "\"");
		}
		return mail_recipient;
	}
	
	public static String getImgPrefixClientProfile() {
		img_prefix_client_profile = prop.getProperty("img.prefix.client.profile");
		if (Util.isValidString(img_prefix_client_profile)) {
			log.info("[PROP] img_prefix_client_profile = \"" + img_prefix_client_profile + "\"");
		}
		else {
			img_prefix_client_profile = Constantes.IMG_PREFIX_CLIENT_PROFILE;
			log.warn("[CONST] img_prefix_client_profile = \"" + img_prefix_client_profile + "\"");
		}
		return img_prefix_client_profile;
	}
	
	public static String getImgProfileSize() {
		img_profile_size = prop.getProperty("img.profile.size");
		if (Util.isValidString(img_profile_size)) {
			log.info("[PROP] img_profile_size = \"" + img_profile_size + "\"");
		}
		else {
			img_profile_size = Constantes.IMG_PROFILE_SIZE;
			log.warn("[CONST] img_profile_size = \"" + img_profile_size + "\"");
		}
		return img_profile_size;
	}
	
	public static String getS3Bucket() {
		s3_bucket = prop.getProperty("s3.bucket");
		if (Util.isValidString(s3_bucket)) {
			log.info("[PROP] s3_bucket = \"" + s3_bucket + "\"");
		}
		else {
			s3_bucket = Constantes.S3_BUCKET;
			log.warn("[CONST] s3_bucket = \"" + s3_bucket + "\"");
		}
		return s3_bucket;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(
			"GlobalProperties [\r\n" + 
			"\tgetAwsAccessKeyId() = " + getAwsAccessKeyId() + ",\r\n" +
			"\tgetAwsSecretAccessKey() = " + getAwsSecretAccessKey() + ",\r\n" +
			"\tgetS3Region() = " + getS3Region() + ",\r\n" +
			"\tgetJwtSecret() = " + getJwtSecret() + ",\r\n" +
			"\tgetJwtExpiration() = " + getJwtExpiration() + ",\r\n" +
			"\tgetMailSender() = " + getMailSender() + ",\r\n" +
			"\tgetMailRecipient() = " + getMailRecipient() + ",\r\n" +
			"\tgetImgPrefixClientProfile() = " + getImgPrefixClientProfile() + ",\r\n" +
			"\tgetImgProfileSize() = " + getImgProfileSize() + ",\r\n" +
			"\tgetS3Bucket() = " + getS3Bucket() + "\r\n" +
			"]"
		);
		return builder.toString();
	}
}