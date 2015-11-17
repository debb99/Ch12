package com.debashish.interest;

import javax.swing.JFrame;

public class InterestCalculatorTest {
	public static void main(String[] args) {
		InterestCalculatorFrame intCalcFrame = new InterestCalculatorFrame("Interest Calculator");
		intCalcFrame.setSize(400, 200);
		intCalcFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		intCalcFrame.setLocationByPlatform(true);
		intCalcFrame.setVisible(true);
	}
}
