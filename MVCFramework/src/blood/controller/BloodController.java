/*
 * 기존의 jsp 가 담당하고 있었던 컨트롤러로서의 업무를 현재 클래스로분리 시키자!
 * 그래야 jsp는 순수한 디자인이 되기 떄문에 유지보수시 교체까지 가능하다!!
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
			
			//결과에 대한 출력은 디자인인 View 가 담당하므로 이 서블릿에서 처리하면 안된다!!
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			//클라이언트로 하여금 지정한 URL 로 재접속을 유도하자
			//response.sendRedirect("/blood/blood_result.jsp");
	}

	@Override
	public String getViewPage() {
		// TODO Auto-generated method stub
		return "/blood/blood_result.jsp";
	}
}
