package com.testboard.entity;

import java.sql.Timestamp;

public class ExamBoardDto {
	private String id;
	private String title;
	private Timestamp date;
	private String hit;
	private String content;
	
	public ExamBoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ExamBoardDto(String id, String title, Timestamp date, String hit, String content) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.hit = hit;
		this.content = content;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
