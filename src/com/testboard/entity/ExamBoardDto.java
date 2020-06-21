package com.testboard.entity;

import java.sql.Timestamp;

public class ExamBoardDto {
	private int id;
	private String title;
	private Timestamp date;
	private String hit;
	private String content;
	private String name;
	private String fileName;
	private String ufileName;


	public ExamBoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "ExamBoardDto [id=" + id + ", title=" + title + ", date=" + date + ", hit=" + hit + ", content="
				+ content + ", name=" + name + "]";
	}





	public ExamBoardDto(int id, String title, Timestamp date, String hit, String content, String name,String fileName ,String ufilename) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.hit = hit;
		this.content = content;
		this.name = name;
		this.fileName= fileName;
		this.ufileName=ufilename;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getUfileName() {
		return ufileName;
	}



	public void setUfileName(String ufileName) {
		this.ufileName = ufileName;
	}


	
}
