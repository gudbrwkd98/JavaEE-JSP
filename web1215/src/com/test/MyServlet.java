/*
 * javaEE 에서 오직 웹 서버에서만 실행될 수있는 클래스를 가리켜 서블릿이라 한다..
 * */
package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//현재로서는 웹상의 요청을 받을수 있다 ? 없다?
//하지만 httpservlet 을 상속 받는 순간부터 웹서버에서 실행될수있는 클래스인 서블릿으로 된다!
public class MyServlet extends HttpServlet{
	
	//클라이언트가 get 방식으로 요청을 할때 그요청을 처리하는 메서드이다
	// httpservlet의 메서드로 부터 상속받았다 하지만 그 내용은 우리가 오버라이드 해서 요청을 처리하자
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트에 문자열 전송
		PrintWriter out = resp.getWriter();
		out.print("<a href='#'>hi</a>");
	}
}
