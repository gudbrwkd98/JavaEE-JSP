<%@page import="board.model.NewsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="news" class="board.model.News"/>
<jsp:setProperty property="*" name="news"/>
<%
NewsDAO dao = new NewsDAO();
if(dao.update(news)!= 0){
	out.print(getMsgURL("성공", "/news/list.jsp"));
}else{
	out.print(getMsgBack("실패"));
}

%>