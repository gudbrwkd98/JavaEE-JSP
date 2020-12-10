/*�Խ��� ��� ������*/
package board.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import board.model.Notice;
import board.model.NoticeDAO;

public class BoardList extends Page{
	JTable table;
	JScrollPane scroll;
	JButton bt; //�۾��� �� �̵���ư
	BoardModel model;
	NoticeDAO noticeDAO;
	ArrayList<Notice> boardList; //���� ����� ���������� ���
	public BoardList(BoardMain boardMain) {
	 super(boardMain);
	 //����
	 table = new JTable(model = new BoardModel());
	 scroll = new JScrollPane(table);
	 bt = new JButton("���");
	 noticeDAO = new NoticeDAO();
	 //��Ÿ��
	 setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),(int) (this.getPreferredSize().getHeight()-100)));
	 scroll.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),500));

	 //����
	 add(scroll);
	 add(bt);
	 
	 getList();
	 table.updateUI();
	 bt.addActionListener((e)->{
		 boardMain.showPage(Pages.valueOf("BoardWrite").ordinal());
	 });
	 
	 //���̺� ���ϳ��� ���ڵ带 �����ϸ� �󼼺��� �����ֱ�!
	 table.addMouseListener(new MouseAdapter() {
		 @Override
		public void mouseReleased(MouseEvent e) {
			//�󼼺���� �������� notice_id �� ����..
			int col = 0 ;
			int row = table.getSelectedRow();
		
			//Notice notice = noticeDAO.select(Integer.parseInt((String) table.getValueAt(row, col)));
			Notice notice = boardList.get(row);
			BoardContent boardContent = (BoardContent) boardMain.pageList[Pages.valueOf("BoardContent").ordinal()];
			boardContent.setData(notice);
			boardMain.showPage(Pages.valueOf("BoardContent").ordinal());
		}
	});
	 
	}
	
	//DAO �̿� �Ͽ� ������ ��������!!
	public void getList() {
		this.boardList = noticeDAO.selectAll();
		model.list = this.boardList;
	}
}