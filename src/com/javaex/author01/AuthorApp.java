package com.javaex.author01;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao(); //생성자 /메모리에 올려서 데이터에 값을 넣으면 올라가겠지
		
		//등록
		authorDao.authorInsert("이문열", "경북 영양");
		authorDao.authorInsert("박경리", "경상남도 통영");
		authorDao.authorInsert("유시민", "17대 국회의원");
		authorDao.authorInsert("기안84", "기안동에서 산 84년생");
		authorDao.authorInsert("유시민", "17대 국회의원");
		authorDao.authorInsert("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert("김영하", "알쓸신잡");
		
		
		/*authorId
		authorName
		authorDesc -->AuthorVo VO value object (한줄의 정보를 하나로 담을수있는 애)
		*/
		
		//수정
		authorDao.authorUpdate(2, "수정박경리", "수정-경남통영");
		
		//삭제
		//authorDao.authorDelete(2);
		
		
		
		List<AuthorVo> authorList = authorDao.getAuthorList();
		//System.out.println(authorList.get(1).getAuthorDesc());
		//출력 (리스트 형태로 줄거야)
		//AuthorVo vo 하나 담을 그릇 authorList 전체
		System.out.println("=========================");
		for(AuthorVo vo: authorList) {
			System.out.println(vo.getAuthorId() + "," + vo.getAuthorName() + "," + vo.getAuthorDesc());
		}
		System.out.println("=========================");
	}

}
