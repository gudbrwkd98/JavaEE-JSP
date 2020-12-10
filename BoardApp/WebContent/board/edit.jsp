<%@page import="board.model.NoticeDAO"%>
<%@page import="board.model.Notice"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="db.DBManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>

<%@ include file="/inc/lib.jsp" %>

<%
	request.setCharacterEncoding("utf-8");//한국어, 중국어, 아랍어 전세계 모든 언어 깨지지않음
	NoticeDAO noticeDAO = new NoticeDAO();

	String author = request.getParameter("author"); //작성자
	String title = request.getParameter("title");//제목
	String content = request.getParameter("content");//내용

	int notice_id = Integer.parseInt(request.getParameter("notice_id"));

	Notice notice = new Notice();
	notice.setAuthor(author);
	notice.setTitle(title);
	notice.setContent(content);
	notice.setNotice_id(notice_id);
	//등록
	int result = noticeDAO.edit(notice); //vo,dto 
	if(result == 0){
		out.print(getMsgBack("실패"));

		}else{
		out.print(getMsgURL("성공","/board/list.jsp"));
		}
	
%>

<%



	//select 
/*	String sql="update notice set title = ?,author = ?,content= ? where notice_id = ?";
	pstmt=con.prepareStatement(sql); //쿼리준비
	pstmt.setString(1,title);
	pstmt.setString(2,author);
	pstmt.setString(3,content);
	pstmt.setInt(4,notice_id);

		int result = pstmt.executeUpdate();
		if(result==0){
		
		out.print(getMsgBack("실패"));

		}else{
		out.print(getMsgURL("성공","/board/list.jsp"));
		}
	
	db에 연동에 사용된 모든 객체 닫기 
	if(pstmt!=null){
		pstmt.close();
	}
	if(con!=null){
		con.close();
	}
	*/


	%>
	