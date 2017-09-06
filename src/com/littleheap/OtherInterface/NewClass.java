package com.littleheap.OtherInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import org.eclipse.swt.internal.win32.TF_DA_COLOR;

import com.littleheap.MainInterface;
import com.littleheap.DataBase.SelectTable;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NewClass extends JPanel implements ActionListener {
	private JLabel label;
	private JTextField tf_classnumber;
	private JTextField tf_classname;
	private JLabel lb_classnumber;
	private JLabel lb_classname;
	private JButton btn_submit;
	private JButton back;

	/**
	 * Create the panel.
	 */
	public NewClass() {
		setBackground(new Color(175, 238, 238));
		setLayout(null);
		
		label = new JLabel("\u65B0\u5EFA\u56FE\u4E66\u5E93");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(542, 20, 294, 105);
		add(label);
		
		lb_classnumber = new JLabel("\u5206\u7C7B\u7F16\u53F7\uFF1A");
		lb_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classnumber.setBounds(391, 260, 194, 55);
		add(lb_classnumber);
		
		tf_classnumber = new JTextField();
		tf_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classnumber.setColumns(10);
		tf_classnumber.setBounds(585, 250, 399, 75);
		add(tf_classnumber);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(585, 431, 399, 75);
		add(tf_classname);
		
		lb_classname = new JLabel("\u5206\u7C7B\u540D\u79F0\uFF1A");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(391, 441, 194, 55);
		add(lb_classname);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(585, 637, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.NewClasstoManager();
		}else if(e.getSource() == btn_submit){
			SelectTable.newClass(tf_classnumber.getText(), tf_classname.getText());
			tf_classnumber.setText("");
			tf_classname.setText("");
		}
	}
}
