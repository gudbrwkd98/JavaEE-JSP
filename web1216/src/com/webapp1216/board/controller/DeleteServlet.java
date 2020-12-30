package com.webapp1216.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.NoticeDAO;

public class DeleteServlet extends HttpServlet{
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_id = request.getParameter("notice_id");
		int result = noticeDAO.delete(Integer.parseInt(notice_id));
		
		//컨트롤러가 클라이언트가 보게될 메시지를 처리해야한다 ? 아니다?
		//alert() 등은 디자인이다
		HttpSession session = request.getSession();
		if(result ==0) {
			//실패 페이지를 보여준다 결국 에러에 대한 안내를 보여주는 페이지를 별도로 두고 그페이지를 보여준다
			session.setAttribute("msg", "글 삭제시 시스템 에러로 인하여 글 삭제가 실패하였습니다");
			response.sendRedirect("/error/message.jsp");
		}else {
			response.sendRedirect("/board/list");
		}
		
		
	}
}
