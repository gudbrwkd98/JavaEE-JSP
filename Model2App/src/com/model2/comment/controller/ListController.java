/*
 * 
 * 댓글 목록 요청을 처리하는 컨트롤러
 * 
 * */

package com.model2.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.comment.model.CommentDAO;
import com.model2.controller.Controller;

public class ListController implements Controller{
	CommentDAO commentDAO = new CommentDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String board_id = request.getParameter("board_id");
		List commentList = commentDAO.selectAll(Integer.parseInt(board_id));
		
		request.setAttribute("commentList", commentList);
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/comment/list";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}
