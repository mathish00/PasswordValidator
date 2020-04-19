package controller;

import java.awt.EventQueue;
import java.io.IOException;

import view.LogInFrame;

public class Run {

	
	public static void main(String[] args) {
		
		Controller c = new Controller();
		try {
			Functions.loadUsers(c);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrame frame = new LogInFrame(c);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
