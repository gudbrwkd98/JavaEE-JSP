/*
 * �� Ŭ������ ���� ��Ʈ�ѷ��μ� ������ �����ؾ� �ϹǷ�
 * �ݵ�� controller �������̽��� �����ؾ��Ѵ�..
 * 
 * */
package com.model2.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.controller.Controller;

public class TestController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//3�ܰ�:
		String msg = "�׽�Ʈ �Դϴ�";
		
		//4�ܰ� ��� ����
		HttpSession session  = request.getSession();
		session.setAttribute("msg", msg);
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/test/result";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}

}
