
<%@page import="admin.model.Admin"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	String admin_id = "scott";
	String admin_pass = "1234";
	/*
		원래는 데이터베이스에서 조회를 해야하지만 추후 하기로 하고
		일단은 스트링으로 비교 해본다..
	*/
	String mid= request.getParameter("mid");
	String password = request.getParameter("password");
	
	Admin admin = new Admin();
	//아이디가 같고 비번까지 같다면
	if(mid.equals(admin_id) && password.equals(admin_pass)){
		
		admin.setMid(mid);
		admin.setPassword(password);
		//로그인 성공보상
		//js의 location.href 와 동일한 기능의 jsp 기능
		
		//jsp의 내장객체인 session 객체는 클라이언트가 신규접속이라고 생각할떄 새로운 session 인스턴스를 생성하고 
		//세션아이디도 생성하여 세션에 부여한다
		//이 세션은 클라이언트가 브라우저를  종료하지않거나 일정시간내에 재접속 을 할 경우 계속 사용할수 있다..
		//따라서 웹은 stateless 기반이지만 서버측 메모리에 생성된 세션을 이용하면 마치 연결이 유지된 것 처럼 보여질수 있다..
		//있다 주 용도) 로그인후 회원정보를 모든 페이지에서 사용할수 있는 기능. 장바구니 등에 사용..
		session.setAttribute("ad", admin);
		//System.out.print(session);
		response.sendRedirect("/admin/index.jsp");

	}else{
		//로그인 실패에 대한 오류
		out.print(getMsgBack("로그인 정보가 올바르지 않습니다"));
	}
%>