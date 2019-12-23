package com.learn.cursomc.config;

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
	private ConfigProperties config;
	
	private String access_key_id;
	private String secret_access_key;
	private String region;
	
	@Bean
	public AmazonS3 s3Client() {
		access_key_id = config.getAWSAccessKeyId();
		secret_access_key = config.getAWSSecretAccessKey();
		region = config.getS3Region();
		
		BasicAWSCredentials awsCred = new BasicAWSCredentials(access_key_id, secret_access_key);
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(region)).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}