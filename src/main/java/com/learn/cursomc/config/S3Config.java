package com.learn.cursomc.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.learn.cursomc.utils.Constantes;

@Configuration
public class S3Config {
	@Bean
	public AmazonS3 s3Client() throws IOException {
		BasicAWSCredentials awsCred = new BasicAWSCredentials(Constantes.AWS_ACCESS_KEY_ID, Constantes.AWS_SECRET_ACCESS_KEY);
		AmazonS3 s3Client = 
				AmazonS3ClientBuilder.
				standard().
				withRegion(Regions.fromName(Constantes.S3_REGION)).
				withCredentials(new AWSStaticCredentialsProvider(awsCred)).
				build();
		
		return s3Client;
	}
}