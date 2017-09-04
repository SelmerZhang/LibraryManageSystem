package com.littleheap.OtherInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.littleheap.MainInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManagerInterface extends JPanel implements ActionListener{
	private JLabel label;
	private JButton back;

	/**
	 * Create the panel.
	 */
	public ManagerInterface() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		label = new JLabel("\u7BA1\u7406\u5458\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("ËÎÌו", Font.BOLD, 40));
		label.setBounds(529, 21, 294, 105);
		add(label);
		
		back = new JButton("\u8FD4\u56DE\u767B\u5F55\u754C\u9762");
		back.setFont(new Font("ËÎÌו", Font.PLAIN, 26));
		back.setBounds(0, 0, 214, 75);
		add(back);
		back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {

		}
		
	}

}
