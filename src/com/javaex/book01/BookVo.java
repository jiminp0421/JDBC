package com.javaex.book01;

public class BookVo {
	
	//필드
	private int bookId;
	private int authorId;
	private String title;
	private String pubs;
	private String pubDate;
	
	public BookVo(int bookId, int authorId, String title, String pubs, String pubDate) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}

	public BookVo(String title, String pubs, String pubDate, int authorId, int bookId) {
		super();
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
		this.bookId = bookId;
	}

	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	

}
