package com.web2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//알맞은 객체에 일시키기 
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	
	//페이지 보여주기
	public String getResultView();
	
	//포워드할지 말지 결정
	public boolean isForward();
}
