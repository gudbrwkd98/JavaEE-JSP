package common.web2.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web2.controller.Controller;

import common.web2.notice.model.NoticeDAO;

public class ListController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// �˸´� ������ü
		List list = noticeDAO.selectAll();
		
		//4�ܰ� ����и�
		HttpSession session = request.getSession();
		request.setAttribute("noticeList", list);
		
	}

	@Override
	public String getResultView() {
		// TODO Auto-generated method stub
		return "/view/notice/list";
	}

	@Override
	public boolean isForward() {
		// ������ִٸ�.. true ���ٸ� false
		return true;
	}

}
