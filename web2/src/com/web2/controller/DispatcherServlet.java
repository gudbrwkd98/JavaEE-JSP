package com.web2.controller;

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
		FileReader fis; //���������� �б������
		JSONObject controllerMap;
		JSONObject View;
		
		//�ʱ�ȭ
		@Override
		public void init(ServletConfig config) throws ServletException {
			String contextConfigLocation = config.getInitParameter("contextConfigLocation");
			String realPath = config.getServletContext().getRealPath(contextConfigLocation);
			System.out.println(realPath);
			try {
				fis = new FileReader(realPath);
				JSONParser jsonParser = new JSONParser();
				
				//�Ľ�!
				JSONObject json = 	(JSONObject) jsonParser.parse(fis);
				
				//�����Ϳ� ����
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
			
			String uri = request.getRequestURI();
			
			String controllerName = (String) controllerMap.get(uri);
			System.out.println("���� ���� ��û�� ó���� Ŭ������ " + controllerName);
			
			Class controllerClass = null;
			Controller controller = null;
			
			
			
			try {
				controllerClass = Class.forName(controllerName); //String �� ���ڿ��� ������ Ŭ����
				controller = (Controller) controllerClass.newInstance();//���� ��Ʈ�ѷ� �ν��Ͻ� ����
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			controller.execute(request, response);
			
			String resultView = (String) View.get(controller.getResultView());
			
			
			if(controller.isForward()) {
				RequestDispatcher dis = request.getRequestDispatcher(resultView);
				dis.forward(request, response); //������� �ٷ� ����
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
