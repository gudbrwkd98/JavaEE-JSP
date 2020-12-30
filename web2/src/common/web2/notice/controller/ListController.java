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
		// 알맞는 로직객체
		List list = noticeDAO.selectAll();
		
		//4단계 결과분리
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
		// 결과가있다면.. true 없다면 false
		return true;
	}

}
