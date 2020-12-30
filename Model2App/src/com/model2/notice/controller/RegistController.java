/*
 * 글쓰기 요청을 처리하는 전담 컨트롤러
 * 
 * */

package com.model2.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.controller.Controller;
import com.model2.domain.Notice;
import com.model2.notice.model.NoticeDAO;

public class RegistController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3단계 알맞는 로직 객체에게 일 시킨다!!		
		//파라미터 vo 에 담기
		Notice notice = new Notice();
		
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
	
		int result = noticeDAO.insert(notice);
		//4.저장할것이있다면 저장 없다면 생략
		
		
		
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
