package com.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blood.controller.BloodController;
import movie.controller.movieController;
import movie.model.MovieAdvisor;

public class DispatcherServlet extends HttpServlet{
	Properties props;
	FileInputStream fis;
	
	//init은 서블릿의 생명주기에서 최초 접속자에 의해 톰켓이 인스턴스를 생성하며 이와 동시에 초기화 메서드로 
	//호출된다.. 
	@Override
	public void init(ServletConfig config) throws ServletException {
		//getRealPath는 jsp의 내장객체중 application 에 대한 정보를 갖는 application 내장객체에서 지원함
		ServletContext context = config.getServletContext();
		
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		
		String saveDir = context.getRealPath(contextConfigLocation);
		try {
			fis = new FileInputStream(saveDir);
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);

	}

	// get or post 상관없이 모든 요청을 이메서드에서 처리하자
	public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf-8");
		//클라이언트가 영화를 원하면? --> 영화담담 컨트롤러에게 전가
		//System.out.println("제가 요청을 받았어요");
		
		//클라이언트가 혈액형을 원하면 ? 
	
		
		
		String uri = req.getRequestURI();
		
		Controller controller=null;
		
		String className = null;
		
//		if(uri.equals("/movie.do")) { //영화를 원하면
//			//controller = (Controller) new movieController();
//			//5단계 클라이언트에게 알맞는 결과를 여준다 
//			//클라이언트로 하여금 지정한 url로 재접속을 유도하자!! 명령하자
//			//resp.sendRedirect("/movie/movie_result.jsp");
//			
//			className = "movie.controller.movieController";
//			
//		}else if(uri.equals("/blood.do")) {
//			//controller = (Controller)new BloodController();
//			//controller.excute(req, resp);
//			//클라이언트로 하여금 지정한 URL 로 재접속을 유도하자
//			//resp.sendRedirect("/blood/blood_result.jsp");
//			className = "blood.controller.BloodController";
//			
//			
//		}
		
		//if문 대신에 프로퍼티스 객체를 이용하여 key 와 value를 이용
		
		className = props.getProperty(uri);
		
		try {
			Class controllerClass = Class.forName(className);//클래스 로드
			//인스턴스 생성
			controller = (Controller) controllerClass.newInstance();
			//알맞는 로직 객체에게 실행시킨다
			controller.excute(req, resp); //2단계
			//5단계 클라이언트에게 알맞는 결과를 여준다 
			//클라이언트로 하여금 지정한 url로 재접속을 유도하자!! 명령하자
			resp.sendRedirect(controller.getViewPage());
			
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
		

	}
	
	//서블릿 생명주기 메서드 인 서블릿이 소멸할떄 호출되는 메서드인 destroy()에 스트림 등의 자원을
	//닫는 처리를 하자
	
	public void destory() {
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
