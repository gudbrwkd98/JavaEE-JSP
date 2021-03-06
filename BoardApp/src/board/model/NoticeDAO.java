package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import board.gui.BoardWrite;
import db.DBManager;

public class NoticeDAO {
	DBManager dbManager = new DBManager() ;
	
	public int regist(Notice notice) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		con = dbManager.getConnection();
		
		String sql = "insert into notice(author,title,content) values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getAuthor());
			pstmt.setString(2, notice.getTitle());
			pstmt.setString(3, notice.getContent());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		return result;
		
		
	}
	//모든 레코드 가져오기!!
	public ArrayList selectAll() {
		Connection con  =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Notice> arrayList  = new ArrayList<Notice>();
		String sql = "select * from notice order by notice_id desc";
		
		con = dbManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setAuthor(rs.getString("author"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				arrayList.add(notice);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		
		return arrayList;
		
	}
	
	//게시물 1건 가져오기(상세보기)
	public Notice select(int notice_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Notice notice= null;
		
		String sql="select * from notice where notice_id=?";
		
		con=dbManager.getConnection(); //접속객체 얻기 
		try {
			pstmt=con.prepareStatement(sql); //쿼리준비
			pstmt.setInt(1, notice_id); //바인드 변수값 지정
			rs=pstmt.executeQuery();
			if(rs.next()) {
				notice = new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setAuthor(rs.getString("author"));
				notice.setContent(rs.getString("content"));
			}
			
			//조회수 증가
			sql = "update notice set hit = hit+1 where notice_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return notice;
	}
	
	//게시물 1건 수정하기
	public int edit(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = 0;
		
		String sql="update notice set title = ?,author = ?,content= ? where notice_id = ?";
		con=dbManager.getConnection(); //접속객체 얻기 
		try {
			pstmt=con.prepareStatement(sql); //쿼리준비
			pstmt.setString(1,notice.getTitle());
			pstmt.setString(2,notice.getAuthor());
			pstmt.setString(3,notice.getContent());
			pstmt.setInt(4,notice.getNotice_id());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		
		return result;
	}
	
	//게시물 1건 삭제하기 
	public int delete(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = 0;
		
		String sql="delete from notice where notice_id = ?";
		con=dbManager.getConnection(); //접속객체 얻기 
		try {
			pstmt=con.prepareStatement(sql); //쿼리준비
			pstmt.setInt(1,notice.getNotice_id());

		    result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		
		return result;
	}
	
}
