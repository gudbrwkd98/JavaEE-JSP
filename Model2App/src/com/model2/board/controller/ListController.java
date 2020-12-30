package com.model2.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;
import com.model2.domain.Board;

public class ListController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List list = boardDAO.selectAll();
		
		request.setAttribute("boardList", list);
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/board/list";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}
