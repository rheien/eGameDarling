package de.oszimt.presentation;

import javax.swing.JFrame;
import javax.swing.JButton;

public class FrameBeispiel extends JFrame{
    JFrame f;

    FrameBeispiel() {


        //creating instance of JButton
        JButton b = new JButton("click me");
        b.setBounds(130, 100, 100, 40);

        //adding button in JFrame
        add(b);

        //400 width and 500 height
        setSize(400, 500);

        //using no layout managers
        setLayout(null);

        //making the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameBeispiel();
    }
}
