/*게시판 목록 페이지*/
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
	JButton bt; //글쓰기 폼 이동버튼
	BoardModel model;
	NoticeDAO noticeDAO;
	ArrayList<Notice> boardList; //추후 사용할 일이있을거 대비
	public BoardList(BoardMain boardMain) {
	 super(boardMain);
	 //생성
	 table = new JTable(model = new BoardModel());
	 scroll = new JScrollPane(table);
	 bt = new JButton("등록");
	 noticeDAO = new NoticeDAO();
	 //스타일
	 setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),(int) (this.getPreferredSize().getHeight()-100)));
	 scroll.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),500));

	 //조립
	 add(scroll);
	 add(bt);
	 
	 getList();
	 table.updateUI();
	 bt.addActionListener((e)->{
		 boardMain.showPage(Pages.valueOf("BoardWrite").ordinal());
	 });
	 
	 //테이블 중하나의 레코드를 선택하면 상세보기 보여주기!
	 table.addMouseListener(new MouseAdapter() {
		 @Override
		public void mouseReleased(MouseEvent e) {
			//상세보기로 가기전에 notice_id 를 추출..
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
	
	//DAO 이용 하여 데이터 가져오기!!
	public void getList() {
		this.boardList = noticeDAO.selectAll();
		model.list = this.boardList;
	}
}
