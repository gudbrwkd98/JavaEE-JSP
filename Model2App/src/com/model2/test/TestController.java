/*
 * 이 클래스는 하위 컨트롤러로서 역할을 수행해야 하므로
 * 반드시 controller 인터페이스를 구현해야한다..
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
		//3단계:
		String msg = "테스트 입니다";
		
		//4단계 결과 저장
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
