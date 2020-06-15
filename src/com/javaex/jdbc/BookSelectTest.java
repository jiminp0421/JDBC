package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectTest {

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
			query += "select book_id, "; //뒤를 무조건 한칸 띄어준다
			query += "		 title, ";
			query += "		 pubs, ";
			query += "		 pub_date, ";
			query += "		 author_id ";
			query += " from   book";
			
			System.out.println(query);
		    // 바인딩
			pstmt = conn.prepareStatement(query);
			//실행
			rs = pstmt.executeQuery();//메소드를 이용해서 값을 뽑아줄것임.
			
			// 4.결과처리 꼭 이해해야만한다
			while(rs.next()) {		//몇개일지몰라서 while문
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pub_date = rs.getString("pub_date");
				int author_id = rs.getInt("author_id");
						
				System.out.println(book_id + "\t" + title + "\t" + pubs + "\t" + pub_date + "\t"
						+ author_id + "\t");
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

		
		
		
		

	}

}
