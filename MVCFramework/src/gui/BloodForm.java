package gui;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import blood.model.BloodAdvisor;

public class BloodForm extends JFrame{
	Choice ch;
	JButton bt;
	BloodAdvisor advisor = new BloodAdvisor();
	
	public BloodForm() {
		ch = new Choice();
		bt = new JButton("정보확인");
		
		//add blood type
		ch.add("A형");
		ch.add("B형");
		ch.add("O형");
		ch.add("AB형");
		
		ch.setPreferredSize(new Dimension(120, 30));
		setLayout(new FlowLayout());
		add(ch);
		add(bt);
		
		bt.addActionListener((e)->{
			showResult();
		});
		
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void showResult(){
		String msg = advisor.getAdvice(ch.getSelectedItem());
		JOptionPane.showMessageDialog(this, msg);
	}
	public static void main(String[] args) {
		new BloodForm();
	}

}
