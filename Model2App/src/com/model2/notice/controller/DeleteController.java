package com.model2.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.controller.Controller;
import com.model2.notice.model.NoticeDAO;

public class DeleteController implements Controller{
	NoticeDAO NoticeDAO = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3´Ü°è
		NoticeDAO.delete(Integer.parseInt(request.getParameter("notice_id")));
		
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/notice/return";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}

}
