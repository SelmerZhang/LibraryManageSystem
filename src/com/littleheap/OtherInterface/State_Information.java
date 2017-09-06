package com.littleheap.OtherInterface;

import javax.swing.JPanel;

import com.littleheap.MainInterface;
import com.littleheap.Static.Information;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class State_Information extends JPanel implements ActionListener {
	private JButton back;

	/**
	 * Create the panel.
	 */
	public State_Information() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("ËÎÌו", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.StateInfotoState();
		}
		
	}

}
