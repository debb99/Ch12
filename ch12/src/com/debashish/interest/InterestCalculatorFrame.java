package com.debashish.interest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			setMinimumSize(initField);
		JTextField rateField = new JTextField(FIELD_LENGTH);
			setMinimumSize(rateField);
		JTextField yearField = new JTextField(FIELD_LENGTH);
			setMinimumSize(yearField);
		
		//gc.weightx = .1;
		gc.fill = GridBagConstraints.HORIZONTAL;
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
				
		class bList implements ActionListener{
			float initBal = 0, rate = 0, years = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean proceed = true;
				try{
					initBal = Float.parseFloat(initField.getText());
					rate = Float.parseFloat(rateField.getText());
					years = Float.parseFloat(yearField.getText());
				} catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(mainPanel, "Please input valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
					proceed = false;
				}
				if(proceed){
					NumberFormat formatter = new DecimalFormat("$#0.00");
					switch(comboBox.getSelectedIndex()){
					case 0: outputField.setText(formatter.format(initBal + (initBal * rate * years))); break;
					case 1: outputField.setText(formatter.format(initBal * Math.pow(1 + rate, years))); break;
					case 2: outputField.setText(formatter.format(initBal * Math.pow(1 + rate / 12, years * 12))); break;
					default: break;
					}
				}
			}};
			
			calcButton.addActionListener(new bList());
		
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
	
	private static void setMinimumSize(final Component c) {
	    c.setMinimumSize(new Dimension(c
	        .getPreferredSize().width - 1,
	        c.getPreferredSize().height));
	}
	
	private double round(double n){
		return Math.round(n * 100) / 100;
	}
	
	private static final int FIELD_LENGTH = 10;
	private String popupString;
	private JComboBox<String> comboBox;
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
}
