package com.learn.cursomc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.learn.cursomc.config.AppConfig.Email;

@Configuration
@PropertySource(
	{
		"classpath:/application.properties", 
		"classpath:/application-${spring.profiles.active}.properties"
	}
)
public class MailConfig {
	/*
    @Value("${app.email.protocol}")
    private String protocol;

    @Value("${app.email.host}")
    private String host;

    @Value("${app.email.port}")
    private int port;
    
	@Value("${app.email.username}")
	private String username;
	
	@Value("${app.email.password}")
	private String password;
	
	@Value("${app.email.auth}")
	private boolean auth;

    @Value("${app.email.starttls.enable}")
    private boolean starttls;

    @Value("${app.email.debug}")
    private boolean debug;

    @Value("${app.email.trust}")
    private String trust;
    */
	
    @Autowired
    private AppConfig prop;
    
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		Email email = prop.getEmail();
		
		if (email.isAuth()) {
			javaMailSender.setUsername(email.getUserName());
			javaMailSender.setPassword(email.getPassword());
		}
		
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", email.getProtocol());
		
		properties.setProperty("mail.smtp.auth", Boolean.toString(email.isAuth()));
		properties.setProperty("mail.smtp.starttls.enable", Boolean.toString(email.isStarttlsEnable()));
		properties.setProperty("mail.debug", Boolean.toString(email.isDebug()));
		properties.setProperty("mail.smtp.host", email.getHost());
		properties.setProperty("mail.smtp.port", Integer.toString(email.getPort()));
		properties.setProperty("mail.smtp.ssl.trust", email.getTrust());
		javaMailSender.setJavaMailProperties(properties);
		
		return javaMailSender;
	}
}