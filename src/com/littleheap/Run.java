package com.littleheap;

import java.awt.EventQueue;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//实例化主界面
					MainInterface frame = new MainInterface();
					//显示主界面
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
