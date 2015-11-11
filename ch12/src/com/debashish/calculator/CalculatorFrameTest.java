package com.debashish.calculator;
import javax.swing.JFrame;

public class CalculatorFrameTest {
	public static void main(String[] args) {
		CalculatorFrame calcFrame = new CalculatorFrame("Calculator");
		calcFrame.setSize(425, 600);
		calcFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		calcFrame.setLocation(30, 30);
		calcFrame.setVisible(true);
	}
}
