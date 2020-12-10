<%@page import="board.model.QnADAO"%>
<%@page import="board.model.QnA"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	/*넘겨받은 파라미터를 이용하여 원글 등록!!
		또한 원글의 team 값을 곧바로 pk 값으로 update 
	*/
	
	//파라미터 받기
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String title  = request.getParameter("title");
	String content = request.getParameter("content");
	
	//VO 에 낱개로 된 파라미터 데이터 채워넣기
	QnA qna = new QnA();
	qna.setWriter(writer);
	qna.setTitle(title);
	qna.setContent(content);
	
	QnADAO dao  = new QnADAO();
	
	int result = dao.insert(qna);
	
	if(result == 0){
		out.print(getMsgBack("실패"));

		}else{
		out.print(getMsgURL("성공","/qna/list.jsp"));
	}
	
%>