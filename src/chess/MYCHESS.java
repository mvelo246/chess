package chess;

import java.io.IOException;

import javax.swing.JFrame;



public class MYCHESS {
	public static void main(String[] args) {
        //Create the Frame
        JFrame myFrame = new JFrame();
        myFrame.setSize(1000, 1000);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("My Chess");
        //Add Components
        myFrame.add(new Board());
        myFrame.setVisible(true);
	}
		   



}
