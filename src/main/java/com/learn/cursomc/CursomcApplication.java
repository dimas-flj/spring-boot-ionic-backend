package com.learn.cursomc;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Autowired
	private S3Service s3Service;
	
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Particular\\AULAS_UDEMY\\Material de apoio\\Capturar.JPG");
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		System.out.println("Date in new GMT: " + new Date().toString());
	}
}