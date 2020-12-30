package com.webapp1216.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp1216.board.model.Notice;
import com.webapp1216.board.model.NoticeDAO;

public class RegistServlet extends HttpServlet{
	NoticeDAO dao = new NoticeDAO();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��½�Ʈ��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Notice notice = new Notice();
		
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
	
		if(dao.insert(notice)!=0) {
			out.print("<script>");
			out.print("alert('����');");
			out.print("location.href='/board/regist_form.jsp';");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('����');");
			out.print("histroy.back();");
			out.print("</script>");
		}
		
	}
}
