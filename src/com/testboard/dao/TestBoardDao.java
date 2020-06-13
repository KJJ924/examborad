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
import com.testboard.entity.CommentDto;
import com.testboard.entity.ExamBoardDto;
import com.testboard.entity.SingUpDto;

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
		uphit(pid);
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

	private void uphit(int pid) {
		String sql = "update member set hit=hit+1 where id=?";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1, pid);
			 psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public void Delete(int pid) {
		String sql = "DELETE member where id=?";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1, pid);
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

	public void modifyData(String title, String content, int pid) {
		
		String sql = "update member set title=?,content=? where id=?";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, title);
			 psmt.setString(2, content);
			 psmt.setInt(3, pid);
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

	public int login(String userId, String userPw) {
		int check = 0;
		String id = null;
		String pw = null;
		String sql = "select *from userInfo where id =?";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, userId);
			 rs = psmt.executeQuery();
			 if(rs.next()) {
				  id =rs.getString("id");
				  pw =rs.getString("pw");
			 }
			 if(id.equals(userId) && pw.equals(userPw)) {
				 check=1;
			 }else
				 check=0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return check;
	}

	public void insertUserInfo(String userId, String userPw) {
			String sql = "insert into userinfo values(?,?)";
			try {
				 psmt = conn.prepareStatement(sql);
				 psmt.setString(1, userId);
				 psmt.setString(2, userPw);
				 psmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	//댓글 목록가져오기
	public ArrayList<CommentDto> getComment(int pid) {
		
		ArrayList<CommentDto> dtos = new ArrayList<>();
		String sql = "select *from board_comment where comment_Pnum =?";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1, pid);
			 rs = psmt.executeQuery();
			 if(rs.next()) {
				int comment_num =rs.getInt("comment_num");
				int comment_pnum=rs.getInt("comment_pnum");
				String comment_userId=rs.getString("comment_userId");
				String comment_content=rs.getString("comment_content");
				Timestamp comment_date=rs.getTimestamp("comment_date"); 
				int comment_parent=rs.getInt("comment_parent");
		CommentDto dto = new CommentDto
				(comment_num, comment_pnum, comment_userId, comment_content, comment_date, comment_parent);
		dtos.add(dto);
			 }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtos;
	}
}
