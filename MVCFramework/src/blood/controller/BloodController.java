/*
 * ������ jsp �� ����ϰ� �־��� ��Ʈ�ѷ��μ��� ������ ���� Ŭ�����κи� ��Ű��!
 * �׷��� jsp�� ������ �������� �Ǳ� ������ ���������� ��ü���� �����ϴ�!!
 * 
 * */

package blood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;

import blood.model.BloodAdvisor;

public class BloodController implements Controller{

	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String blood = request.getParameter("blood");
			BloodAdvisor advisor = new BloodAdvisor();
			String msg = advisor.getAdvice(blood);
			
			//����� ���� ����� �������� View �� ����ϹǷ� �� �������� ó���ϸ� �ȵȴ�!!
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			//Ŭ���̾�Ʈ�� �Ͽ��� ������ URL �� �������� ��������
			//response.sendRedirect("/blood/blood_result.jsp");
	}

	@Override
	public String getViewPage() {
		// TODO Auto-generated method stub
		return "/blood/blood_result.jsp";
	}
}
