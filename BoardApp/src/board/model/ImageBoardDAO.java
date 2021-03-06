/*
 * ImageBoard 테이블에 대한 CRUD 만을 전담하는 DAO 정의
 * */

package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;

public class ImageBoardDAO {
	DBManager dbManager = new DBManager(); //ImageBoardDAO 인스턴스가 생성될떄 
	
	
	//create(insert)
	public int  insert(ImageBoard imageboard) {
		PreparedStatement pstmt = null;
		Connection con = null; 
		int result = 0 ;
		String sql = "insert into imageboard(author,title,content,filename) values(?,?,?,?)";
		con = dbManager.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, imageboard.getAuthor());
			pstmt.setString(2, imageboard.getTitle());
			pstmt.setString(3, imageboard.getContent());
			pstmt.setString(4, imageboard.getFilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		
		return result;
		
	}
	
	//selectALL()
	public ArrayList selectAll() {
		PreparedStatement pstmt = null;
		Connection con = null; 
		ResultSet rs = null;
		ArrayList<ImageBoard> list = new ArrayList<ImageBoard>();
		String sql = "select * from imageboard";
		
		con = dbManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ImageBoard vo = new ImageBoard();
				vo.setBoard_id(rs.getInt("board_id"));
				vo.setAuthor(rs.getString("author"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setFilename(rs.getString("filename"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		
		return list;
		
	}
	//select(one)
	public ImageBoard select(int board_id) {
		PreparedStatement pstmt = null;
		Connection con = null; 
		ResultSet rs = null;
		ImageBoard vo = null;
		String sql = "select * from imageboard where board_id = ?";
		
		con = dbManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ImageBoard();
				
				vo.setBoard_id(rs.getInt("board_id"));
				vo.setAuthor(rs.getString("author"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setFilename(rs.getString("filename"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setHit(rs.getInt("hit"));
				
				
			}
			
		sql = "update imageboard set hit = hit+1 where board_id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, board_id);
		pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return vo;
		
	}
	//update
	public int update(ImageBoard board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update imageboard set author=?, title=?,content=?,filename=? where board_id=?";
		int result=0;
		
		con=dbManager.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getAuthor());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFilename());
			pstmt.setInt(5, board.getBoard_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		return result;
	
	}
	
	//delete
	public int delete(int board_id) {
		PreparedStatement pstmt = null;
		Connection con = null; 
		int result = 0;
		String sql = "delete from imageboard where board_id = ?";
		
		con = dbManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,board_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		
		return result;
		
	}
}
