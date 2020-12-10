<%@page import="board.model.CommentsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<% 
	String comments_id = request.getParameter("comments_id");
	CommentsDAO dao = new CommentsDAO();
	int result ;
	result = dao.delete(Integer.parseInt(comments_id));
	out.print(result);
%>