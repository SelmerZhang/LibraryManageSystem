package com.littleheap.User;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.littleheap.MainInterface;
import com.littleheap.DataBase.TableOperate;
import com.littleheap.Static.Information;

import javax.swing.JTextField;

public class ReturnBook extends JPanel implements ActionListener{
	private JLabel label;
	private JButton back;
	private JTextField tf_classname;
	private JLabel lb_classname;
	private JButton btn_return;
	private JLabel lb_classnumber;
	private JTextField tf_number;
	private JLabel lb_today;
	private JTextField tf_today;

	/**
	 * Create the panel.
	 */
	public ReturnBook() {
		setBackground(new Color(250, 250, 210));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("\u8FD8\u4E66\u7CFB\u7EDF");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(529, 69, 294, 105);
		add(label);
		
		lb_classname = new JLabel("\u4E66\u5E93\u7C7B\u522B\u540D\u79F0\uFF1A");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(240, 302, 283, 55);
		add(lb_classname);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(503, 292, 526, 75);
		add(tf_classname);
		
		btn_return = new JButton("\u5F52\u8FD8");
		btn_return.setFont(new Font("宋体", Font.BOLD, 35));
		btn_return.setBounds(557, 764, 251, 80);
		add(btn_return);
		btn_return.addActionListener(this);
		
		lb_classnumber = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lb_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classnumber.setBounds(240, 454, 283, 55);
		add(lb_classnumber);
		
		tf_number = new JTextField();
		tf_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(503, 444, 526, 75);
		add(tf_number);
		
		lb_today = new JLabel("\u8FD8\u4E66\u65E5\u671F\uFF1A");
		lb_today.setFont(new Font("宋体", Font.BOLD, 35));
		lb_today.setBounds(240, 590, 283, 55);
		add(lb_today);
		
		tf_today = new JTextField();
		tf_today.setFont(new Font("宋体", Font.BOLD, 35));
		tf_today.setColumns(10);
		tf_today.setBounds(503, 580, 526, 75);
		add(tf_today);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.ReturentoUser();
		}else if(e.getSource() == btn_return) {
			
			String classname = tf_classname.getText();
			String number = tf_number.getText();
			String today = tf_today.getText();
			
			TableOperate.returnBook_Update(classname, number, Information.user, today);
			TableOperate.returnBook_Delete(number, Information.user);
			
			MainInterface.ReturentoUser();
			
		}
	}
}
