package com.greeting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿이란? 자바 클래스중 오직 웹서버에서만 해석 및 실행되어질수 있는 클래스
public class HelloServlet extends HttpServlet{
	
	//서블릿이 태어난 직후에 초기화 작업에 사용됨
	//또한 이메서드 는 tomcat 과 같은 웹컨테이너에 의해 호출된다.. 즉 서블릿의 생성 및 생명주기 메서드 
	//의 호출자는 바로 톰켓이다!!
	@Override
	public void init(ServletConfig config) throws ServletException {
		String msg = config.getInitParameter("msg");
		System.out.println("init() 호출시 넘겨받은 파라미터 정보는 " + msg);
		
		//jsp 내장객체 웹어플리케이션의 전역적 정보를 가진 객체..application
		ServletContext context = config.getServletContext(); //jsp 에서의 application 내장객체엿다!!
		System.out.println(context.getRealPath("/"));
	}
	
	//서블릿이 일단 생성된 후 초기화 까지 마치면 클라이언트 요청을 처리할 준비가 된것이며,
	//클라이언트 의 요청을 처리하는 메서드가 바로 service 메서드 이다..
	//서비스메서드가 요청을 처리하려면 클라이언트의 요청정보와 응답정보를 필요로한다
	//때문에 service() 메서드의 매개변수로 request, response 객체가 전달되어야 한다..(고양이 tomcat서버가 담당)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트가 전송한 요청정보중 파라미터를 끄집어 내서 출력한다
		String id= req.getParameter("id");
		
		//클라이언트에게 전송
		resp.setContentType("utf-8");
		PrintWriter out = resp.getWriter();
		out.print("당신이 전송한 파라미터는 " + id);
		
	}
	
	
	//서블릿이 소멸할때 호출되는 메서드
	//서블릿이 보유한 자원을 반납할때 등에사용(db닫음,스트림)
	@Override
	public void destroy() {
		System.out.println("저 죽어요..");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("hello servlet do!!");
	}
}
