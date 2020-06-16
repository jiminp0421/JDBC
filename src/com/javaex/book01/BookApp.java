package com.javaex.book01;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		
	BookDao bookDao = new BookDao();
	
	//등록
	bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
	bookDao.bookInsert("삼국지", "민음사", "2002-03-01", 1);
	bookDao.bookInsert("토지", "마로니에북스", "2012-08-15", 3);
	bookDao.bookInsert("유시민의 글쓰기 특강", "생각의길", "2015-04-01", 3);
	bookDao.bookInsert("순정만화", "재미주의", "2011-08-03", 5);
	bookDao.bookInsert("오직두사람", "문학동네", "2017-05-04", 6);
	bookDao.bookInsert("26년", "재미주의", "2012-02-04", 5);

	//수정
	bookDao.bookUpdate("수정-토지", "마로니에북스", "2020-06-16", 2, 3);
	//삭제
	bookDao.bookDelete(8);
	
	List<BookVo> bookList = bookDao.getBookList();
	
	System.out.println("==================================");
	for(BookVo vo: bookList) {
		System.out.println(vo.getBookId() + "," + vo.getTitle() + "," + vo.getPubs() + "," + vo.getPubDate() + "," + vo.getAuthorId());
		}
	System.out.println("==================================");
	
	}//main

}//class
