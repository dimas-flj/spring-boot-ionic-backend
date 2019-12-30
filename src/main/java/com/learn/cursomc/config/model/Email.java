package com.learn.cursomc.config.model;

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
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [protocol=");
		builder.append(protocol);
		builder.append(", host=");
		builder.append(host);
		builder.append(", port=");
		builder.append(port);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", auth=");
		builder.append(auth);
		builder.append(", starttlsEnable=");
		builder.append(starttlsEnable);
		builder.append(", debug=");
		builder.append(debug);
		builder.append(", trust=");
		builder.append(trust);
		builder.append("]");
		return builder.toString();
	}
}