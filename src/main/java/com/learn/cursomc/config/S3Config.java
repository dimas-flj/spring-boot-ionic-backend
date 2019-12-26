package com.learn.cursomc.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	@Value("${app_aws_access_key_id}")
	private String app_aws_access_key_id;
	@Value("${app_aws_secret_access_key}")
	private String app_aws_secret_access_key;
	@Value("${app_s3_region}")
	private String app_s3_region;
	
//	public S3Config() {
//		super();
//		
//		System.out.println("app_aws_access_key_id = " + app_aws_access_key_id);
//		System.out.println("app_aws_secret_access_key = " + app_aws_secret_access_key);
//		System.out.println("app_s3_region = " + app_s3_region);
////		app_aws_access_key_id = ConfigProperties.getInstance().getValue(app_aws_access_key_id, "app_aws_access_key_id");
////		app_aws_secret_access_key = ConfigProperties.getInstance().getValue(app_aws_secret_access_key, "app_aws_secret_access_key");
////		app_s3_region = ConfigProperties.getInstance().getValue(app_s3_region, "app_s3_region");
//	}
	
	@Bean
	public AmazonS3 s3Client() throws IOException {
		System.out.println("app_aws_access_key_id = " + app_aws_access_key_id);
		System.out.println("app_aws_secret_access_key = " + app_aws_secret_access_key);
		System.out.println("app_s3_region = " + app_s3_region);
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