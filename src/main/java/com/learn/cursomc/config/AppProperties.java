package com.learn.cursomc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.learn.cursomc.config.model.Email;

@Component
@ConfigurationProperties("app")
public class AppProperties {
	private Email email;
	
	public Email getEmail() {
		return email;
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
}