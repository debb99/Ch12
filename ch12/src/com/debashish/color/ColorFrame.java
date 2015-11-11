package com.debashish.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorFrame extends JFrame {
	class Listener implements ActionListener       
	{          
		public void actionPerformed(ActionEvent event)          
		{
			backgroundTest(event.getActionCommand(), "Red", Color.RED);
			backgroundTest(event.getActionCommand(), "Green", Color.GREEN);
			backgroundTest(event.getActionCommand(), "Blue", Color.BLUE);
			backgroundTest(event.getActionCommand(), "Black", Color.BLACK);
			backgroundTest(event.getActionCommand(), "White", Color.WHITE);
			
			if(event.getActionCommand().contains("Custom")){
				customFrame.setVisible(true);
			}
		}       
	}
	
	private void backgroundTest(String orig, String semi, Color col){
		if(orig.contains(semi)) colorPanel.setBackground(col);
	}
	
	public ColorFrame(String name) {
		super(name);
		colorPanel = new JPanel(new BorderLayout(10, 10));
		colorPanel.setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));
		add(colorPanel, BorderLayout.CENTER);
		
		initCustomFrame();
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		buttonPanel.setPreferredSize(new Dimension(100, 45));
		JButton redButton = new JButton("<html><font color = red>Red");
		JButton greenButton = new JButton("<html><font color = green>Green");
		JButton blueButton = new JButton("<html><font color = blue>Blue");
		Listener list = new Listener();
		redButton.addActionListener(list);
		greenButton.addActionListener(list);
		blueButton.addActionListener(list);
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(blueButton);
		colorPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JMenuBar colorMenu = new JMenuBar();
		setJMenuBar(colorMenu);
		JMenu bgColorMenu = new JMenu("Background Color");
			JMenuItem blackOption = new JMenuItem("Black");
			blackOption.addActionListener(list);
			JMenuItem whiteOption = new JMenuItem("White");
			whiteOption.addActionListener(list);
			JMenuItem customOption = new JMenuItem("<html><i>Custom");
			customOption.addActionListener(list);
				bgColorMenu.add(blackOption);
				bgColorMenu.add(whiteOption);
				bgColorMenu.add(customOption);
		colorMenu.add(bgColorMenu);
	}
	
	private void initCustomFrame(){
		customFrame = new CustomFrame("Custom Color Settings", colorPanel);
		customFrame.setSize(400, 275);
		customFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private JPanel colorPanel;
	private CustomFrame customFrame;
	private static final int CENTER_WIDTH = 300;
	private static final int CENTER_HEIGHT = 200;
}
