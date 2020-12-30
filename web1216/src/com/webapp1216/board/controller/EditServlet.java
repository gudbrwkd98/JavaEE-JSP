package com.webapp1216.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.Notice;
import com.webapp1216.board.model.NoticeDAO;

//수정 요청을 처리하는 컨트롤러 
public class EditServlet extends HttpServlet{
	NoticeDAO noticeDAO = new NoticeDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		int result = 0 ;
		//파라미터에 대한 인코딩 처리
		request.setCharacterEncoding("utf-8");
		notice.setWriter(request.getParameter("writer"));
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		notice.setNotice_id(Integer.parseInt(request.getParameter("notice_id")));
		result = noticeDAO.update(notice);
		
		HttpSession session = request.getSession();
		if(result ==0) {
			session.setAttribute("msg", "업데이트 실패");
			response.sendRedirect("/error/messages.jsp");
		}else {
			response.sendRedirect("/board/detail?notice_id="+notice.getNotice_id());
		}
		
		
		
	}
}
