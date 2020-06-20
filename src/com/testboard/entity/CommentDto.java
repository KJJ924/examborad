package com.testboard.entity;

import java.sql.Timestamp;

public class CommentDto {
	private int comment_num;
	private int comment_pnum;
	private String comment_userId;
	private String comment_content;
	private Timestamp comment_date;
	private int comment_group;
	private int comment_step;
	private int comment_indent;
	
	
	public CommentDto(int comment_num, int comment_pnum, String comment_userId, String comment_content,
			Timestamp comment_date, int comment_indent) {
		this.comment_num = comment_num;
		this.comment_pnum = comment_pnum;
		this.comment_userId = comment_userId;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.comment_indent = comment_indent;
	}
	
	public CommentDto(int comment_num, String comment_content, String comment_userId, int comment_group,
			int comment_step, int comment_indent, int comment_pnum) {
		this.comment_num = comment_num;
		this.comment_content = comment_content;
		this.comment_userId = comment_userId;
		this.comment_group = comment_group;
		this.comment_step = comment_step;
		this.comment_indent = comment_indent;
		this.comment_pnum = comment_pnum;
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

	public int getComment_group() {
		return comment_group;
	}
	public void setComment_group(int comment_group) {
		this.comment_group = comment_group;
	}
	public int getComment_step() {
		return comment_step;
	}
	public void setComment_step(int comment_step) {
		this.comment_step = comment_step;
	}
	public int getComment_indent() {
		return comment_indent;
	}
	public void setComment_indent(int comment_indent) {
		this.comment_indent = comment_indent;
	}
	
}
