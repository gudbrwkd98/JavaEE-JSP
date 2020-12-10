package board.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import db.DBManager;

public class BoardMain extends JFrame{
	//����� ������ ����
	Page[] pageList = new Page[Pages.values().length]; //enum�� ��ϵ� ������ ��ŭ ����
	DBManager dbManager;
	public BoardMain() {
		dbManager = new DBManager();
		//������ ����
		pageList[0] = new BoardList(this);
		pageList[1] = new BoardWrite(this);
		pageList[2] = new BoardContent(this);
		
		setLayout(new FlowLayout());
		//������ ����
		for (Page page:pageList) {
			add(page);
			page.setVisible(false);
		}
		//����Ʈ�� �����ְ� ���� ������
		showPage(Pages.valueOf("BoardList").ordinal());
		
	
		
		setSize(900,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void showPage(int viewPage) { //�����ְ� ���� ������ �μ��� ����
		for (int i = 0; i < pageList.length; i++) {
			if(viewPage == i) {
				pageList[i].setVisible(true);
			}else {
				pageList[i].setVisible(false);
			}
		}
	}
	public static void main(String[] args) {
		new BoardMain();
	}

}
