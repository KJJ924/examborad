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
import com.testboard.entity.ExamListDto;
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
	
	public List<ExamListDto> getlist(){
		
		return getlist(0,"","title");
		
	}
	
    public List<ExamListDto> getlist(int page){
		
		return getlist(page,"","title");
		
	}
	public List<ExamListDto> getlist(int page,String query ,String filed){
		List<ExamListDto> list = new ArrayList<ExamListDto>();
		String sql = "select *from"
				+ "(select rownum num, m.* from "
				+ "(select * from member_view where "+filed+" like ? order by day desc) m)"
				+ "where num BETWEEN ? and ?";
			
			try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			psmt.setInt(2,1+(page-1)*10 );
			psmt.setInt(3, page*10);
			rs=psmt.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String title =rs.getString("title");
					Timestamp date = rs.getTimestamp("day");
					String hit =rs.getString("hit");
					String name =rs.getString("name");
					String cmtcount=rs.getString("comment_count");
					ExamListDto dto = new ExamListDto(id, title, date, hit, name,cmtcount);
					list.add(dto);
				}
				
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

	public int Delete(String pid, String commentid) {
		int check=0;
		String sql=null;
		if(pid==null || pid.equals("")) {
			sql = "DELETE board_comment where COMMENT_NUM=?";
		}else {
			 sql = "DELETE member where id=?";
		}
		System.out.println(sql);
		try {
			 psmt = conn.prepareStatement(sql);
			 if(pid==null || pid.equals("")) {
			 psmt.setString(1, commentid);
			 check=1;
			 }else {
			 psmt.setString(1, pid);
			 check=2;
			 }
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
	return check;
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
		String sql = "select *from board_comment where comment_Pnum =? order by comment_date asc";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1, pid);
			 rs = psmt.executeQuery();
			 while(rs.next()) {
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
	//댓글추가
	public void insertCommnet(String pageNumber, String userid, String content) {
		
		String sql = "insert into board_comment VALUES(COMMENT_SEQ.NEXTVAL,?,?,?,sysdate,0)";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1,pageNumber);
			 psmt.setString(2,userid);
			 psmt.setString(3, content);
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
