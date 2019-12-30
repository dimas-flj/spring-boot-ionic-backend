package com.learn.cursomc;

import java.io.IOException;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.cursomc.config.AppProperties;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private AppProperties apps;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		System.out.println(apps.getEmail());
	}
	
	@PostConstruct
	public void init() throws IOException {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	}
}