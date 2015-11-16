package com.debashish.interest;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterestCalculatorFrame extends JFrame {
	public InterestCalculatorFrame(String name) {
		super(name);
		mainPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();
				gc.insets = new Insets(5, 5, 5, 5);
		southPanel = new JPanel(new GridLayout(2, 1));
		
		JTextField initField = new JTextField(FIELD_LENGTH);
		JTextField rateField = new JTextField(FIELD_LENGTH);
		JTextField yearField = new JTextField(FIELD_LENGTH);

		gc.gridx = 0;
		gc.gridy = 0;
			centerPanel.add(new JLabel("Initial Balance", SwingConstants.RIGHT), gc);
		gc.gridx = 1;
			centerPanel.add(initField, gc);
		gc.gridy = 1;
		gc.gridx = 0;
			centerPanel.add(new JLabel("Annual Rate", SwingConstants.RIGHT), gc);
		gc.gridx = 1;
			centerPanel.add(rateField, gc);
		gc.gridy = 2;
		gc.gridx = 0;
			centerPanel.add(new JLabel("Number of Years", SwingConstants.RIGHT), gc);
		gc.gridx = 1;
			centerPanel.add(yearField, gc);
		
		JPanel southTopPanel = new JPanel();
			JButton calcButton = new JButton("Calculate");
			JLabel amountLabel = new JLabel("Amount = ");
			JTextField outputField = new JTextField(FIELD_LENGTH);
				outputField.setEditable(false);
				
			southTopPanel.add(calcButton);
			southTopPanel.add(amountLabel);
			southTopPanel.add(outputField);
		JPanel southBottomPanel = new JPanel();
			String[] options = {"Simple Interest", "Compound Annually", "Compound Monthly"};
			comboBox = new JComboBox(options);
			
			southBottomPanel.add(comboBox);
		
		southPanel.add(southTopPanel);
		southPanel.add(southBottomPanel);
		
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
		pack();
	}
	
	private static final int FIELD_LENGTH = 10;
	private String popupString;
	private JComboBox comboBox;
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
}
