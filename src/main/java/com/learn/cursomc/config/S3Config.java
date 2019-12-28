package com.learn.cursomc.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.learn.cursomc.utils.Util;

@Configuration
public class S3Config {
	@Value("${aws.access_key}")
	private String access_key;

	@Value("${aws.secret_access_key}")
	private String secret_access_key;
	
	@Value("${s3.region}")
	private String s3_region;
	
	@Autowired
	private Environment env;
	
	public String getAccessKey() {
		if (!Util.isValidString(access_key)) {
			access_key = env.getProperty("aws.access_key");
			System.out.println("access_key(Enviroment) = " + access_key);
		}
		else {
			System.out.println("access_key(@Value) = " + access_key);
		}
		return access_key;
	}
	
	public String getSecretAccessKey() {
		if (!Util.isValidString(secret_access_key)) {
			secret_access_key = env.getProperty("aws.secret_access_key");
			System.out.println("secret_access_key(Enviroment) = " + secret_access_key);
		}
		else {
			System.out.println("secret_access_key(@Value) = " + secret_access_key);
		}
		return secret_access_key;
	}
	
	public String getS3Region() {
		if (!Util.isValidString(s3_region)) {
			s3_region = env.getProperty("s3.region");
			System.out.println("s3_region(Enviroment) = " + s3_region);
		}
		else {
			System.out.println("s3_region(@Value) = " + s3_region);
		}
		return s3_region;
	}
	
	@Bean
	public AmazonS3 s3Client() throws IOException {
		BasicAWSCredentials awsCred = new BasicAWSCredentials(access_key, secret_access_key);
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(s3_region)).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}