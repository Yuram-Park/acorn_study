package com.exam.domain;

public class Mp_File {
	
	private int FILE_NO;
	private String ORG_FILE_NAME;
	private int FILE_SIZE;
	
	public Mp_File () {}
	public int getFILE_NO() {
		return FILE_NO;
	}
	public void setFILE_NO(int fILE_NO) {
		FILE_NO = fILE_NO;
	}
	public String getORG_FILE_NAME() {
		return ORG_FILE_NAME;
	}
	public void setORG_FILE_NAME(String oRG_FILE_NAME) {
		ORG_FILE_NAME = oRG_FILE_NAME;
	}
	public int getFILE_SIZE() {
		return FILE_SIZE;
	}
	public void setFILE_SIZE(int fILE_SIZE) {
		FILE_SIZE = fILE_SIZE;
	}
	
	public Mp_File(int fILE_NO, String oRG_FILE_NAME, int fILE_SIZE) {
		super();
		FILE_NO = fILE_NO;
		ORG_FILE_NAME = oRG_FILE_NAME;
		FILE_SIZE = fILE_SIZE;
	}
	
}
