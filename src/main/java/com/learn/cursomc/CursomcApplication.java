package com.learn.cursomc;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

// Teste de upload sem endpoint
// import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.learn.cursomc.config.ConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
//@ConfigurationPropertiesScan("com.learn.cursomc.config")
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private ConfigProperties thisConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args) throws Exception {}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		
		System.out.println("getMailSender() = " + thisConfig.getMailSender());
		System.out.println("getMailRecipient() = " + thisConfig.getMailRecipient());
		
		System.out.println("getJWTSecret() = " + thisConfig.getJWTSecret());
		System.out.println("geJWTExpiration() = " + thisConfig.geJWTExpiration());
		
		System.out.println("getAWSAccessKeyId() = " + thisConfig.getAWSAccessKeyId());
		System.out.println("getAWSSecretAccessKey() = " + thisConfig.getAWSSecretAccessKey());
		
		System.out.println("getS3Bucket() = " + thisConfig.getS3Bucket());
		System.out.println("getS3Region() = " + thisConfig.getS3Region());
		
		System.out.println("getImgPrefixClientProfile() = " + thisConfig.getImgPrefixClientProfile());
		System.out.println("getImgProfileSize() = " + thisConfig.getImgProfileSize());
	}
}