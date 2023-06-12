package com.memo.vo;

public class Memo {
	private int no;
	private String title;
	private String content;
	private String indate;

	public Memo() {}
		
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getIndate() {
		return indate;
	}
	
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "Memo [no=" + no + ", title=" + title + ", content=" + content + ", indate=" + indate + "]";
	}
	
}
