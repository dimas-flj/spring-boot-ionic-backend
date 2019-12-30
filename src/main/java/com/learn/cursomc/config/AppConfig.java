package com.learn.cursomc.config;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Component
public class AppConfig {
	private String protocol;
	private String host;
	private int port;
	private String username;
	private String password;
	private boolean auth;
	private boolean starttlsEnable;
	private boolean debug;
	private String trust;
	
	public AppConfig(
		@Value("${app.email.protocol}") String protocol,
		@Value("${app.email.host}") String host,
		@Value("${app.email.port}") int port,
		@Value("${app.email.username}") String username,
		@Value("${app.email.password}") String password,
		@Value("${app.email.auth}") boolean auth,
		@Value("${app.email.starttls-enable}") boolean starttlsEnable,
		@Value("${app.email.debug}") boolean debug,
		@Value("${app.email.trust}") String trust
	) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.auth = auth;
		this.starttlsEnable = starttlsEnable;
		this.debug = debug;
		this.trust = trust;
	}
	
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