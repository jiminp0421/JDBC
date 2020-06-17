package com.javaex.book03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	//필드
	private	String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	//생성자
	
	public BookDao() {
		
	}//생성자
	//g/s
	//메소드
	//일반메소드
	
	
	//북추가
	public void bookInsert(BookVo bookVo) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속성공");


			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " INSERT INTO book ";
			query += " VALUES (seq_book_id.nextval, ?, ?, ?, ? ) ";
			System.out.println(query);
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기
			
			pstmt.setString(1, bookVo.getTitle());// ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, bookVo.getPubs());// ?(물음표) 중 2번째, 순서중요
			pstmt.setString(3, bookVo.getPubDate());// ?(물음표) 중 3번째, 순서중요
			pstmt.setInt(4, bookVo.getAuthorId());// ?(물음표) 중 4번째, 순서중요
			
			int count = pstmt.executeUpdate(); // 쿼리문 실행
			
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

		}}//북추가
	
	//북수정
	public void bookUpdate(BookVo bookVo) {
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
			query +=" update book ";
			query +=" set title = ?,";
			query +="     pubs = ?,";
			query +="     pub_date = ?,";
			query +="     author_id = ?";
			query +=" where author_id = ?";

			
			
			pstmt = conn.prepareStatement(query); //쿼리로 만들기
			
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubs());
			pstmt.setString(3, bookVo.getPubDate());
			pstmt.setInt(4, bookVo.getAuthorId());
			pstmt.setInt(5, bookVo.getBookId());
			
			
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
		
	}//북수정
	
	//북삭제
	public void bookDelete(int bookId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "";
		    query += " DELETE book ";
		    query += " where book_id = ? ";
		    
		    pstmt = conn.prepareStatement(query);
		    
		    pstmt.setInt(1, bookId);
		    
			int count = pstmt.executeUpdate();
		    // 4.결과처리
			System.out.println(count + "건이 삭제되었습니다.");
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
		
	}//북삭제
	//북리스트
	
	
	public List<BookVo> getBookList() {
		List<BookVo> bookList = new ArrayList<BookVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속성공");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " select book_id, ";
			query += "        title, ";
			query += "        pubs, ";
			query += "        to_char(pub_date, 'YYYY-MM-DD') pub_date, ";
			query += "        author_id ";
			query += " from book ";
			System.out.println(query);

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				
				BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorId);
				bookList.add(bookVo);

					
				//System.out.println(bookId + "\t" + title + "\t" + pubs + "\t" + pubDate + "\t" + authorId);
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
		
		return bookList;
	}
	
	
	
	
	
	

}// class
