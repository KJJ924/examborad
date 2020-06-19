package com.testboard.entity;

import java.sql.Timestamp;

public class ExamListDto extends ExamBoardDto {
	private String cmtCount;
	private int bIndent;

	public ExamListDto() {
		// TODO Auto-generated constructor stub
	}
	public ExamListDto(int id, String title, Timestamp date, String hit, String name, String cmtcount, int bIndent ) {
		super(id, title, date, hit, "", name);
		this.cmtCount =cmtcount;
		this.bIndent= bIndent;
	}
	public String getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(String cmtCount) {
		this.cmtCount = cmtCount;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
	
}
