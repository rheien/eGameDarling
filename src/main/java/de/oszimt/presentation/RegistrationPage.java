package de.oszimt.presentation;

import de.oszimt.controller.Registration;
import de.oszimt.database.model.Status;
import de.oszimt.database.model.Zahlung;
import de.oszimt.database.model.versand.Kunden;
import de.oszimt.database.service.EditingKunden;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistrationPage extends JFrame implements ActionListener {
    JLabel kundennummer,
            status,
            zahlung,
            vname,
            nname,
            strasse,
            plz,
            ort;
            /*
            letztebestellung,
            letztewerbeaktion;
            */

    JTextArea kundennummerEingabe,
            statusEingabe,
            zahlungEingabe,
            vnameEingabe,
            nnameEingabe,
            strasseEingabe,
            plzEingabe,
            ortEingabe;
            /*
            letztebestellungText,
            letztewerbeaktionText;
            */

    JButton submit, back;

    RegistrationPage(){
        super("Registration for eGameDarling");

        //TODO: Kundennummer automatisch generieren
        kundennummer = new JLabel("Kundennummer");
        kundennummer.setBounds(50, 50, 100, 20);
        add(kundennummer);

        kundennummerEingabe = new JTextArea();
        kundennummerEingabe.setBounds(50, 70, 100, 20);
        add(kundennummerEingabe);

        //concat ENUM Status to String
        String enumStatus = Stream.of(Status.values()).map(Enum::name).collect(Collectors.joining(", "));
        status = new JLabel("Status "+ enumStatus);
        status.setBounds(50, 100, 200, 20);
        add(status);

        statusEingabe = new JTextArea();
        statusEingabe.setBounds(50, 120, 100, 20);
        add(statusEingabe);

        //concat ENUM Zahlung to String
        String enumZahlung = Stream.of(Zahlung.values()).map(Enum::name).collect(Collectors.joining(", "));
        zahlung = new JLabel("Zahlung "+ enumZahlung);
        zahlung.setBounds(50, 150, 200, 20);
        add(zahlung);

        zahlungEingabe = new JTextArea();
        zahlungEingabe.setBounds(50, 170, 100, 20);
        add(zahlungEingabe);

        vname = new JLabel("Vorname");
        vname.setBounds(50, 200, 100, 20);
        add(vname);

        vnameEingabe = new JTextArea();
        vnameEingabe.setBounds(50, 220, 100, 20);
        add(vnameEingabe);

        nname = new JLabel("Nachname");
        nname.setBounds(50, 250, 100, 20);
        add(nname);

        nnameEingabe = new JTextArea();
        nnameEingabe.setBounds(50, 270, 100, 20);
        add(nnameEingabe);

        strasse = new JLabel("Straße");
        strasse.setBounds(50, 300, 100, 20);
        add(strasse);

        strasseEingabe = new JTextArea();
        strasseEingabe.setBounds(50, 320, 100, 20);
        add(strasseEingabe);

        plz = new JLabel("PLZ");
        plz.setBounds(50, 350, 100, 20);
        add(plz);

        plzEingabe = new JTextArea();
        plzEingabe.setBounds(50, 370, 100, 20);
        add(plzEingabe);

        ort = new JLabel("Ort");
        ort.setBounds(50, 400, 100, 20);
        add(ort);

        ortEingabe = new JTextArea();
        ortEingabe.setBounds(50, 420, 100, 20);
        add(ortEingabe);

        /*
        letztebestellung = new JLabel("Letzte Bestellung");
        letztebestellung.setBounds(50, 450, 100, 20);
        add(letztebestellung);

        letztebestellungEingabe = new JTextArea();
        letztebestellungEingabe.setBounds(50, 470, 100, 20);
        add(letztebestellungEingabe);

        letztewerbeaktion = new JLabel("Letzte Werbeaktion");
        letztewerbeaktion.setBounds(50, 500, 100, 20);
        add(letztewerbeaktion);

        letztewerbeaktionEingabe = new JTextArea();
        letztewerbeaktionEingabe.setBounds(50, 520, 100, 20);
        add(letztewerbeaktionEingabe);
        */

        submit = new JButton("Submit");
        submit.setBounds(50, 550, 80, 30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(140, 550, 100, 30);
        back.addActionListener(this);
        add(back);

        setSize(600, 700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(java.awt.event.ActionEvent event) {
        if (event.getSource() == submit) {
            if (invalidInputForRegistration()) return;

            else{
                Kunden kunden = new Kunden(
                        kundennummerEingabe.getText(),
                        statusEingabe.getText(),
                        zahlungEingabe.getText(),
                        vnameEingabe.getText(),
                        nnameEingabe.getText(),
                        strasseEingabe.getText(),
                        plzEingabe.getText(),
                        ortEingabe.getText()
                );
                try {
                    //TODO: vorhandene Kundennummer abfangen
                    EditingKunden editingKunden = new EditingKunden();
                    editingKunden.insert(kunden);

                    JOptionPane.showMessageDialog(null, "Registration successful");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Registration failed");
                }
            }
        }

        if (event.getSource() == back) {
            setVisible(false);
            dispose();
            new LoginPage().setVisible(true);
        }
    }

    private boolean invalidInputForRegistration() {
        Registration register = new Registration();
        if(register.validID(kundennummerEingabe.getText()) == false){
            JOptionPane.showMessageDialog(null, "Kundennummer muss 6-stellig sein");
            kundennummerEingabe.setText("");
            kundennummerEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(register.validStatus(statusEingabe.getText()) == false){
            JOptionPane.showMessageDialog(null, "Status muss S, W oder G sein");
            statusEingabe.setText("");
            statusEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(register.validZahlung(zahlungEingabe.getText()) == false){
            JOptionPane.showMessageDialog(null, "Zahlung muss N, B, R, V oder K sein");
            zahlungEingabe.setText("");
            zahlungEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(vnameEingabe.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vorname darf nicht leer sein");
            vnameEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(nnameEingabe.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nachname darf nicht leer sein");
            nnameEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(strasseEingabe.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Straße darf nicht leer sein");
            strasseEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(register.validPLZ(plzEingabe.getText()) == false){
            JOptionPane.showMessageDialog(null, "PLZ muss 5-stellig sein");
            plzEingabe.setText("");
            plzEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }

        if(ortEingabe.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ort darf nicht leer sein");
            ortEingabe.setBorder(new LineBorder(java.awt.Color.RED));
            return true;
        }
        return false;
    }
}
