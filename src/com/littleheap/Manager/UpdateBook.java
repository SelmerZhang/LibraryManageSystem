package com.littleheap.Manager;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.littleheap.MainInterface;
import com.littleheap.DataBase.TableOperate;

import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateBook extends JPanel implements ActionListener {
	private JTextField tf_old_number;
	private JTextField tf_new_number;
	private JLabel update;
	private JTextField tf_new_classnumber;
	private JTextField tf_old_classname;
	private JTextField tf_new_name;
	private JTextField tf_new_classname;
	private JTextField tf_new_price;
	private JTextField tf_new_state;
	private JLabel lb_old_number;
	private JLabel lb_old_classname;
	private JLabel label;
	private JLabel lb_new_number;
	private JLabel lb_new_classnumber;
	private JLabel lb_new_name;
	private JLabel lb_new_classname;
	private JLabel lb_new_price;
	private JLabel lb_new_state;
	private JButton btn_submit;
	private JButton back;

	/**
	 * Create the panel.
	 */
	public UpdateBook() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		label = new JLabel("\u66F4\u65B0\u56FE\u4E66\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);
		
		lb_old_number = new JLabel("\u65E7\u7F16\u53F7\uFF1A");
		lb_old_number.setFont(new Font("宋体", Font.BOLD, 35));
		lb_old_number.setBounds(165, 127, 194, 55);
		add(lb_old_number);
		
		tf_old_number = new JTextField();
		tf_old_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_old_number.setColumns(10);
		tf_old_number.setBounds(298, 117, 252, 75);
		add(tf_old_number);
		
		tf_new_number = new JTextField();
		tf_new_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_new_number.setColumns(10);
		tf_new_number.setBounds(507, 274, 526, 75);
		add(tf_new_number);
		
		update = new JLabel("\u66F4\u65B0\u4FE1\u606F");
		update.setFont(new Font("宋体", Font.BOLD, 35));
		update.setBounds(607, 213, 157, 55);
		add(update);
		
		tf_new_classnumber = new JTextField();
		tf_new_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		tf_new_classnumber.setColumns(10);
		tf_new_classnumber.setBounds(507, 370, 526, 75);
		add(tf_new_classnumber);
		
		tf_old_classname = new JTextField();
		tf_old_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_old_classname.setColumns(10);
		tf_old_classname.setBounds(788, 117, 342, 75);
		add(tf_old_classname);
		
		lb_old_classname = new JLabel("\u65E7\u5206\u7C7B\u540D\u79F0\uFF1A");
		lb_old_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_old_classname.setBounds(570, 127, 222, 55);
		add(lb_old_classname);
		
		tf_new_name = new JTextField();
		tf_new_name.setFont(new Font("宋体", Font.BOLD, 35));
		tf_new_name.setColumns(10);
		tf_new_name.setBounds(507, 466, 526, 75);
		add(tf_new_name);
		
		tf_new_classname = new JTextField();
		tf_new_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_new_classname.setColumns(10);
		tf_new_classname.setBounds(507, 562, 526, 75);
		add(tf_new_classname);
		
		tf_new_price = new JTextField();
		tf_new_price.setFont(new Font("宋体", Font.BOLD, 35));
		tf_new_price.setColumns(10);
		tf_new_price.setBounds(507, 658, 526, 75);
		add(tf_new_price);
		
		tf_new_state = new JTextField();
		tf_new_state.setFont(new Font("宋体", Font.BOLD, 35));
		tf_new_state.setColumns(10);
		tf_new_state.setBounds(507, 754, 526, 75);
		add(tf_new_state);
		
		lb_new_number = new JLabel("\u65B0\u7F16\u53F7\uFF1A");
		lb_new_number.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_number.setBounds(285, 284, 194, 55);
		add(lb_new_number);
		
		lb_new_classnumber = new JLabel("\u65B0\u5206\u7C7B\u7F16\u53F7\uFF1A");
		lb_new_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_classnumber.setBounds(285, 380, 227, 55);
		add(lb_new_classnumber);
		
		lb_new_name = new JLabel("\u65B0\u4E66\u540D\uFF1A");
		lb_new_name.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_name.setBounds(285, 476, 194, 55);
		add(lb_new_name);
		
		lb_new_classname = new JLabel("\u65B0\u5206\u7C7B\u540D\u79F0\uFF1A");
		lb_new_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_classname.setBounds(285, 572, 227, 55);
		add(lb_new_classname);
		
		lb_new_price = new JLabel("\u65B0\u4EF7\u683C\uFF1A");
		lb_new_price.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_price.setBounds(285, 668, 227, 55);
		add(lb_new_price);
		
		lb_new_state = new JLabel("\u65B0\u72B6\u6001\uFF1A");
		lb_new_state.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_state.setBounds(285, 764, 232, 55);
		add(lb_new_state);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(570, 850, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			//点击返回按钮
			MainInterface.UpdatetoManager();
		}else if(e.getSource() == btn_submit) {
			//点击更新信息提交按钮
			//旧信息
			String old_number = tf_old_number.getText();
			String old_classname = tf_old_classname.getText();
			//新信息
			String number = tf_new_number.getText();
			String classnumber = tf_new_classnumber.getText();
			String name = tf_new_name.getText();
			String classname = tf_new_classname.getText();
			String price = tf_new_price.getText();
			String state = tf_new_state.getText();
			
			if(!TableOperate.search_bookstate(old_classname, old_number).equals("null")) {
				//删除旧书籍信息
				TableOperate.deleteBook(old_number, old_classname);
				//插入新书籍信息
				TableOperate.insertBook(number, classnumber, name, classname, price, state, "1");
				tf_old_classname.setText("");
				tf_old_number.setText("");
				tf_new_number.setText("");
				tf_new_classnumber.setText("");
				tf_new_name.setText("");
				tf_new_classname.setText("");
				tf_new_price.setText("");
				tf_new_state.setText("");
				JOptionPane.showMessageDialog(null, "成功", "更新信息成功", JOptionPane.OK_CANCEL_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "输入信息有误", "更新信息失败", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
