<%@page import="board.model.News"%>
<%@page import="board.model.NewsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
String news_id = request.getParameter("news_id");//파라미터 받기

NewsDAO dao = new NewsDAO();

if(dao.replace(Integer.parseInt(news_id)) != 0){
	out.print(getMsgURL("성공", "/news/list.jsp"));
}else{
	out.print(getMsgBack("실패"));
}

%>