package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsertTest {

	public static void main(String[] args) {
		//0. import java.sql.*;
		//1. JDBC 드라이버 (Oracle) 로딩
		//2. Connection 얻어오기
		//3. SQL문 준비 / 바인딩 / 실행
		// 4.결과처리
		//5. 자원정리

		// 0. import java.sql.*; --import 시키기  
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); //class new와 같다
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //@localhost: 포트번호, 아이피개념 sql 접속할때 필요한 값
			conn = DriverManager.getConnection(url, "webdb", "webdb"); //DriverManger import시키기 계정, 계정비번
			System.out.println("접속 성공");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			//작가, 타이틀 등을 넣고싶다. INSERT INTO author VALUES (seq_author_id.nextval, '이문열', '경북 영양' ); sql문을 String(문자열)으로 만들어주기
			//int count = pstmt.executeUpdate(); insert, update, delete(만 commit과 관계있음) 우리가 데이터를 주면  저장해주고 몇개 성공했다고 알려준다/ 몇 개 수정되었다고 말해준다/몇 개 삭제되었다고 알려준다
			
			//sql 준비
			
			String query = "INSERT INTO author VALUES (seq_author_id.nextval, ?, ?)"; //이문열 경북영양을 자바 변수로 넣어준다 ?로 넣어줌 (?뜻: 다른걸로 바꿔치기 할것임)
			pstmt = conn.prepareStatement(query); //쿼리를 문자열로 만들기
			
			
			//바인딩
			//pstmt.setString(1, "이문열"); //첫번째 ?: 이문열로 바꿔라 "INSERT INTO author VALUES (seq_author_id.nextval, ?(이부분), ?)" 순서중요
			//pstmt.setString(2, "경북 영양");//첫번째 ?: 이문열로 바꿔라 "INSERT INTO author VALUES (seq_author_id.nextval, ?, ?(이부분))" 순서중요 치환이 된상태
			//추가 해줄때 쓰고 지우
			pstmt.setString(1, "김영하"); 
			pstmt.setString(2, "알쓸신잡");
			
			//실행
			int count = pstmt.executeUpdate(); 
			
			//결과처리
			System.out.println(count + "건 처리되었습니다.");
			
			
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {            
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

	}

}
