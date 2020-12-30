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
	
	//init�� ������ �����ֱ⿡�� ���� �����ڿ� ���� ������ �ν��Ͻ��� �����ϸ� �̿� ���ÿ� �ʱ�ȭ �޼���� 
	//ȣ��ȴ�.. 
	@Override
	public void init(ServletConfig config) throws ServletException {
		//getRealPath�� jsp�� ���尴ü�� application �� ���� ������ ���� application ���尴ü���� ������
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

	// get or post ������� ��� ��û�� �̸޼��忡�� ó������
	public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf-8");
		//Ŭ���̾�Ʈ�� ��ȭ�� ���ϸ�? --> ��ȭ��� ��Ʈ�ѷ����� ����
		//System.out.println("���� ��û�� �޾Ҿ��");
		
		//Ŭ���̾�Ʈ�� �������� ���ϸ� ? 
	
		
		
		String uri = req.getRequestURI();
		
		Controller controller=null;
		
		String className = null;
		
//		if(uri.equals("/movie.do")) { //��ȭ�� ���ϸ�
//			//controller = (Controller) new movieController();
//			//5�ܰ� Ŭ���̾�Ʈ���� �˸´� ����� ���ش� 
//			//Ŭ���̾�Ʈ�� �Ͽ��� ������ url�� �������� ��������!! �������
//			//resp.sendRedirect("/movie/movie_result.jsp");
//			
//			className = "movie.controller.movieController";
//			
//		}else if(uri.equals("/blood.do")) {
//			//controller = (Controller)new BloodController();
//			//controller.excute(req, resp);
//			//Ŭ���̾�Ʈ�� �Ͽ��� ������ URL �� �������� ��������
//			//resp.sendRedirect("/blood/blood_result.jsp");
//			className = "blood.controller.BloodController";
//			
//			
//		}
		
		//if�� ��ſ� ������Ƽ�� ��ü�� �̿��Ͽ� key �� value�� �̿�
		
		className = props.getProperty(uri);
		
		try {
			Class controllerClass = Class.forName(className);//Ŭ���� �ε�
			//�ν��Ͻ� ����
			controller = (Controller) controllerClass.newInstance();
			//�˸´� ���� ��ü���� �����Ų��
			controller.excute(req, resp); //2�ܰ�
			//5�ܰ� Ŭ���̾�Ʈ���� �˸´� ����� ���ش� 
			//Ŭ���̾�Ʈ�� �Ͽ��� ������ url�� �������� ��������!! �������
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
	
	//���� �����ֱ� �޼��� �� ������ �Ҹ��ҋ� ȣ��Ǵ� �޼����� destroy()�� ��Ʈ�� ���� �ڿ���
	//�ݴ� ó���� ����
	
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
