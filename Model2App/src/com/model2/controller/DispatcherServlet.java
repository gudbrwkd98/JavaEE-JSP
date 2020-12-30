/*
 *	웹상의 모든 클라이언트의 요청을 받고 응답을 전담하는 컨트롤러 정의  
 * */

package com.model2.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DispatcherServlet extends HttpServlet{
	FileReader fis; //컨트롤러 매핑 설정파일을 읽기 위한 스트림
	JSONObject controllerMap ;
	JSONObject View;
	@Override
	public void init(ServletConfig config) throws ServletException {
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		String realPath = config.getServletContext().getRealPath(contextConfigLocation);
		System.out.println(realPath);
		try {
			fis = new FileReader(realPath);
			JSONParser jsonParser = new JSONParser();
			
			//파싱!
			JSONObject json = 	(JSONObject) jsonParser.parse(fis);
			
			//데이터에 접근
			controllerMap = (JSONObject) json.get("controller");
			View = (JSONObject) json.get("view");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doRequest(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doRequest(request, response);
	}
	
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//2단계 요청을 분석한다
		String uri = request.getRequestURI(); //클라이언트가 요청시 사용한 uri 자체가 요청의 구분값이 된다
		
		//if문을 대신할 구조화된 데이터를 선택하다 (XML,JSON,Properties)
		String controllerName = (String)controllerMap.get(uri);
		System.out.println("지금 들어온 요청을 처리할 클래스는 " + controllerName);
		
		//동생 하위컨트롤러의 이름을 알았으니 인스턴스를 만들고 excute(),getResultView 호출
			Class controllerClass = null;
			 Controller controller  = null;
		try {
			 controllerClass = Class.forName(controllerName); //String 즉 문자열로 지정한 클래스의 대한 실제 클래스 반환 
			 controller = (Controller) controllerClass.newInstance(); //하위 콘트롤러 인스턴스 생성
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		controller.execute(request, response); //3단계 업무
		//하위 컨트롤러부터 넘겨받은 뷰에 대한 정보를 이용하여 클라이언트에게 알맞는 뷰를 보여준다
		String resultView = (String) View.get(controller.getResultView());
		
		//응답시 sendRedirect 로 처리해야 할 경우가 있고 글작성후 리스트, 전혀 다른 페이지로 재접속을 시도하게할떄 
		
		//때로는 forwarding 처리해야 할 경우가 있다.. 데이터를 유지하고 싶을떄..
		
		if(controller.isForward()) {
			RequestDispatcher dis = request.getRequestDispatcher(resultView);
			dis.forward(request, response); //응답없이 서버상의 또다른 자원으로 요청을 전달 !!
		}else {
			response.sendRedirect(resultView);
		}
	}
	
	public void destroy() {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
