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
		BasicAWSCredentials awsCred = new BasicAWSCredentials("AKIAZF2LVPEKETAKWLHH", "tSB40jC6awtPcNqNWKZKAzLkRAyJdHp5ZNi2F/UZ");
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName("sa-east-1")).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}