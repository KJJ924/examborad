package com.testboard.entity;

import java.sql.Timestamp;

public class ExamListDto extends ExamBoardDto {
	private String cmtCount;

	public ExamListDto() {
		// TODO Auto-generated constructor stub
	}
	public ExamListDto(int id, String title, Timestamp date, String hit, String name, String cmtcount) {
		super(id, title, date, hit, "", name);
		this.cmtCount =cmtcount;
	}
	public String getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(String cmtCount) {
		this.cmtCount = cmtCount;
	}
	
	
}
