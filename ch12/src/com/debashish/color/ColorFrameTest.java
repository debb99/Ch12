package com.debashish.color;

import javax.swing.JFrame;

public class ColorFrameTest {
	public static void main(String[] args) {
		ColorFrame myFrame = new ColorFrame("Colors");
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(600,600);
		myFrame.setVisible(true);
	}
}
