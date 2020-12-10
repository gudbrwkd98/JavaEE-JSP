<%@page import="board.model.NewsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	//jsp문서에서만 사용가능한 서버측의 태그를 사용하기
	//사실상 자바의 코드이지만 코드량 단축시키기 위해 태그형식으로 지원한다
	//News news = new News(); 와 jsp:usebean 빈즈 태그 동일
	request.setCharacterEncoding("utf-8");

//<jsp:setProperty property="writer" name = "writer"/>
//<jsp:setProperty property="title" name = "title"/>
//<jsp:setProperty property="content" name = "content"/>
%>
<jsp:useBean id="news" class="board.model.News"/>


<jsp:setProperty property="*" name = "news"/>
<%
	NewsDAO dao = new NewsDAO();
	if(dao.insert(news) != 0){
		out.print(getMsgURL("성공", "/news/list.jsp"));
	}else{
		out.print(getMsgBack("실패"));
	}
%>