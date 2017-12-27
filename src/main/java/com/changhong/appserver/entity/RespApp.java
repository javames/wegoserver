package com.changhong.appserver.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class RespApp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private Object data;
	public RespApp(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	
}
