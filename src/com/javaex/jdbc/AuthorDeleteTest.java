package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDeleteTest {

	public static void main(String[] args) {
		//0. import java.sql.*;
		//1. JDBC 드라이버 (Oracle) 로딩
		//2. Connection 얻어오기
		//3. SQL문 준비 / 바인딩 / 실행
		//4.결과처리
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
					String query = ""; //쿼리문 문자열만들기, ? 주의
					query +=" delete from author ";
					query +=" where author_id = ? ";
					pstmt = conn.prepareStatement(query); //쿼리로 만들기
					
					
					pstmt.setInt(1,6);

					int count = pstmt.executeUpdate();  //쿼리문 실행
					
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

}
