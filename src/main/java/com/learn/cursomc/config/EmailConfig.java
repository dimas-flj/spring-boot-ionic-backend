package com.learn.cursomc.config;

import java.util.Properties;

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
    
	@Bean
	public JavaMailSender javaMailService() {
		/*
app.email.protocol=smtp
app.email.host=smtp.gmail.com
app.email.port=587
app.email.username=dimasflj@gmail.com
app.email.password=omninet03
app.email.auth=true
app.email.starttls-enable=true
app.email.debug=false
app.email.trust=*
		 */
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
//		if (email.isAuth()) {
			javaMailSender.setUsername("dimasflj@gmail.com");
			javaMailSender.setPassword("omninet03");
//		}
		
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		
		properties.setProperty("mail.smtp.auth", Boolean.toString(true));
		properties.setProperty("mail.smtp.starttls.enable", Boolean.toString(true));
		properties.setProperty("mail.debug", Boolean.toString(false));
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", Integer.toString(587));
		properties.setProperty("mail.smtp.ssl.trust", "*");
		javaMailSender.setJavaMailProperties(properties);
		
		return javaMailSender;
	}
}