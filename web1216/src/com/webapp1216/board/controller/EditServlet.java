package com.webapp1216.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.Notice;
import com.webapp1216.board.model.NoticeDAO;

//���� ��û�� ó���ϴ� ��Ʈ�ѷ� 
public class EditServlet extends HttpServlet{
	NoticeDAO noticeDAO = new NoticeDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		int result = 0 ;
		//�Ķ���Ϳ� ���� ���ڵ� ó��
		request.setCharacterEncoding("utf-8");
		notice.setWriter(request.getParameter("writer"));
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		notice.setNotice_id(Integer.parseInt(request.getParameter("notice_id")));
		result = noticeDAO.update(notice);
		
		HttpSession session = request.getSession();
		if(result ==0) {
			session.setAttribute("msg", "������Ʈ ����");
			response.sendRedirect("/error/messages.jsp");
		}else {
			response.sendRedirect("/board/detail?notice_id="+notice.getNotice_id());
		}
		
		
		
	}
}
