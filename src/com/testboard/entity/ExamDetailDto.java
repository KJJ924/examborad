package com.testboard.entity;

import java.sql.Timestamp;

public class ExamDetailDto extends ExamBoardDto {
	private int bGroup;
	private int bStep;
	private int bIndent;
	
	public ExamDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public ExamDetailDto(int id, String title, Timestamp date, String hit, String content, String name, int bGroup,
			int bStep, int bIndent ,String fileName ,String ufilename) {
		super(id, title, date, hit, content, name ,fileName,ufilename);
		this.bGroup=bGroup;
		this.bStep=bStep;
		this.bIndent=bIndent;
		
	}


	public int getbGroup() {
		return bGroup;
	}


	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}


	public int getbStep() {
		return bStep;
	}


	public void setbStep(int bStep) {
		this.bStep = bStep;
	}


	public int getbIndent() {
		return bIndent;
	}


	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

	
}
