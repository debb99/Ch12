package com.debashish.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JPanel fieldPanel = new JPanel(new GridBagLayout());
		//fieldPanel.setPreferredSize(new Dimension(400, 400));
		GridBagConstraints gc = new GridBagConstraints();
			int labelWidth = 10;
			JTextField redField = new JTextField("0", labelWidth);
			JTextField greenField = new JTextField("0", labelWidth);
			JTextField blueField = new JTextField("0", labelWidth);
			gc.insets = new Insets(10, 5, 10, 5);
			gc.gridx = 0;
			gc.gridy = 0;
			fieldPanel.add(new JLabel("Amount Red: "), gc);
			gc.gridy = 1;
			fieldPanel.add(new JLabel("Amount Green: "), gc);
			gc.gridy = 2;
			fieldPanel.add(new JLabel("Amount Blue: "), gc);

			gc.gridx = 1;
			gc.gridy = 0;
			fieldPanel.add(redField, gc);
			gc.gridy = 1;
			fieldPanel.add(greenField, gc);
			gc.gridy = 2;
			fieldPanel.add(blueField, gc);
			
		class bListen implements ActionListener       
		{          
			public void actionPerformed(ActionEvent event)          
			{
				Color myColor = new Color(
						Float.parseFloat(redField.getText()),
						Float.parseFloat(greenField.getText()),
						Float.parseFloat(blueField.getText()));
				System.out.println(myColor.toString());
			}
		}
			
		JPanel submitPanel = new JPanel(new GridLayout(2, 1));
		submitPanel.setPreferredSize(new Dimension(100, 100));
			JButton submit = new JButton("Set Color");
			submit.addActionListener(new bListen());
			submitPanel.add(new JLabel("Values must be between 0 and 1", SwingConstants.CENTER));
			submitPanel.add(submit);
		
		panel.add(fieldPanel, BorderLayout.CENTER);
		panel.add(submitPanel, BorderLayout.SOUTH);
		
		add(panel);
		pack();
	}
	JPanel panel;
}
