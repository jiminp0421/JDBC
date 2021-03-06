package com.javaex.author04; 

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		
		//등록
		AuthorVo vo01 = new AuthorVo("이문열", "경북 영양"); //묶어버리고싶다 이렇게 에러뜨는 이유는 생성자가 없어서 ! 만들었더니 사라짐
		authorDao.authorInsert(vo01);
		AuthorVo vo02 = new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(vo02);
		AuthorVo vo03 = new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(vo03);
		AuthorVo vo04 = new AuthorVo("기안84", "기안동에서 산 84년생");
		authorDao.authorInsert(vo04);
		AuthorVo vo05 = new AuthorVo("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert(vo05);
		AuthorVo vo06 = new AuthorVo("김영하", "알쓸신잡");
		authorDao.authorInsert(vo06);

		/*authorId
		authorName
		authorDesc -->AuthorVo VO value object (한줄의 정보를 하나로 담을수있는 애)
		*/
		
		//수정
		//AuthorVo vo03 = new AuthorVo(2, "수정박경리", "수정-경남통영");
		//authorDao.authorUpdate(vo03);
		//authorDao.authorUpdate(2, "수정박경리", "수정-경남통영");
		
		//삭제
		//authorDao.authorDelete(2);
		
		
		
		List<AuthorVo> authorList = authorDao.getAuthorList();
		
		
		//출력 (리스트 형태로 줄거야)
		//AuthorVo vo 하나 담을 그릇 authorList 전체
		System.out.println("=========================");
		for(AuthorVo vo: authorList) {
			System.out.println(vo.getAuthorId() + "," + vo.getAuthorName() + "," + vo.getAuthorDesc());
		}
		System.out.println("=========================");
	}

}
