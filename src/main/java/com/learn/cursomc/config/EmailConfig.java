package com.learn.cursomc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@ConfigurationProperties(prefix = "app")
public class EmailConfig {
	private Email email = new Email();
	
	public Email getEmail() {
		return email;
	}
	
	public class Email {
		private String protocol;
		private String host;
		private int port;
		private String username;
		private String password;
		private boolean auth;
		private boolean starttlsEnable;
		private boolean debug;
		private String trust;
		
		public String getProtocol() {
			return protocol;
		}
		
		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}
		
		public String getHost() {
			return host;
		}
		
		public void setHost(String host) {
			this.host = host;
		}
		
		public int getPort() {
			return port;
		}
		
		public void setPort(int port) {
			this.port = port;
		}
		
		public String getUserName() {
			return username;
		}
		
		public void setUserName(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public boolean isAuth() {
			return auth;
		}
		
		public void setAuth(boolean auth) {
			this.auth = auth;
		}
		
		public boolean isStarttlsEnable() {
			return starttlsEnable;
		}
		
		public void setStarttlsEnable(boolean starttlsEnable) {
			this.starttlsEnable = starttlsEnable;
		}
		
		public boolean isDebug() {
			return debug;
		}
		
		public void setDebug(boolean debug) {
			this.debug = debug;
		}
		
		public String getTrust() {
			return trust;
		}
		
		public void setTrust(String trust) {
			this.trust = trust;
		}
	}
	
	@Autowired
	private AppConfig prop;
    
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
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