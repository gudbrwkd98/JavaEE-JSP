/*
 * �۾��� ��û�� ó���ϴ� ���� ��Ʈ�ѷ�
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
		// 3�ܰ� �˸´� ���� ��ü���� �� ��Ų��!!		
		//�Ķ���� vo �� ���
		Notice notice = new Notice();
		
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
	
		int result = noticeDAO.insert(notice);
		//4.�����Ұ����ִٸ� ���� ���ٸ� ����
		
		
		
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
