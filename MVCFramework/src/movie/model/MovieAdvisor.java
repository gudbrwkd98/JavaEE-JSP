package movie.model;

public class MovieAdvisor {
	public String getAdvisor(String movie) {
		String msg = null;
		
		if (movie.equals("�̼����ļ���5")) {
			msg = "�̼����ļ���5";
		} else if (movie.equals("��Ÿ����")) {
			msg = "��Ÿ����";
		} else if (movie.equals("����")) {
			msg = "����";
		} else if (movie.equals("�г�������3")) {
			msg = "�г�������3";
		}

		
		return msg;
	}
}
