/*
 * ��� ���� ��Ʈ�ѷ��� ����ų�� �ִ� �ֻ��� ��Ʈ�ѷ� Ŭ���� ����
 * 
 * 
 */
package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�߻�Ŭ������ ������ ������ ����Ŭ�������� �̹� �ٸ� ��ü�� ��ӹ޾������� �����Ƿ� ���߻�ӿ� ������ ������������ �������̽��� �ν� �� �����ϴ�!!
public interface Controller {
	
	
	//�˸´� ������ü�� �Ͻ�Ű�� 
	public void excute(HttpServletRequest req , HttpServletResponse resp)  throws ServletException, IOException;

	//� �並 ������� ���� 
	public String getViewPage();

}
