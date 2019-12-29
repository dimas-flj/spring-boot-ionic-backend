package com.learn.cursomc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource(
	{
		"classpath:/application.properties", 
		"classpath:/application-${spring.profiles.active}.properties"
	}
)
public class MailConfig {
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
	
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		if (this.auth) {
			javaMailSender.setUsername(this.username);
			javaMailSender.setPassword(this.password);
		}
		
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", this.protocol);
		
		properties.setProperty("mail.smtp.auth", Boolean.toString(this.auth));
		properties.setProperty("mail.smtp.starttls.enable", Boolean.toString(this.starttls));
		properties.setProperty("mail.debug", Boolean.toString(this.debug));
		properties.setProperty("mail.smtp.host", this.host);
		properties.setProperty("mail.smtp.port", Integer.toString(this.port));
		properties.setProperty("mail.smtp.ssl.trust", this.trust);
		javaMailSender.setJavaMailProperties(properties);
		
		return javaMailSender;
	}
}