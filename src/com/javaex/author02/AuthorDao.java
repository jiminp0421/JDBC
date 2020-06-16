package com.javaex.author02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	// 필드
	
	// 생성자

	public AuthorDao() {
	}
	
	// g/s

	// 메소드

	// 일반메소드

	// 작가 추가 authorDao.authorInsert("이문열", "경북 영양");
	public void authorInsert(AuthorVo authorVo) {
		// 0. import java.sql.*; --import 시키기
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class new와 같다
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // @localhost: 포트번호, 아이피개념 sql 접속할때 필요한 값
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // DriverManger import시키기 계정, 계정비번
			System.out.println("접속 성공");

			// 3. SQL문 준비 / 바인딩 / 실행
			
			// sql 준비

			String query = "INSERT INTO author VALUES (seq_author_id.nextval, ?, ?)"; // 이문열 경북영양을 자바 변수로 넣어준다 ?로 넣어줌
																						// (?뜻: 다른걸로 바꿔치기 할것임)
			pstmt = conn.prepareStatement(query); // 쿼리를 문자열로 만들기

			pstmt.setString(1, authorVo.getAuthorName()); //묶여져있기때문에 사용법이 바뀌었다.
			pstmt.setString(2, authorVo.getAuthorDesc());

			// 실행
			int count = pstmt.executeUpdate();

			// 결과처리
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

	// 작가 수정
	public void authorUpdate(AuthorVo authorVo) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속성공");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; //쿼리문 문자열만들기, ? 주의
			query +=" update author ";
			query +=" set author_name = ? , ";
			query +="     author_desc = ? ";
			query +=" where author_id = ? ";

			pstmt = conn.prepareStatement(query); //쿼리로 만들기
			
			pstmt.setString(1, authorVo.getAuthorName()); // ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, authorVo.getAuthorDesc()); // ?(물음표) 중 2번째, 순서중요
			pstmt.setInt(3, authorVo.getAuthorId()); // ?(물음표) 중 3번째, 순서중요

			int count = pstmt.executeUpdate();  //쿼리문 실행
			
		    // 4.결과처리
			System.out.println(count + "건 처리되었습니다.");
			
			
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
	
	// 작가 삭제
	public void authorDelete(int authorId) {
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
			String query = ""; //쿼리문 문자열만들기, ? 주의
			query +=" delete from author ";
			query +=" where author_id = ? ";
			pstmt = conn.prepareStatement(query); //쿼리로 만들기
			
			
			pstmt.setInt(1,authorId); //?(물음표) 중 1번째, 순서중요
			//아직까진 자바에서 실행 안되고있다
			
			int count = pstmt.executeUpdate();  //쿼리문 실행
			//실행됨
			
			//결과처리
			System.out.println(count + "건 처리되었습니다.");
			

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
	
	
	// 작가 리스트 List<AuthorVo> authorList이거만들어줄거야
	public List<AuthorVo> getAuthorList() { //배열이 준비되어있음 동그라미 준비해야해
		//리스트준비
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과가져오는 아이 select문이니까 삭제 안했음

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");
			// 3. SQL문 준비 / 바인딩 / 실행 완성된 sql문을 가져와서 작성할 것. 작가정보다가져와
			String query = "";
			query += "select author_id, "; // 뒤를 무조건 한칸 띄어준다
			query += "		 author_name, ";
			query += "		 author_desc ";
			query += "from author";

			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);// 진짜쿼리문

			// 실행
			rs = pstmt.executeQuery(); //표형태로올거임

			// 4.결과처리 꼭 이해해야만한다
			while (rs.next()) { //쓰고버리고만 했는데 리스트로 표현하고파 (아래주석막아놈) //동그라미 만들어주는곳
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				//리스트에 추가하는 코드 필요함
				AuthorVo authorVo = new AuthorVo(authorId,authorName,authorDesc);
				authorList.add(authorVo);
				//System.out.println(author_id + "\t" + author_name + "\t" + author_desc + "\t");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
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
			return authorList;
	}
}
