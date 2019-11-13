package com.lostself.hkspringboot.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
 
public class SysUser implements Serializable{

	private static final long serialVersionUID = 1L;

	//主键 : id 	
	private Long id; 
	
	//账号 : usercode 	
	private String usercode; 
	
	//姓名 : username 	
	private String username; 
	
	//密码 : password 	
	private String password; 
	
	//盐 : salt 	
	private String salt; 
	
	//账号是否锁定，1：锁定，0未锁定 : locked 	
	private String locked; 
	
	//省略getter,setter方法

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}
}
