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
	@Bean
	public AmazonS3 s3Client() throws IOException {
		String AWS_ACCESS_KEY_ID = "AKIAZF2LVPEKETAKWLHH";
		String AWS_SECRET_ACCESS_KEY = "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";
		String S3_REGION = "sa-east-1";
		
		BasicAWSCredentials awsCred = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(S3_REGION)).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}