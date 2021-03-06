package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectAllTest {

	public static void main(String[] args) {
		//0. import java.sql.*;
		//1. JDBC 드라이버 (Oracle) 로딩
		//2. Connection 얻어오기
		//3. SQL문 준비 / 바인딩 / 실행
		//4.결과처리
		//5. 자원정리
		
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
			System.out.println("접속 성공");
		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += "select b.book_id, "; //뒤를 무조건 한칸 띄어준다
			query += "		 b.title, ";
			query += "		 b.pubs, ";
			query += "		 b.pub_date, ";
			query += "		 b.author_id, ";
			query += "		 a.author_name, ";
			query += "		 a.author_desc ";
			query += " from author a, book b";
			query += " where b.author_id = a.author_id";
			
			System.out.println(query);
			
			
		    // 바인딩
			pstmt = conn.prepareStatement(query);
			//실행
			rs = pstmt.executeQuery();//메소드를 이용해서 값을 뽑아줄것임.
			
			// 4.결과처리 꼭 이해해야만한다
			while(rs.next()) {		//몇개일지몰라서 while문
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");		
				String authorDesc = rs.getString("author_desc");
				
				System.out.println(bookId + "\t" + title + "\t" + pubs + "\t" + pubDate + "\t"
						+ authorId + "\t" + authorName + "\t" + authorDesc);
				}
			
			
			
		    // 4.결과처리

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

		

	}

}
