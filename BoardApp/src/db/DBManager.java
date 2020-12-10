
package db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/db1202?serverTimezone=UTC";
	String user="root";
	String password="1234";
	
	
	public Connection getConnection(){
		Connection con=null;
		try{
			Class.forName(driver); 
			System.out.println("");
			
			con=DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	
	public void release(Connection con){
		if(con!=null){
			try{
				con.close();
			}catch(SQLException e){
			}
		}
	}

	public void release(Connection con, PreparedStatement pstmt){ 
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
			}
		}
		if(con!=null){
			try{
				con.close();
			}catch(SQLException e){
			}
		}

	}
	public void release(Connection con, PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
			}
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
			}
		}
		if(con!=null){
			try{
				con.close();
			}catch(SQLException e){
			}
		}

	}
}