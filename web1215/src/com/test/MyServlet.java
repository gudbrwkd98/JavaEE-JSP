/*
 * javaEE ���� ���� �� ���������� ����� ���ִ� Ŭ������ ������ �����̶� �Ѵ�..
 * */
package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����μ��� ������ ��û�� ������ �ִ� ? ����?
//������ httpservlet �� ��� �޴� �������� ���������� ����ɼ��ִ� Ŭ������ �������� �ȴ�!
public class MyServlet extends HttpServlet{
	
	//Ŭ���̾�Ʈ�� get ������� ��û�� �Ҷ� �׿�û�� ó���ϴ� �޼����̴�
	// httpservlet�� �޼���� ���� ��ӹ޾Ҵ� ������ �� ������ �츮�� �������̵� �ؼ� ��û�� ó������
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ���ڿ� ����
		PrintWriter out = resp.getWriter();
		out.print("<a href='#'>hi</a>");
	}
}
