/*
 * 	모든 하위 컨트롤러가 반드시 구현해야할 메서드를 정의한다!!
 * 
 * */
package com.model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
		//알맞는 비지니스 객체에 일시키기 
		public void execute(HttpServletRequest request , HttpServletResponse response)  throws ServletException, IOException;
		
		
		//알맞는 페이지 보여주기
		public String getResultView();
		
		//포워드할지말지 결정
		public boolean isForward();
}
