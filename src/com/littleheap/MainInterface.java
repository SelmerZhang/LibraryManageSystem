package com.littleheap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.widgets.Tree;

import com.littleheap.DataBase.GetConnection;
import com.littleheap.DataBase.SelectTable;
import com.littleheap.OtherInterface.InsertBook;
import com.littleheap.OtherInterface.ManagerInterface;

import java.awt.*;

public class MainInterface extends JFrame implements ActionListener{

	public static JPanel contentPane;
	public static ManagerInterface managerJPanel = new ManagerInterface();
	public static InsertBook insertJPanel = new InsertBook();
	private JTextField tf_user;
	private JTextField tf_password;
	private JLabel label_user;
	private JLabel label_password;
	private JRadioButton rb_customer;
	private JRadioButton rb_manager;
	private JButton btn_login;
	private JButton btn_register;
	private JButton btn_changePassword;
	private static boolean flage_manager = false;
	private static boolean flage_insert = false;
	private static boolean flage_newClass = false;
	private static boolean flage_update = false;
	private static boolean flage_state = false;
	private boolean flage = false;
	private static Container container;
	
	public MainInterface() {
		init();
	}
	
	//初始化窗口
	public void init() {
		
		container = getContentPane();
//		getContentPane().add(managerJPanel);
//		managerJPanel.setVisible(false);
		
		//初始化主界面
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 1300, 1000);
		setResizable(false); 
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
//		container.add(managerJPanel);/////////////////////////
//		managerJPanel.setVisible(false);
		
		container.add(contentPane);
		contentPane.setLayout(null);
		
		//账号输入框
		tf_user = new JTextField();
		tf_user.setFont(new Font("宋体", Font.BOLD, 35));
		tf_user.setBounds(443, 248, 526, 75);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		//密码输入框
		tf_password = new JTextField();
		tf_password.setFont(new Font("宋体", Font.BOLD, 35));
		tf_password.setColumns(10);
		tf_password.setBounds(443, 357, 526, 75);
		contentPane.add(tf_password);
		
		//用户名标签
		label_user = new JLabel("\u8D26\u53F7\uFF1A");
		label_user.setFont(new Font("宋体", Font.BOLD, 35));
		label_user.setBounds(318, 261, 116, 48);
		contentPane.add(label_user);
		
		//密码标签
		label_password = new JLabel("\u5BC6\u7801\uFF1A");
		label_password.setFont(new Font("宋体", Font.BOLD, 35));
		label_password.setBounds(318, 370, 116, 48);
		contentPane.add(label_password);
		
		//普通用户单选按钮
		rb_customer = new JRadioButton("\u666E\u901A\u7528\u6237");
		rb_customer.setSelected(true);
		rb_customer.setFont(new Font("宋体", Font.BOLD, 30));
		rb_customer.setBackground(Color.WHITE);
		rb_customer.setBounds(443, 515, 170, 37);
		contentPane.add(rb_customer);
		
		//管理人员单选按钮
		rb_manager = new JRadioButton("\u7BA1\u7406\u4EBA\u5458");
		rb_manager.setFont(new Font("宋体", Font.BOLD, 30));
		rb_manager.setBackground(Color.WHITE);
		rb_manager.setBounds(799, 515, 170, 37);
		contentPane.add(rb_manager);
		//将选项按钮添加到一个按钮组
		ButtonGroup bg=new ButtonGroup();// 初始化按钮组
		bg.add(rb_customer);// 普通用户加入按钮组
		bg.add(rb_manager);// 管理人员加入按钮组
		
		//登录按钮
		btn_login = new JButton("\u767B\u5F55");
		btn_login.setBackground(Color.LIGHT_GRAY);
		btn_login.setFont(new Font("宋体", Font.BOLD, 35));
		btn_login.setBounds(443, 634, 170, 48);
		contentPane.add(btn_login);
		
		btn_login.addActionListener(this);
		
		//注册按钮
		btn_register = new JButton("\u6CE8\u518C");
		btn_register.setFont(new Font("宋体", Font.BOLD, 35));
		btn_register.setBackground(Color.LIGHT_GRAY);
		btn_register.setBounds(799, 634, 170, 48);
		contentPane.add(btn_register);
		
		btn_register.addActionListener(this);
		
		//修改密码按钮
		btn_changePassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changePassword.setFont(new Font("宋体", Font.BOLD, 30));
		btn_changePassword.setBackground(Color.LIGHT_GRAY);
		btn_changePassword.setBounds(1011, 370, 170, 48);
		contentPane.add(btn_changePassword);
		
		btn_changePassword.addActionListener(this);
	}
	
	//切换窗口函数
	public static void MaintoManager() {
		if(!flage_manager) {
			contentPane.setVisible(false);//////////
			container.add(managerJPanel);///////////
			flage_manager = true;
		}else {
			contentPane.setVisible(false);
			managerJPanel.setVisible(true);
		}
	}
	
	public static void ManagertoMain() {
		managerJPanel.setVisible(false);
		contentPane.setVisible(true);
	}
	
	public static void ManagertoInsert() {
		if(!flage_insert) {
			managerJPanel.setVisible(false);
			container.add(insertJPanel);
			flage_insert = true;
		}else {
			managerJPanel.setVisible(false);
			insertJPanel.setVisible(true);
		}
	}
	
	public static void InserttoManager() {
		insertJPanel.setVisible(false);
		managerJPanel.setVisible(true);
	}
	
	//登录注册事件函数
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_login) {
			//点击登录按钮
			//判定用户名密码是否为空
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "用户名不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
			}else {
				//判定是用户还是管理员
				if(rb_customer.isSelected()) {
					//用户
					boolean isExist = SelectTable.isExist_Customer(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "欢迎使用", "用户登录成功", JOptionPane.OK_CANCEL_OPTION);
					}else {
						JOptionPane.showMessageDialog(null, "请输入正确的用户名密码", "用户登录失败", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//管理员
					boolean isExist = SelectTable.isExist_Manager(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "欢迎使用", "管理员登录成功", JOptionPane.OK_CANCEL_OPTION);
						MaintoManager();
					}else {
						JOptionPane.showMessageDialog(null, "请输入正确的用户名密码", "管理员登录失败", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}else if(e.getSource() == btn_register) {
			//点击注册按钮
			//判定用户名密码是否为空
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "用户名不能为空", "注册失败", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空", "注册失败", JOptionPane.ERROR_MESSAGE);
			}else {
				//判定是用户还是管理员
				if(rb_customer.isSelected()) {
					boolean isExist = SelectTable.isExist_Customer_user(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "该用户已经存在", "用户注册失败", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "欢迎！", "用户注册成功", JOptionPane.OK_CANCEL_OPTION);
						SelectTable.regist_Customer(tf_user.getText(),  tf_password.getText());
					}
				}else {
					boolean isExist = SelectTable.isExist_Manager_user(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "该管理员已经存在", "管理员注册失败", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "欢迎！", "管理员注册成功", JOptionPane.OK_CANCEL_OPTION);
						SelectTable.regist_Manager(tf_user.getText(),  tf_password.getText());
					}
				}
			}
		} else if(e.getSource() == btn_changePassword) {
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "用户名不能为空", "修改失败", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空", "修改失败", JOptionPane.ERROR_MESSAGE);
			}else {
				//判定是用户还是管理员
				if(rb_customer.isSelected()) {
					//用户
					boolean isExist = SelectTable.isExist_Customer(tf_user.getText(), tf_password.getText());
					if(isExist) {
						String newPassword = JOptionPane.showInputDialog("请输入新密码");
						if (!newPassword.equals("")) {
							SelectTable.changePassword_Customer(tf_user.getText(), tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "欢迎使用", "修改密码成功", JOptionPane.OK_CANCEL_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "密码不能为空", "修改密码失败", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "请输入正确的用户名密码", "修改密码失败", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//管理员
					boolean isExist = SelectTable.isExist_Manager(tf_user.getText(), tf_password.getText());
					if(isExist) {
						String newPassword = JOptionPane.showInputDialog("请输入新密码");
						if (!newPassword.equals("")) {
							SelectTable.changePassword_Manager(tf_user.getText(), tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "欢迎使用", "修改密码成功", JOptionPane.OK_CANCEL_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "密码不能为空", "修改密码失败", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "请输入正确的用户名密码", "修改密码失败", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}
	}
}


