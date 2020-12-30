package com.springmvc.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/* �� Ŭ������ ��û�� ���������� ó���ϴ� ��Ʋ�ѷ� ���� ��� */
//@Controller
public class TestController implements Controller{
	
	
	//��� url ��û�� ó�������� �޼��� �������� �ۼ��ϴ� ����..
	//@RequestMapping(value="/hello")


	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//3�ܰ� �˸´� ���� ��ü�� ���� ��Ų��
		String msg = "�ȳ�";
		
		//4�ܰ� �����Ұ����ִٸ� request ��ü�� ����!
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		//���� ��Ʈ�ѷ��� � �������� ������� ������ ���������� ������
		mav.setViewName("test/result");
		//System.out.println(msg);
		return mav;
	}
}
