package com.littleheap.Manager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.littleheap.MainInterface;
import com.littleheap.Static.Information;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManagerInterface extends JPanel implements ActionListener{
	private JLabel label;
	private JButton back;
	private JButton btn_insertBook;
	private JButton btn_state;
	private JButton btn_newClass;
	private JButton btn_updateBook;
	private static JLabel lb_manager;

	/**
	 * Create the panel.
	 */
	public ManagerInterface() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		label = new JLabel("\u7BA1\u7406\u5458\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		btn_insertBook = new JButton("\u5F55\u5165\u65B0\u4E66");
		btn_insertBook.setFont(new Font("宋体", Font.BOLD, 40));
		btn_insertBook.setBounds(21, 241, 280, 505);
		add(btn_insertBook);
		btn_insertBook.addActionListener(this);
		
		btn_newClass = new JButton("\u8BBE\u7ACB\u65B0\u7C7B\u522B");
		btn_newClass.setFont(new Font("宋体", Font.BOLD, 40));
		btn_newClass.setBounds(347, 241, 280, 505);
		add(btn_newClass);
		btn_newClass.addActionListener(this);
		
		btn_updateBook = new JButton("\u66F4\u65B0\u4FE1\u606F");
		btn_updateBook.setFont(new Font("宋体", Font.BOLD, 40));
		btn_updateBook.setBounds(673, 241, 280, 505);
		add(btn_updateBook);
		btn_updateBook.addActionListener(this);
		
		btn_state = new JButton("\u9986\u85CF\u72B6\u6001");
		btn_state.setFont(new Font("宋体", Font.BOLD, 40));
		btn_state.setBounds(995, 241, 280, 505);
		add(btn_state);
		btn_state.addActionListener(this);
		
		lb_manager = new JLabel("New label");
		lb_manager.setHorizontalAlignment(SwingConstants.CENTER);
		lb_manager.setFont(new Font("宋体", Font.BOLD, 28));
		lb_manager.setBounds(954, 0, 348, 56);
		add(lb_manager);

	}

	//设置右上角当前管理员
	public static void setManager() {
		lb_manager.setText("当前管理员："+Information.manager);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.ManagertoMain();
		}else if(e.getSource() == btn_insertBook){
			MainInterface.ManagertoInsert();
		}else if(e.getSource() == btn_newClass) {
			MainInterface.ManagertoNewClass();
		}else if(e.getSource() == btn_updateBook) {
			MainInterface.ManagertoUpdate();
		}else if(e.getSource() == btn_state) {
			MainInterface.ManagertoState();
		}
		
	}
}
