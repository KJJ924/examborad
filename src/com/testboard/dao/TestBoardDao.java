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
		String sql = "select *From member ORDER by day DESC";
		
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

	public ExamBoardDto getDetail(int pid) {
		ExamBoardDto dto= null;
		String sql = "select *from member where id=?";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1, pid);
			 rs= psmt.executeQuery();
			
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String title =rs.getString("title");
				Timestamp date = rs.getTimestamp("day");
				String hit =rs.getString("hit");
				String content =rs.getString("content");
				String name =rs.getString("name");
				 dto = new ExamBoardDto(id, title, date, hit, content, name);
				 System.out.println(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return dto;
	}

	public void setInsert(String name, String title, String content) {
		              //insert into member VALUES(BOARDID.NEXTVAL,'제목',sysdate,0,'내용','이름');
		String sql = "insert into member VALUES(BOARDID.NEXTVAL,?,sysdate,0,?,?)";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, title);
			 psmt.setString(2,content);
			 psmt.setString(3, name);
			 psmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
