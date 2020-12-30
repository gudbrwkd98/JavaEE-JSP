package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;
import com.model2.domain.Board;

public class EditController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Board board = new Board();
		board.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		int result = boardDAO.update(board);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");
		return mav;
	}

}
