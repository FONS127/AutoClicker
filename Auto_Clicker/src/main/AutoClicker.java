package main;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class AutoClicker implements ActionListener{
	JFrame frame;
	JTextField textfieldX;
	JTextField textfieldY;
	JLabel x = new JLabel("X");
	JLabel y = new JLabel("Y");
	JPanel panel;
	JPanel panel2;
	Boolean flag = false;
	JButton activate = new JButton("Start Clicking");
	JButton stop = new JButton("Stop");
	
	Font myFont = new Font("Serif",Font.BOLD,30);

	
AutoClicker(){
	frame = new JFrame("AutoClicker");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 550);
	frame.setLayout(new BorderLayout());
	
	textfieldX = new JTextField();
	textfieldX.setBounds(50, 25, 300, 50);
	textfieldX.setFont(myFont);
	x.setFont(new Font("Serif",Font.BOLD,50));
	y.setFont(new Font("Serif",Font.BOLD,50));
	
	textfieldY = new JTextField();
	textfieldY.setBounds(50, 25, 300, 50);
	textfieldY.setFont(myFont);
	
	activate.addActionListener(this);
	activate.setFont(myFont);
	stop.addActionListener(this);
	stop.setFont(myFont);
	activate.setFocusable(false);
	stop.setFocusable(false);

	
	panel = new JPanel();
	panel2 = new JPanel();
	panel.setBounds(50, 100, 300, 300);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel2.setBounds(50, 100, 300, 300);
	panel2.setLayout(new GridLayout(4,4,10,10));
	
	
	
	
	
	panel.add(x);
	panel.add(textfieldX);
	panel.add(y);
	panel.add(textfieldY);
	panel2.add(activate,BorderLayout.SOUTH);
	panel2.add(stop,BorderLayout.SOUTH);
	frame.add(panel);
	frame.add(panel2,BorderLayout.SOUTH);
	frame.setVisible(true);
}	
public static void deActivate() {
	try {
		Robot r = new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//public void autoClick(int x,int y) {
//	
//}

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==activate && !flag) {
		flag= true;
	
	
	if(textfieldX.getText().isEmpty()||textfieldY.getText().isEmpty()) {
		runThread(200,200);
	}
	else {
	runThread(Integer.parseInt(textfieldX.getText()), Integer.parseInt(textfieldY.getText()));	
	}
	x.setText("Clicking!!");
	}
	
	if(e.getSource()==stop && flag) {
		//deActivate();
		flag = false;
		x.setText("Stopped!!");
	}
}
	
public static void main(String[] args) {
	AutoClicker ac = new AutoClicker();
}

private void runThread(int x,int y){

    new Thread(new Runnable() {

        @Override
        public void run() {
        	try {
        		Robot r = new Robot();
        		r.mouseMove(x, y);
        		while(flag) {
        		
        		int button = InputEvent.BUTTON1_DOWN_MASK;
        		System.out.println("Click");
        		r.mousePress(button);
        		Thread.sleep(400);
        		r.mouseRelease(button);
        		Thread.sleep(2000);
        		
//        		x+=100;
//        		y+=100;
//        					
//        		
//        		
        		}
        	} catch (Exception e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} 
        }
    }).start();
}


}
