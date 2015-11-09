package com.debashish.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomFrame extends JFrame{
	public CustomFrame(String name) {
		super(name);
		panel = new JPanel(new BorderLayout());
		JPanel fieldPanel = new JPanel(new GridLayout(3, 2));
		fieldPanel.setPreferredSize(new Dimension(50, 50));
			JTextField redField = new JTextField(5);
			JTextField greenField = new JTextField(5);
			JTextField blueField = new JTextField(5);
		
			fieldPanel.add(new JLabel("Amount Red: ", SwingConstants.RIGHT)); fieldPanel.add(redField);
			fieldPanel.add(new JLabel("Amount Green: ", SwingConstants.RIGHT));  fieldPanel.add(greenField);
			fieldPanel.add(new JLabel("Amount Blue: ", SwingConstants.RIGHT));  fieldPanel.add(blueField);
		JPanel submitPanel = new JPanel(new GridLayout(2, 1));
			JButton submit = new JButton("Set Color");
			submitPanel.add(new JLabel("Values must be between 0 and 1", SwingConstants.CENTER));
			submitPanel.add(submit);
		
		panel.add(fieldPanel, BorderLayout.CENTER);
		panel.add(submitPanel, BorderLayout.SOUTH);
		
		add(panel);
		pack();
		//ADD CUSTOM FRAME CLASS
	}
	JPanel panel;
}
