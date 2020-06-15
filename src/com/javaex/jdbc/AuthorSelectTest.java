package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorSelectTest {

	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //결과가져오는 아이 select문이니까 삭제 안했음

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");
		    // 3. SQL문 준비 / 바인딩 / 실행 완성된 sql문을 가져와서 작성할 것.
			String query = "";
			query += "select author_id, "; //뒤를 무조건 한칸 띄어준다
			query += "		 author_name, ";
			query += "		 author_desc ";
			query += "from author";
			
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);//쿼리문만들기
			
			//실행
			rs = pstmt.executeQuery();//메소드를 이용해서 값을 뽑아줄것임.
			
		    // 4.결과처리 꼭 이해해야만한다
			while(rs.next()) {		//몇개일지몰라서 while문
				int author_id = rs.getInt("author_id");
				String author_name = rs.getString("author_name");
				String author_desc = rs.getString("author_desc");
				
				System.out.println(author_id + "\t" + author_name + "\t" + author_desc + "\t");
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
