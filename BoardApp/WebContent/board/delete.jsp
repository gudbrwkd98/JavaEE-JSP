<%@page import="board.model.NoticeDAO"%>
<%@page import="board.model.Notice"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="db.DBManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="/inc/lib.jsp" %>
<%
	NoticeDAO noticeDAO = new NoticeDAO();


	int notice_id = Integer.parseInt(request.getParameter("notice_id"));
	
	Notice notice = new Notice();
	notice.setNotice_id(notice_id);
	//등록
	int result = noticeDAO.delete(notice); //vo,dto 
	if(result == 0){
		out.print(getMsgBack("실패"));

		}else{
		out.print(getMsgURL("성공","/board/list.jsp"));
		}

	%>