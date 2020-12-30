/*
 * javaEE���� ������ MVC ������ ������ ���߹���� ������ model2 ����̶� ���´´�.
 * Ư�� jsp�� �����ο� ���ǰ������Ƿ� 
 * 
 * */

package com.webapp1216.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Ŭ���̾�Ʈ�� ��� ��û�� ó���ϴ� ���� ����!
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.NoticeDAO;
public class ListServlet extends HttpServlet{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = noticeDAO.selectAll();
		//���� ������ ���??
		//����? Ŭ���̾�Ʈ�� ������ ���μ����� �����ʰų� ���� ���۳��� �������ҋ� �������� �޸𸮿�
		//����� ������ ����Ҽ� �ִ� ���..(���ο� ������ ��� ���ǰ�ü�� ���� �����ǰ� ���Ǿ��̵� ���Ӱ� �߱޵�)
		//jsp������ session ���尴ü�� �ڷ����� httpsession �̴�!!
		HttpSession session = request.getSession();
		session.setAttribute("noticeList", list); //���� ��ü�� ����!!
		response.sendRedirect("/board/list.jsp");
	}
}
