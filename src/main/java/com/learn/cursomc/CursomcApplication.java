package com.learn.cursomc;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

//Teste de upload sem endpoint
//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Teste de upload sem endpoint
//import com.learn.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
//	@Value("${app.mail.sender}") 
//	private String app_mail_sender;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Teste de upload sem endpoint
//	@Autowired
//	private S3Service s3Service;
	
	public void run(String... args) throws Exception {
		//Teste de upload sem endpoint
		//s3Service.uploadFile("C:\\Particular\\AULAS_UDEMY\\Material de apoio\\Capturar.JPG");
		
//		AppGlobalConfigurations gConfig = new AppGlobalConfigurations();
//		System.out.println("run() gConfig.getAws() = " + gConfig.getAws());
//		System.out.println("run() gConfig.getImg() = " + gConfig.getImg());
//		System.out.println("run() gConfig.getJwt() = " + gConfig.getJwt());
//		System.out.println("run() gConfig.getMail() = " + gConfig.getMail());
//		System.out.println("run() gConfig.getS3() = " + gConfig.getS3());
//		
//		System.out.println("app_mail_sender + " + app_mail_sender);
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
//		System.out.println("Date in new GMT: " + new Date().toString());
//		
//		AppGlobalConfigurations gConfig = new AppGlobalConfigurations();
//		System.out.println("init() gConfig.getAws() = " + gConfig.getAws());
//		System.out.println("init() gConfig.getImg() = " + gConfig.getImg());
//		System.out.println("init() gConfig.getJwt() = " + gConfig.getJwt());
//		System.out.println("init() gConfig.getMail() = " + gConfig.getMail());
//		System.out.println("init() gConfig.getS3() = " + gConfig.getS3());
//		
//		System.out.println("app_mail_sender + " + app_mail_sender);
	}
}