package com.greeting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�����̶�? �ڹ� Ŭ������ ���� ������������ �ؼ� �� ����Ǿ����� �ִ� Ŭ����
public class HelloServlet extends HttpServlet{
	
	//������ �¾ ���Ŀ� �ʱ�ȭ �۾��� ����
	//���� �̸޼��� �� tomcat �� ���� �������̳ʿ� ���� ȣ��ȴ�.. �� ������ ���� �� �����ֱ� �޼��� 
	//�� ȣ���ڴ� �ٷ� �����̴�!!
	@Override
	public void init(ServletConfig config) throws ServletException {
		String msg = config.getInitParameter("msg");
		System.out.println("init() ȣ��� �Ѱܹ��� �Ķ���� ������ " + msg);
		
		//jsp ���尴ü �����ø����̼��� ������ ������ ���� ��ü..application
		ServletContext context = config.getServletContext(); //jsp ������ application ���尴ü����!!
		System.out.println(context.getRealPath("/"));
	}
	
	//������ �ϴ� ������ �� �ʱ�ȭ ���� ��ġ�� Ŭ���̾�Ʈ ��û�� ó���� �غ� �Ȱ��̸�,
	//Ŭ���̾�Ʈ �� ��û�� ó���ϴ� �޼��尡 �ٷ� service �޼��� �̴�..
	//���񽺸޼��尡 ��û�� ó���Ϸ��� Ŭ���̾�Ʈ�� ��û������ ���������� �ʿ���Ѵ�
	//������ service() �޼����� �Ű������� request, response ��ü�� ���޵Ǿ�� �Ѵ�..(����� tomcat������ ���)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ŭ���̾�Ʈ�� ������ ��û������ �Ķ���͸� ������ ���� ����Ѵ�
		String id= req.getParameter("id");
		
		//Ŭ���̾�Ʈ���� ����
		resp.setContentType("utf-8");
		PrintWriter out = resp.getWriter();
		out.print("����� ������ �Ķ���ʹ� " + id);
		
	}
	
	
	//������ �Ҹ��Ҷ� ȣ��Ǵ� �޼���
	//������ ������ �ڿ��� �ݳ��Ҷ� ����(db����,��Ʈ��)
	@Override
	public void destroy() {
		System.out.println("�� �׾��..");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("hello servlet do!!");
	}
}
