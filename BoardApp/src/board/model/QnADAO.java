package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;

public class QnADAO {
	DBManager dbManager = new DBManager();
	
	//insert
	public int insert(QnA qna) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0 ;
		
		String sql = "insert into qna(writer,title,content) values (?,?,?)";
		
		try {
			con = dbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,qna.getWriter());
			pstmt.setString(2,qna.getTitle());
			pstmt.setString(3,qna.getContent());
			
			result = pstmt.executeUpdate();//실행
			
			//team 을 방금 들어간 레코드에 의해 발생한 pk 값으로 업데이트!!
			sql= "update qna set team=(select last_insert_id()) where qna_id = (select last_insert_id())";
			pstmt =  con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		
		return result;
	}
	
	//답변글
	public int reply(QnA qna) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		Connection con = null;
		
		con = dbManager.getConnection();
		
		
		try {
			con.setAutoCommit(false); //자동커밋 해제
			
			String sql = "update qna set ranks = ranks+1 where team = ? and ranks > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna.getTeam());
			pstmt.setInt(2, qna.getRank());
			result = pstmt.executeUpdate();
			
			
			sql = "insert into qna(writer,title,content,team,ranks,depth)";
			sql+=" values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getWriter());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getContent());
			pstmt.setInt(4, qna.getTeam());
			pstmt.setInt(5, qna.getRank()+1);//내본글 위치할 것이므로+1
			pstmt.setInt(6, qna.getDepth()+1);//내본글 답변이므로 +1;
			
			result = pstmt.executeUpdate();
			
			con.commit();//여기서 커밋 즉 둘다 에러나지않았을경우에만 커밋
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback(); //두쿼리문중 에러가 하나라도 발생하면 차라리 처음부터 없었던 일로하자
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				con.setAutoCommit(true);//원상복귀
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbManager.release(con, pstmt);
		}
		
		
		
		return result;
	}
	
	//selectAll
	public List  selectALL() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<QnA> list = new ArrayList<QnA>();
		
		String sql="select * from qna order by team desc, ranks asc";
		con=dbManager.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			while(rs.next()) {
				QnA qna = new QnA(); //레코드만큼 vo 생성해야 함!!
				qna.setQna_id(rs.getInt("qna_id"));
				qna.setWriter(rs.getString("writer"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setRegdate(rs.getString("regdate"));
				qna.setHit(rs.getInt("hit"));
				qna.setTeam(rs.getInt("team"));
				qna.setRank(rs.getInt("ranks"));
				qna.setDepth(rs.getInt("depth"));
				
				list.add(qna); //리스트에 추가하기!!
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return list;
	}
	
	
	//selectOne
	public QnA select(int qna_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		QnA qna = new QnA(); //레코드만큼 vo 생성해야 함!!
		String sql="select * from qna where qna_id =" + qna_id;
		con=dbManager.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				
				qna.setQna_id(rs.getInt("qna_id"));
				qna.setWriter(rs.getString("writer"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setRegdate(rs.getString("regdate"));
				qna.setHit(rs.getInt("hit"));
				qna.setTeam(rs.getInt("team"));
				qna.setRank(rs.getInt("ranks"));
				qna.setDepth(rs.getInt("depth"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return qna;
	}
	
	//update
	public int update(QnA qna) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "update qna set title = ?,writer= ?,content= ? where qna_id = ?";
		con = dbManager.getConnection();
		try {
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getWriter());
			pstmt.setString(3, qna.getContent());
			pstmt.setInt(4, qna.getQna_id());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		
		return result;
	}
	
	//delete 
	public int delete(){
		int result = 0 ;
		
		
		return result;
	}
}
