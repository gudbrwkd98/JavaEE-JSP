package board.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import board.model.Notice;
import board.model.NoticeDAO;

public class BoardContent extends Page{
	JTextField t_author;
	JTextField t_title;
	JTextArea area;
	JScrollPane scroll;
	JButton bt_list,bt_edit,bt_del;
	Notice notice;
	NoticeDAO noticeDAO;
	
	public BoardContent(BoardMain boardMain) {
		super(boardMain);
		//생성
		t_author = new JTextField();
		t_title = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt_list = new JButton("목록으로");
		bt_edit = new JButton("수정");
		bt_del = new JButton("삭제");
		
	
		//스타일
		t_author.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10), 25));
		t_title.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10), 25));
		scroll.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10), 500));
		
		//조립 
		add(t_author);
		add(t_title);
		add(scroll);
		
		add(bt_list);
		add(bt_edit);
		add(bt_del);
		
		bt_list.addActionListener((e)->{
			boardMain.showPage(Pages.valueOf("BoardList").ordinal());
		});
		
		bt_edit.addActionListener((e)->{
			editData();
			BoardList boardList = (BoardList) boardMain.pageList[Pages.valueOf("BoardList").ordinal()];
			boardList.getList();
			boardList.table.updateUI();
			boardMain.showPage(Pages.valueOf("BoardList").ordinal());
		});
		
		bt_del.addActionListener((e)->{
			deleteData();
			BoardList boardList = (BoardList) boardMain.pageList[Pages.valueOf("BoardList").ordinal()];
			boardList.getList();
			boardList.table.updateUI();
			boardMain.showPage(Pages.valueOf("BoardList").ordinal());
		});
	}
	
	//컴포넌트에 데이터 채워넣기 
	public void setData(Notice notice) {
		this.notice = notice; //나중에 써먹기위해 보관
		t_author.setText(notice.getAuthor());
		t_title.setText(notice.getTitle());
		area.setText(notice.getContent());
	}
	
	public void editData() {
		noticeDAO = new NoticeDAO();
		this.notice.setTitle(t_title.getText());
		this.notice.setAuthor(t_author.getText());
		this.notice.setContent(area.getText());
		noticeDAO.edit(this.notice);
	}
	
	public void deleteData() {
		noticeDAO = new NoticeDAO();
		noticeDAO.delete(this.notice);
	}
	

}
