/*
 * dao만들기, vo사용
 */

package com.javaex.author03;

public class AuthorVo {

	//필드
	private int authorId; //작가코드
	private String authorName; //작가이름
	private String authorDesc; //작가설명
	
	//생성자
	public AuthorVo(String authorName, String authorDesc) {
		super();
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	
	
	public AuthorVo(int authorId, String authorName, String authorDesc) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	

	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	
	//메소드
	@Override
	public String toString() {
		return "AuthorVo [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
	
}
