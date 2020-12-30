package com.model2.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;
import com.model2.domain.Board;

public class EditController implements Controller {
	BoardDAO boardDAO = new BoardDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_id = request.getParameter("board_id");
		String title= request.getParameter("title");
		String writer= request.getParameter("writer");
		String content = request.getParameter("content");
		Board board = new Board();
		board.setBoard_id(Integer.parseInt(board_id));
		board.setWriter(writer);
		board.setContent(content);
		board.setTitle(title);
		
		int result = boardDAO.update(board);
		
		request.setAttribute("result", result);
		request.setAttribute("board", board);
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/board/edit";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}
