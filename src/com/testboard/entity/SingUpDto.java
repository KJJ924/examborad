package com.testboard.entity;

public class SingUpDto {
	private String userId;
	private String userpw;
	
	
	public SingUpDto(String userId, String userpw) {
		this.userId = userId;
		this.userpw = userpw;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
