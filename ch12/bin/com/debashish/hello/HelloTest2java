package com.debashish.hello;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloTest
{
  public static void main (String[ ] args) 
   {
      HelloFrame frame = new HelloFrame( );
      frame.setVisible(true);
   }
}

class HelloFrame extends JFrame
{
  public HelloFrame( )
   {
      fontSizeFactor = 1;
      smallerButton = new JButton("Smaller");
      largerButton = new JButton("Larger");
      
      JPanel southPanel = new JPanel( );
      southPanel.add(smallerButton);
      southPanel.add(largerButton);
      
      largerButton.addActionListener(makeScaleAction(1.25));

      smallerButton.addActionListener(makeScaleAction(0.8));

      final int HORIZONTAL_SIZE = 300;
      final int VERTICAL_SIZE = 300;

      setSize(HORIZONTAL_SIZE, VERTICAL_SIZE);
      setTitle("Hello Test 1");
      
      WindowCloser listener = new WindowCloser( );
      addWindowListener(listener);
      
      panel = new HelloPanel( );
      panel.setMessageSize(DEFAULT_SIZE);
      panel.setMessageText("Hello, World!");

      add(panel, "Center");
      add(southPanel, "South");
   }
   
   public ActionListener makeScaleAction(final double scaleFactor)
   {
     class ScaleAction implements ActionListener
     {
        public void actionPerformed(ActionEvent event)
        {
           fontSizeFactor = scaleFactor * fontSizeFactor;
           panel.setMessageSize((int)(fontSizeFactor * DEFAULT_SIZE));
        }
     }
     
     ActionListener listener = new ScaleAction( );
     return listener;
   }
   
   private HelloPanel panel;
   private static final int DEFAULT_SIZE = 12;
   
   private JButton smallerButton;
   private JButton largerButton;
   private double fontSizeFactor;


   private class WindowCloser extends WindowAdapter
   {
     public void windowClosing(WindowEvent event)
      {
        System.exit(0);
      }
   }
}

class HelloPanel extends JPanel
{
   public HelloPanel( )
   {
      messageX = 100;
      messageY = 100;
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      Font messageFont = new Font("Serif", Font.PLAIN, messageSize);
      g2.setFont(messageFont);
      g2.drawString(messageText, messageX, messageY);
   }

   public void setMessageText(String text)
   {
      messageText = text;
      repaint( );
   }

   public void setMessageSize(int size)
   {
      messageSize = size;
      repaint( );
   }
   
   private int messageX;
   private int messageY;
   private String messageText;
   private int messageSize;
}
