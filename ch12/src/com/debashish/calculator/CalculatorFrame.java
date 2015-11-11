package com.debashish.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class CalculatorFrame extends JFrame{
	public CalculatorFrame(String name){
		super(name);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("fx.png")));
		start = true;
		createControlPanel();
		
	}
	
	private void createControlPanel() {
		class clearListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				display.setText("");
				lastValue = 0;
				theOperator = "";
				start = true;
			}

			@Override
			public void mouseEntered(MouseEvent e){};

			@Override
			public void mouseExited(MouseEvent e){};

			@Override
			public void mousePressed(MouseEvent e){};

			@Override
			public void mouseReleased(MouseEvent e){};
		}
		
		JPanel scene = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
			buttonPanel.add(makeDigitButton("7"));
			buttonPanel.add(makeDigitButton("8"));
			buttonPanel.add(makeDigitButton("9"));
			buttonPanel.add(makeOperatorButton("/"));
			
			buttonPanel.add(makeDigitButton("4"));
			buttonPanel.add(makeDigitButton("5"));
			buttonPanel.add(makeDigitButton("6"));
			buttonPanel.add(makeOperatorButton("*"));
			
			buttonPanel.add(makeDigitButton("1"));
			buttonPanel.add(makeDigitButton("2"));
			buttonPanel.add(makeDigitButton("3"));
			buttonPanel.add(makeOperatorButton("-"));
			
			buttonPanel.add(makeDigitButton("0"));
			buttonPanel.add(makeDigitButton("."));
			buttonPanel.add(makeOperatorButton("="));
			buttonPanel.add(makeOperatorButton("+"));
			
		JPanel displayPanel = new JPanel(new GridLayout(1, 1));
			displayPanel.setPreferredSize(new Dimension(getWidth(), 100));
			display = new JTextField();
			display.setHorizontalAlignment(JTextField.RIGHT);
			display.setBackground(Color.BLACK);
			display.setForeground(MODIFIED_ORANGE);
			display.setEditable(false);
			display.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 60));
			display.setBorder(new EtchedBorder());
			display.addMouseListener(new clearListener());
			displayPanel.add(display);
		
		scene.add(buttonPanel, BorderLayout.CENTER);
		scene.add(displayPanel, BorderLayout.NORTH);
		
		
		add(scene);
		pack();
	}
	
	public JButton makeDigitButton(final String digit){
		class Listen implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(start){
					output("");
					display.setText(e.getActionCommand());
					start = false;
				} else {
					if(e.getActionCommand() == "."){
						if(!display.getText().contains(".")){
							display.setText(display.getText() + e.getActionCommand());
						}
					} else {
						display.setText(display.getText() + e.getActionCommand());
					}
					
				}
			}
		}
		JButton tempButton = new JButton(digit);
		tempButton.addActionListener(new Listen());
		tempButton.setSize(getWidth()/4, getWidth()/4);
		applyUniversalFont(tempButton);
		tempButton.setBackground(Color.BLACK);
		return tempButton;
	}
	
	public JButton makeOperatorButton(final String op){
		class Listen implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(!start){
					if(lastValue == 0){
						lastValue = displayVal();
						theOperator = e.getActionCommand();
						start = true;
					} else {
						if(e.getActionCommand() != "="){
							consecVal = 0;
							float newVal = eval(lastValue, displayVal(), theOperator);
							output(newVal);
							lastValue = newVal;
							theOperator = e.getActionCommand();
						} else {
							consecVal = displayVal();
							float newVal = eval(lastValue, consecVal, theOperator);
							output(newVal);
							lastValue = newVal;
						}
						start = true;
					}
				} else {
					if(!display.getText().isEmpty() && lastValue != 0 && e.getActionCommand() == "="){
						float newVal = eval(lastValue, consecVal, theOperator);
						lastValue = newVal;
						output(newVal);
					} else {
						theOperator = e.getActionCommand();
					}
				}
			}
		}
		JButton tempButton = new JButton(op);
		tempButton.addActionListener(new Listen());
		applyUniversalFont(tempButton);
		tempButton.setBackground(Color.DARK_GRAY);
		return tempButton;
	}
	
	private float eval(float a, float b, String op){
		switch(op){
		case "+": return a + b;
		case "-": return a - b;
		case "*": return a * b;
		case "/": return a / b;
		case "=": 
		default: return 0;
		}
	}
	
	private void applyUniversalFont(JButton parent){
		parent.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
		parent.setForeground(MODIFIED_ORANGE);
	}
	
	private float displayVal(){
		return Float.parseFloat(display.getText());
	}
	
	private void output(String o){
		display.setText(o);
	}
	
	private void output(float o){
		if(o % 1 == 0){
			int temp = (int)o;
			display.setText(Integer.toString(temp));
		} else {
			display.setText(Float.toString(o));
		}
	}
	
	JTextField display;
	private float lastValue = 0;
	private float consecVal = 0;
	private String theOperator = null;
	private boolean start;
	private static final Color MODIFIED_ORANGE = new Color(1F, .749F, 0F);
}
