package com.model2.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.comment.model.CommentDAO;
import com.model2.controller.Controller;
import com.model2.domain.Comment;

public class RegistController implements Controller{
	CommentDAO commentDAO = new CommentDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("msg"));
		System.out.println(request.getParameter("author"));
		
		//vo¿¡ ´ã±â
		Comment comment = new Comment();
		comment.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		comment.setMsg(request.getParameter("msg"));
		comment.setAuthor(request.getParameter("author"));
		
		int result = commentDAO.insert(comment);
		
		request.setAttribute("result", result);
		
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/comment/regist";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}
