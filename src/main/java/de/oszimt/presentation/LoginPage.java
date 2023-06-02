package de.oszimt.presentation;

import de.oszimt.controller.Login;
import de.oszimt.database.model.versand.Kunden;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {
    JLabel kundennummer, nachname;
    JTextArea kundennummerEingabe, nachnameEingabe;
    JButton login, back;

    LoginPage() {
        super("Login to eGameDarling");

        kundennummer = new JLabel("Kundennummer: ");
        kundennummer.setBounds(50, 50, 100, 20);
        add(kundennummer);

        kundennummerEingabe = new JTextArea();
        kundennummerEingabe.setBounds(50, 80, 100, 20);
        add(kundennummerEingabe);

        nachname = new JLabel("Nachname: ");
        nachname.setBounds(50, 110, 100, 20);
        add(nachname);

        nachnameEingabe = new JTextArea();
        nachnameEingabe.setBounds(50, 140, 100, 20);
        add(nachnameEingabe);

        login = new JButton("Login");
        login.setBounds(50, 170, 80, 30);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(140, 170, 100, 30);
        back.addActionListener(this);
        add(back);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(java.awt.event.ActionEvent event) {
        if(event.getSource() == login) {
            Login login = new Login();
            try {
                Kunden kunden = new Kunden(
                        kundennummerEingabe.getText(),
                        nachnameEingabe.getText()
                );
                if(login.checkingAccount(kunden) == false) {
                    JOptionPane.showMessageDialog(null, "Kundennummer oder Nachname falsch!");
                    kundennummerEingabe.setText("");
                    nachnameEingabe.setText("");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Login erfolgreich!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login fehlgeschlagen!");
            }
        }
        if(event.getSource() == back) {
            new LandingPage();
        }
    }
}
