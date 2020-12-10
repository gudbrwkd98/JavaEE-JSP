package board.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import board.model.Notice;
import board.model.NoticeDAO;

public class BoardWrite extends Page{
	JTextField t_author;
	JTextField t_title;
	JTextArea area;
	JScrollPane scroll;
	JButton bt;
	NoticeDAO noticeDAO; //CRUD 전담 객체 보유 has a 
	
	
	public BoardWrite(BoardMain boardMain) {
		super(boardMain);
		
		//생성
		t_author = new JTextField();
		t_title = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt = new JButton("등록");
		noticeDAO = new NoticeDAO();
		//스타일
		t_author.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),25));
		t_title.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),25));
		scroll.setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()-10),500));
		
		//조립
		add(t_author);
		add(t_title);
		add(scroll);
		add(bt);
		
		//등록
		bt.addActionListener((e)->{
			//매개변수로 vo 전달
			Notice notice = new Notice();
			notice.setAuthor(t_author.getText());
			notice.setTitle(t_title.getText());
			notice.setContent(area.getText());
			int result = noticeDAO.regist(notice);
			if(result == 0) {
				JOptionPane.showMessageDialog(BoardWrite.this, "실패");
			}else {
				JOptionPane.showMessageDialog(BoardWrite.this, "성공");
				BoardList boardList = (BoardList) boardMain.pageList[Pages.valueOf("BoardList").ordinal()];
				boardList.getList();
				boardList.table.updateUI();
				boardMain.showPage(Pages.valueOf("BoardList").ordinal());
			}
		});
		
	}
	


}
