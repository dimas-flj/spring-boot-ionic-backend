package com.learn.cursomc.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = -6496994423107793330L;
	
	private Integer status;
	private String msg;
	private String stant;
	
	public StandardError(Integer status, String msg, String stant) {
		this.status = status;
		this.msg = msg;
		this.stant = stant;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getStant() {
		return stant;
	}
	
	public void setStant(String stant) {
		this.stant = stant;
	}
}