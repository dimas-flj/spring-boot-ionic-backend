package com.learn.cursomc;

import java.io.IOException;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args) throws Exception {}
	
	@PostConstruct
	public void init() throws IOException {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	}
}