package com.model2.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;
import com.model2.domain.Board;
import com.model2.notice.model.NoticeDAO;

public class DetailController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Board board = boardDAO.select(Integer.parseInt(request.getParameter("board_id")));
			
			request.setAttribute("board", board);
		
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/board/detail";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}
