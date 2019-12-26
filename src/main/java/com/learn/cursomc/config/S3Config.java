package com.learn.cursomc.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	private static GlobalProperties prop = new GlobalProperties();
	
	@Bean
	public AmazonS3 s3Client() throws IOException {
		BasicAWSCredentials awsCred = new BasicAWSCredentials(prop.getAwsAccessKeyId(), prop.getAwsSecretAccessKey());
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(prop.getS3Region())).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}