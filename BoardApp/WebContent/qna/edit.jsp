<%@page import="board.model.QnADAO"%>
<%@page import="board.model.QnA"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<% 
	request.setCharacterEncoding("utf-8");
	int qna_id = Integer.parseInt(request.getParameter("qna_id"));
	String writer = request.getParameter("writer");
	String content =  request.getParameter("content");
	String title = request.getParameter("title");
	
	QnA qna = new QnA();
	qna.setQna_id(qna_id);
	qna.setWriter(writer);
	qna.setContent(content);
	qna.setTitle(title);
	
	QnADAO dao = new QnADAO();
	
	if(dao.update(qna)>=1){
		out.print(getMsgURL("성공", "/qna/list.jsp"));
	}else{
		out.print(getMsgBack("실패"));
	}
	

	
	

%>