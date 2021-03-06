package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsertTest {

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
		// ResultSet rs = null; 필요없음

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");
		    // 3. SQL문 준비 / 바인딩 / 실행
			//sql 준비 INSERT INTO book VALUES (seq_book_id.nextval, '우리들의 일그러진 영웅', '다림', '1998-02-22', 1 );
			
			String query = "INSERT INTO book VALUES (seq_book_id.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			
			//바인딩
			pstmt.setString(1, "26년"); 
			pstmt.setString(2, "재미주의");
			pstmt.setString(3, "2012-02-04");
			pstmt.setInt(4, 5);
			
			//실행
			int count = pstmt.executeUpdate();
			
			//결과처리
			System.out.println(count + "건 처리되었습니다.");
			
		    

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        /*if (rs != null) {
		            rs.close();
		        } 필요없음 */             
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
