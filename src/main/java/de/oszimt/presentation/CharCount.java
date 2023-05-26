package de.oszimt.presentation;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class CharCount extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextArea textarea;



    JButton button, pad, text;


    JTextArea kundennumer,  nachname;
    JButton login, register;



    CharCount(){
        super("Char Word Count Tool - JTP");

        label1 = new JLabel("Characters: ");
        label1.setBounds(50, 50, 100, 20);
        label2 = new JLabel("Words: ");
        label2.setBounds(50, 80, 100, 20);

        textarea = new JTextArea();
        textarea.setBounds(50, 110, 100, 200);

        button = new JButton("Count");
        button.setBounds(50, 320, 80, 30);
        button.addActionListener(this);

        pad = new JButton("Pad Color");
        pad.setBounds(140, 320, 100, 30);
        pad.addActionListener(this);

        text = new JButton("Text Color");
        text.setBounds(250, 320, 100, 30);
        text.addActionListener(this);

        add(label1);
        add(label2);
        add(textarea);
        add(button);
        add(pad);
        add(text);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(java.awt.event.ActionEvent event) {
        if(event.getSource() == button) {
            String text = textarea.getText();
            label1.setText("Characters: " + text.length());
            String words[] = text.split("\\s");
            label2.setText("Words: " + words.length);
        }
        if(event.getSource() == pad) {
            Color c = JColorChooser.showDialog(this, "Choose Color", Color.BLACK);
            textarea.setBackground(c);
        }
        if(event.getSource() == text) {
            Color c = JColorChooser.showDialog(this, "Choose Color", Color.BLACK);
            textarea.setForeground(c);
        }
    }

    public static void main(String[] args) {
        new CharCount();
    }
}
