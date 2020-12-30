<%@ page contentType="text/html;charset=utf-8"%>
<%
	//메세지를 받아보자
	request.setCharacterEncoding("utf-8");
	String msg = request.getParameter("msg");
	
	//session 과  request는 거의 쌍둥이인데 단지 생명력 차이
	request.setAttribute("result", msg);
	
	
	//서버상의 또다른 jsp 에 요청을 전달해보자
	RequestDispatcher dis = request.getRequestDispatcher("/test/result.jsp");
	//포워딩 시작
	dis.forward(request, response);
	
	//response.sendRedirect("/test/result");

%>