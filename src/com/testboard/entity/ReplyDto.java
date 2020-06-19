package com.testboard.entity;

public class ReplyDto {
	private int bGroup;
	private int bStep;
	private int bIndent;
	
public ReplyDto() {
	// TODO Auto-generated constructor stub
}
	public ReplyDto(int bGroup, int bStep, int bIndent) {
		super();
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
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
