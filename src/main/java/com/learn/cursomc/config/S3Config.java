package com.learn.cursomc.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	@Autowired
	private ConfigProperties prop;
	
	private String app_aws_access_key_id;
	private String app_aws_secret_access_key;
	private String app_s3_region;
	
	private void init() throws IOException {
		app_aws_access_key_id = prop.getAppAWSAccessKeyId();
		app_aws_secret_access_key = prop.getAppAWSSecretAccessKey();
		app_s3_region = prop.getAppS3Region();
	}
	
	@Bean
	public AmazonS3 s3Client() throws IOException {
		init();
		
		BasicAWSCredentials awsCred = new BasicAWSCredentials(app_aws_access_key_id, app_aws_secret_access_key);
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(app_s3_region)).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}