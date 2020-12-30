package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;

public class DeleteController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = boardDAO.delete(Integer.parseInt(request.getParameter("board_id")));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");
		return mav;
	}

}
