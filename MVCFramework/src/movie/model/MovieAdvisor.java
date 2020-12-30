package movie.model;

public class MovieAdvisor {
	public String getAdvisor(String movie) {
		String msg = null;
		
		if (movie.equals("미션임파서블5")) {
			msg = "미션임파서블5";
		} else if (movie.equals("스타워즈")) {
			msg = "스타워즈";
		} else if (movie.equals("존윅")) {
			msg = "존윅";
		} else if (movie.equals("분노의질주3")) {
			msg = "분노의질주3";
		}

		
		return msg;
	}
}
