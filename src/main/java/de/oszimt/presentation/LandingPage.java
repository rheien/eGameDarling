package de.oszimt.presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame implements ActionListener {
    JLabel willkommenstext;

    JButton login, register;

    public LandingPage(){
        super(" eGameDarling - Plattform für Gamer");

        willkommenstext = new JLabel("Willkommen auf eGameDarling");
        willkommenstext.setBounds(50, 50, 200, 20);

        login = new JButton("Login");
        login.setBounds(50, 320, 80, 30);
        login.addActionListener(this);

        register = new JButton("Register");
        register.setBounds(140, 320, 100, 30);
        register.addActionListener(this);

        add(willkommenstext);
        add(login);
        add(register);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(java.awt.event.ActionEvent event) {
        if(event.getSource() == login) {
            new LoginPage();

            //TODO: what happened after login?
        }
        if(event.getSource() == register) {
            new RegistrationPage();
        }
    }
}
