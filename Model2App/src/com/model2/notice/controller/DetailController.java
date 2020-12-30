package com.model2.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.controller.Controller;
import com.model2.domain.Notice;
import com.model2.notice.model.NoticeDAO;

public class DetailController implements Controller{
	NoticeDAO noticeDAO  = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3단계 알맞는 로직 객체에 일 시킨다
		Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		
		//4단계 저장할것이있으면 저장 아니면 생략
		request.setAttribute("notice", notice);
		
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/notice/detail";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}
