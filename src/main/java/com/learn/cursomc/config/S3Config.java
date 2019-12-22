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
	private AppGlobalConfigurations gConfig;
	
	@Bean
	public AmazonS3 s3Client() {
		BasicAWSCredentials awsCred = new BasicAWSCredentials(gConfig.getAws().getAccesskeyId(), gConfig.getAws().getSecretAccessKey());
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(gConfig.getS3().getRegion())).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		return s3Client;
	}
}