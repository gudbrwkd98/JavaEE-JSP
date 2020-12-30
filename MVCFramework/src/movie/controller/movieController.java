package movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;

import movie.model.MovieAdvisor;

public class movieController implements Controller{

 

	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		String movie = req.getParameter("movie");
		//3단계 알맞는 로직객체에게 일을시킨다
		MovieAdvisor advisor = new MovieAdvisor();
		String msg = advisor.getAdvisor(movie);

		//4단계 결과가 있을때는 그결과를 저장 
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		
		//resp.sendRedirect("/movie/movie_result.jsp");

	}

	@Override
	public String getViewPage() {
		// TODO Auto-generated method stub
		return "/movie/movie_result.jsp";
	}
	
 

	 
}
