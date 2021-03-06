package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;

public class NewsDAO {
	DBManager dbManager = new DBManager();

	public List selectAll() {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<News> list = new ArrayList<News>();

		StringBuilder sb = new StringBuilder();
		sb.append("select  n.news_id as news_id,n.writer as writer, title , count(comments_id) as cnt , n.hit as hit, n.regdate as regdate ");
		sb.append("from news n left outer join comments c ");
		sb.append("on n.news_id = c.news_id ");
		sb.append("group by n.news_id, title order by c.news_id desc");

		con = dbManager.getConnection();

		try {
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setWriter(rs.getString("writer"));
				news.setTitle(rs.getString("title"));
				news.setCnt(rs.getInt("cnt"));
				news.setHit(rs.getInt("hit"));
				news.setRegdate(rs.getString("regdate"));
				list.add(news);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.release(con, pstmt, rs);
		}
		return list;
	}

	public News select(int news_id) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		News news = new News();
		String sql = "select * from news where news_id = ?";
		con = dbManager.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				news.setNews_id(rs.getInt("news_id"));
				news.setWriter(rs.getString("writer"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setHit(rs.getInt("hit"));
				news.setRegdate(rs.getString("regdate"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.release(con, pstmt, rs);
		}

		return news;
	}

	public int insert(News news) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "insert into news(title,writer,content) values (?,?,?)";
		con = dbManager.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getWriter());
			pstmt.setString(3, news.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.release(con, pstmt);
		}

		return result;
	}

	public int update(News news) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "update news set title = ? , writer = ? , content = ? where news_id = ?";
		con = dbManager.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getWriter());
			pstmt.setString(3, news.getContent());
			pstmt.setInt(4, news.getNews_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}

	public int delete(int news_id) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "delete from news where news_id = ?";
		con = dbManager.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}

	// 게이물 지우지 않고 삭제된 게시물이라는 표시처리
	public int replace(int news_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update news set title='작성자에 의해 삭제된 게시물입니다',writer='',content='' where news_id = ?";

		con = dbManager.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
