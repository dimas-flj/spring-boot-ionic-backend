package com.learn.cursomc.config;

import java.io.IOException;
import java.util.Properties;

import com.learn.cursomc.utils.Util;

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
	
	private static AppConfig appConfig;
	private static Properties properties;
	
	private AppConfig() {
		try {
			properties = new Properties();
			
			properties.load(((Class<?>) this.getClass()).getResourceAsStream("app.properties"));
			
			this.setProtocol(properties.getProperty("app.email.protocol"));
			this.setHost(properties.getProperty("app.email.host"));
			this.setPort(Integer.parseInt(properties.getProperty("app.email.port")));
			this.setUserName(properties.getProperty("app.email.username"));
			this.setPassword(properties.getProperty("app.email.password"));
			this.setAuth(Boolean.parseBoolean(properties.getProperty("app.email.auth")));
			this.setStarttlsEnable(Boolean.parseBoolean(properties.getProperty("app.email.starttls")));
			this.setDebug(Boolean.parseBoolean(properties.getProperty("app.email.debug")));
			this.setTrust(properties.getProperty("app.email.trust"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static AppConfig getInstance() {
		if (Util.isNull(appConfig)) {
			appConfig = new AppConfig();
		}
		return appConfig;
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