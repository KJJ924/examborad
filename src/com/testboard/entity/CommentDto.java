package com.testboard.entity;

import java.sql.Timestamp;

public class CommentDto {
	private int comment_num;
	private int comment_pnum;
	private String comment_userId;
	private String comment_content;
	private Timestamp comment_date;
	private int comment_parent;
	
	
	public CommentDto(int comment_num, int comment_pnum, String comment_userId, String comment_content,
			Timestamp comment_date, int comment_parent) {
		this.comment_num = comment_num;
		this.comment_pnum = comment_pnum;
		this.comment_userId = comment_userId;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.comment_parent = comment_parent;
	}
	public CommentDto(int comment_num, String comment_content, String comment_userId) {
		this.comment_num = comment_num;
		this.comment_content = comment_content;
		this.comment_userId = comment_userId;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getComment_pnum() {
		return comment_pnum;
	}
	public void setComment_pnum(int comment_pnum) {
		this.comment_pnum = comment_pnum;
	}
	public String getComment_userId() {
		return comment_userId;
	}
	public void setComment_userId(String comment_userId) {
		this.comment_userId = comment_userId;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public Timestamp getComment_date() {
		return comment_date;
	}
	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}
	public int getComment_parent() {
		return comment_parent;
	}
	public void setComment_parent(int comment_parent) {
		this.comment_parent = comment_parent;
	}
	
}
