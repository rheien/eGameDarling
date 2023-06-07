package de.oszimt.presentation;

import de.oszimt.database.model.versand.Kunden;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame implements ActionListener {
    JLabel willkommenstext;

    JButton login, register, exit;
    JButton insert, delete, update;
    JButton logout;

    static String text = " eGameDarling - Plattform für Gamer";

    public LandingPage(){
        super(text);

        willkommenstext = new JLabel("Willkommen auf eGameDarling");
        willkommenstext.setBounds(50, 50, 200, 20);
        add(willkommenstext);

        login = new JButton("Login");
        login.setBounds(50, 320, 80, 30);
        login.addActionListener(this);
        add(login);

        register = new JButton("Register");
        register.setBounds(140, 320, 100, 30);
        register.addActionListener(this);
        add(register);

        exit = new JButton("Exit");
        exit.setBounds(250, 320, 80, 30);
        exit.addActionListener(this);
        add(exit);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LandingPage(Kunden user){
        super(text);

        willkommenstext = new JLabel("Willkommen "+  user.getNname().toString() + " auf eGameDarling");
        willkommenstext.setBounds(50, 50, 200, 20);
        add(willkommenstext);

        insert = new JButton("Add new customer");
        insert.setBounds(50, 120, 80, 30);
        insert.addActionListener(this);
        add(insert);

        delete = new JButton("Delete customer");
        delete.setBounds(140, 120, 100, 30);
        delete.addActionListener(this);
        add(delete);

        update = new JButton("Update customer");
        update.setBounds(250, 120, 80, 30);
        update.addActionListener(this);
        add(update);

        logout = new JButton("Logout");
        logout.setBounds(50, 200, 100, 30);
        logout.addActionListener(this);
        add(logout);

        exit = new JButton("Exit");
        exit.setBounds(50, 250, 80, 30);
        exit.addActionListener(this);
        add(exit);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(java.awt.event.ActionEvent event) {
        if(event.getSource() == login) {
            setVisible(false);
            LoginPage loginPage = new LoginPage();

            //TODO: what happened after login?
        }
        if(event.getSource() == register) {
            RegistrationPage registrationPage = new RegistrationPage("Registration for eGameDarling");
        }

        if(event.getSource() == exit) {
            System.exit(0);
        }

        if(event.getSource() == insert) {
            InsertPage insertPage = new InsertPage("Add new user for eGameDarling");
            //RegistrationPage registrationPage = new RegistrationPage("Add new user for eGameDarling");
        }

        if(event.getSource() == delete) {
            DeletePage deletePage = new DeletePage();
        }

        if(event.getSource() == update) {
            //UpdatePage updatePage = new UpdatePage();
        }

        if(event.getSource() == logout) {
            setVisible(false);
            LandingPage landingPage = new LandingPage();
        }
    }
}
