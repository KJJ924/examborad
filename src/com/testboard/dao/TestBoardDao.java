package com.testboard.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.testboard.connection.DbConnection;
import com.testboard.entity.ExamBoardDto;

public class TestBoardDao {
	private Connection conn;
	private Statement smt;
	private ResultSet rs;
	private PreparedStatement psmt;
	public TestBoardDao() {
		 try {
			conn=DbConnection.getInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ExamBoardDto> getlist(){
		List<ExamBoardDto> list = new ArrayList<ExamBoardDto>();
		String sql = "select*from member";
		
			try {
				smt=conn.createStatement();
				rs=smt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String title =rs.getString("title");
					Timestamp date = rs.getTimestamp("day");
					String hit =rs.getString("hit");
					String content =rs.getString("content");
					String name =rs.getString("name");
					ExamBoardDto dto = new ExamBoardDto(id, title, date, hit, content, name);
					list.add(dto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					smt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	
		
		return list;
		
	}
}
