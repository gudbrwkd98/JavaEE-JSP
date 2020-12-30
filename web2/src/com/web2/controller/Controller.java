package com.web2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//�˸��� ��ü�� �Ͻ�Ű�� 
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	
	//������ �����ֱ�
	public String getResultView();
	
	//���������� ���� ����
	public boolean isForward();
}
