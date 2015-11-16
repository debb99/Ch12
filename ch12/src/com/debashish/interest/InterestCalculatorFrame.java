package com.debashish.interest;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterestCalculatorFrame extends JFrame {
	public InterestCalculatorFrame(String name) {
		super(name);
		mainPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new GridLayout(3, 2));
		southPanel = new JPanel(new GridLayout(2, 1));
		
		JPanel southTopPanel = new JPanel();
			JButton calcButton = new JButton("Calculate");
			JLabel amountLabel = new JLabel("Amount = ");
			JTextField outputField = new JTextField(10);
				outputField.setEditable(false);
				
			southTopPanel.add(calcButton);
			southTopPanel.add(amountLabel);
			southTopPanel.add(outputField);
		JPanel southBottomPanel = new JPanel();
			String[] options = {"Simple Interest", "Compound Annually", "Compound Monthly"};
			comboBox = new JComboBox<Object>(options);
			
			southBottomPanel.add(comboBox);
		
		southPanel.add(southTopPanel);
		southPanel.add(southBottomPanel);
		
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
		pack();
	}
	
	JComboBox comboBox;
	JPanel mainPanel;
	JPanel centerPanel;
	JPanel southPanel;
}
