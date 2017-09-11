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

public class ProlongBook extends JPanel implements ActionListener{
	private JButton back;
	private JTextField tf_classname;
	private JTextField tf_number;
	private JTextField tf_dateoff;
	private JLabel lb_number;
	private JLabel lb_classname;
	private JLabel lb_dateoff;
	private JButton btn_prolong;

	/**
	 * Create the panel.
	 */
	public ProlongBook() {
		setBackground(new Color(250, 240, 230));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		JLabel label = new JLabel("\u7EED\u501F\u7CFB\u7EDF");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);
		
		lb_classname = new JLabel("\u4E66\u5E93\u7C7B\u522B\u540D\u79F0\uFF1A");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(281, 216, 283, 55);
		add(lb_classname);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(554, 206, 526, 75);
		add(tf_classname);
		
		lb_number = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		lb_number.setFont(new Font("宋体", Font.BOLD, 35));
		lb_number.setBounds(281, 360, 283, 55);
		add(lb_number);
		
		lb_dateoff = new JLabel("\u7EED\u501F\u671F\u9650\uFF1A");
		lb_dateoff.setFont(new Font("宋体", Font.BOLD, 35));
		lb_dateoff.setBounds(281, 498, 283, 55);
		add(lb_dateoff);
		
		tf_number = new JTextField();
		tf_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(554, 350, 526, 75);
		add(tf_number);
		
		tf_dateoff = new JTextField();
		tf_dateoff.setFont(new Font("宋体", Font.BOLD, 35));
		tf_dateoff.setColumns(10);
		tf_dateoff.setBounds(554, 488, 526, 75);
		add(tf_dateoff);
		
		btn_prolong = new JButton("\u7EED\u501F");
		btn_prolong.setFont(new Font("宋体", Font.BOLD, 35));
		btn_prolong.setBounds(554, 661, 251, 80);
		add(btn_prolong);
		btn_prolong.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.ProlongtoUser();
		}else if(e.getSource() == btn_prolong) {
			
			String classname = tf_classname.getText();
			String number = tf_number.getText();
			String dateoff = tf_dateoff.getText();

			TableOperate.prolongBook_Update(classname, number, dateoff, Information.user);
			
			tf_classname.setText("");
			tf_number.setText("");
			tf_dateoff.setText("");
			
			MainInterface.ProlongtoUser();
			
		}
	}
}
