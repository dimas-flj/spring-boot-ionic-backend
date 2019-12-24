package com.learn.cursomc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.cursomc.utils.Util;

@Configuration
public class ConfigProperties {
	private static final Logger log = LoggerFactory.getLogger(ConfigProperties.class);
	
	private static Properties prop;
	
	@Value("${app_mail_sender}")
	private String app_mail_sender;
	
	@Value("${app_mail_recipient}")
	private String app_mail_recipient;
	
	@Value("${app_jwt_secret}")
	private String app_jwt_secret;
	
	@Value("${app_jwt_expiration}")
	private String app_jwt_expiration;
	
	@Value("${app_aws_access_key_id}")
	private String app_aws_access_key_id;
	
	@Value("${app_aws_secret_access_key}")
	private String app_aws_secret_access_key;
	
	@Value("${app_s3_bucket}")
	private String app_s3_bucket;
	
	@Value("${app_s3_region}")
	private String app_s3_region;
	
	@Value("${app_img_prefix_client_profile}")
	private String app_img_prefix_client_profile;
	
	@Value("${app_img_profile_size}")
	private String app_img_profile_size;
	
	public ConfigProperties() throws IOException {
		if (Util.isNull(prop)) {
			try {
				prop = new Properties();
				
				InputStream resourceAsStream = ConfigProperties.class.getClassLoader().getResourceAsStream("application.properties");
				prop.load(resourceAsStream);
			}
			catch(IOException e) {
				throw new IOException("Erro ao obter propriedades.");
			}
		}
	}
	
	@Bean
	public String getAppMailSender() throws IOException {
		return getValue(app_mail_sender, "app_mail_sender", "dimasflj@gmail.com");
	}
	
	@Bean
	public String getAppMailRecipient() throws IOException {
		return getValue(app_mail_recipient, "app_mail_recipient", "dimasflj@gmail.com");
	}
	
	@Bean
	public String getAppJWTSecret() throws IOException {
		return getValue(app_jwt_secret, "app_jwt_secret", "AssinaturarDoTokenParaAutenticacaoEmProducao");
	}
	
	@Bean
	public String getAppJWTExpiration() throws IOException {
		return getValue(app_jwt_expiration, "app_jwt_expiration", "86400000");
	}
	
	@Bean
	public String getAppAWSAccessKeyId() throws IOException {
		return getValue(app_aws_access_key_id, "app_aws_access_key_id", "AKIAZF2LVPEKETAKWLHH");
	}
	
	@Bean
	public String getAppAWSSecretAccessKey() throws IOException {
		return getValue(app_aws_secret_access_key, "app_aws_secret_access_key", "tSB40jC6awtPcNqNWKZKAzLkRAyJdHp5ZNi2F/UZ");
	}
	
	@Bean
	public String getAppS3Bucket() throws IOException {
		return getValue(app_s3_bucket, "app_s3_bucket", "curso-spring-ionic-dimas");
	}
	
	@Bean
	public String getAppS3Region() throws IOException {
		return getValue(app_s3_region, "app_s3_region", "sa-east-1");
	}
	
	@Bean
	public String getAppImgPrefixClientProfile() throws IOException {
		return getValue(app_img_prefix_client_profile, "app_img_prefix_client_profile", "cp");
	}
	
	@Bean
	public String getAppImgProfileSize() throws IOException {
		return getValue(app_img_profile_size, "app_img_profile_size", "200");
	}
	
	private String getValue(String sWiredValue, String nm_prop, String defaulValue) {
		String sOutValue = sWiredValue;
		if (!Util.isValidString(sWiredValue)) {
			sOutValue = prop.getProperty(nm_prop, defaulValue);
			log.info("Obtendo propriedade do arquivo de propriedades - nome(" + nm_prop + ") - valor(" + sOutValue + ")");
		}
		else {
			log.info("Não vai obter propriedade do arquivo de propriedades - nome(" + nm_prop + ") - valor(" + sOutValue + ")");
		}
		return sOutValue;
	}
}