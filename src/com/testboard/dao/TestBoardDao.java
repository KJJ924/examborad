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
import com.testboard.entity.ExamDetailDto;
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
				+ "(select * from member_view2 where "+filed+" like ? order by bGroup desc, bStep asc ,day desc) m)"
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
					int bIndent = rs.getInt("bIndent");
					ExamListDto dto = new ExamListDto(id, title, date, hit, name,cmtcount ,bIndent);
					list.add(dto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
		
	}
	

	public ExamDetailDto getDetail(int pid) {
		uphit(pid);
		ExamDetailDto dto= null;
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
				int bGroup = rs.getInt("bGroup");
				int bStep= rs.getInt("bStep");
				int bIndent=rs.getInt("bIndent");
				 dto = new ExamDetailDto(id, title, date, hit, content, name,bGroup, bStep, bIndent);
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
		String sql = "insert into member VALUES(BOARDID.NEXTVAL ,? , sysdate, 0, ?, ?, BOARDID.NEXTVAL, 0 ,0 )";
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
			
			 if(id==null) {
				 check=0;
			 }else if(id.equals(userId) && pw.equals(userPw)) { 
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
		String sql = "select *from board_comment where comment_Pnum =? order by comment_group desc, comment_step asc,comment_date asc";
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
				int comment_indent=rs.getInt("comment_indent");
		CommentDto dto = new CommentDto
				(comment_num, comment_pnum, comment_userId, comment_content, comment_date, comment_indent);
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
		
		String sql = "insert into board_comment VALUES(COMMENT_SEQ.NEXTVAL,?,?,?,sysdate,COMMENT_SEQ.NEXTVAL,0,0)";
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

	public int getCount(String filed, String query) {
		String sql ="select count(*) count from"
				+ "(select rownum num , m.* from "
				+ "(select *from member_view where "+filed+" like ? order by day desc)m )";
		int count =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			rs= psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
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

		
		return count;
	}

	public CommentDto selectComment(int comment_num) {
			String sql = "select *from board_comment where comment_num=?";
			CommentDto dto = null;
			try {
				psmt= conn.prepareStatement(sql);
				psmt.setInt(1, comment_num);
				rs= psmt.executeQuery();
				
				if(rs.next()) {
					String comment_content = rs.getString("comment_content");
					String comment_userId=rs.getString("comment_userid");
					int comment_group = rs.getInt("comment_group");
					int comment_step =rs.getInt("comment_step");
					int comment_indent=rs.getInt("comment_indent");
					int comment_pnum=rs.getInt("comment_pnum");
				
				 dto = new CommentDto(comment_num , comment_content ,comment_userId,comment_group,comment_step,comment_indent,comment_pnum);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
				rs.close();
				psmt.close();
				conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		
		return dto;
	}

	public void updateComment(String comment_content, int comment_num) {
		String sql = "update board_comment set comment_content=? where comment_num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, comment_content);
			psmt.setInt(2, comment_num);
			rs=psmt.executeQuery();
			
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
		
	}

	public void reply(String name, String title, String content, int bGroup, int bStep, int bIndent) {
		// TODO Auto-generated method stub
		String sql ="insert into member VALUES(BOARDID.NEXTVAL ,? , sysdate, 0, ?, ?, ?, ? ,? )";
		replyShape(bGroup,bStep);
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, title);
			 psmt.setString(2,content);
			 psmt.setString(3, name);
			 psmt.setInt(4, bGroup);
			 psmt.setInt(5, bStep+1);
			 psmt.setInt(6, bIndent+1);
			 
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

	private void replyShape(int bGroup, int bStep) {
		// TODO Auto-generated method stub
		String sql ="update member set bStep=bStep+1 where bGroup=? and bStep >?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, bGroup);
			psmt.setInt(2, bStep);
			psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public void commentReply(String content, int comment_pnum, int comment_group, int comment_step,
			int comment_indent, String userID) {
		
		replyCommentShape(comment_group, comment_step);
		String sql = "insert into board_comment VALUES(COMMENT_SEQ.NEXTVAL,?,?,?,sysdate,?,?,?)";
		try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1,comment_pnum);
			 psmt.setString(2,userID);
			 psmt.setString(3, content);
			 psmt.setInt(4, comment_group);
			 psmt.setInt(5, comment_step+1);
			 psmt.setInt(6, comment_indent+1);
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
	private void replyCommentShape(int comment_group, int comment_step) {
		// TODO Auto-generated method stub
		String sql ="update board_comment set comment_step=comment_step+1 where comment_group=? and comment_step >?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, comment_group);
			psmt.setInt(2, comment_step);
			psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	

	
}
