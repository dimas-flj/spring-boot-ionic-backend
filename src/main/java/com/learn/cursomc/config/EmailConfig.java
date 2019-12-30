package com.learn.cursomc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.learn.cursomc.config.model.Email;

@Configuration
public class EmailConfig {
	@Autowired
	private AppProperties apps;
	
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		Email prop = apps.getEmail();
		
		System.out.println("prop.isAuth() = " + prop.isAuth());
		if (prop.isAuth()) {
			System.out.println("prop.getUserName() = " + prop.getUserName());
			javaMailSender.setUsername(prop.getUserName());
			System.out.println("prop.getPassword() = " + prop.getPassword());
			javaMailSender.setPassword(prop.getPassword());
		}
		
		Properties properties = new Properties();
		System.out.println("prop.getProtocol() = " + prop.getProtocol());
		properties.setProperty("mail.transport.protocol", prop.getProtocol());
		System.out.println("prop.isAuth() = " + prop.isAuth());
		properties.setProperty("mail.smtp.auth", Boolean.toString(prop.isAuth()));
		System.out.println("prop.isStarttlsEnable() = " + prop.isStarttlsEnable());
		properties.setProperty("mail.smtp.starttls.enable", Boolean.toString(prop.isStarttlsEnable()));
		System.out.println("prop.isDebug() = " + prop.isDebug());
		properties.setProperty("mail.debug", Boolean.toString(prop.isDebug()));
		System.out.println("prop.getHost() = " + prop.getHost());
		properties.setProperty("mail.smtp.host", prop.getHost());
		System.out.println("prop.getPort() = " + prop.getPort());
		properties.setProperty("mail.smtp.port", Integer.toString(prop.getPort()));
		System.out.println("prop.getTrust() = " + prop.getTrust());
		properties.setProperty("mail.smtp.ssl.trust", prop.getTrust());
		javaMailSender.setJavaMailProperties(properties);
		
		return javaMailSender;
	}
}