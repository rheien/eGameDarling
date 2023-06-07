package de.oszimt.presentation;

import de.oszimt.database.model.Status;
import de.oszimt.database.model.Zahlung;
import de.oszimt.database.model.versand.Kunden;
import de.oszimt.database.service.EditingKunden;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistrationPage extends JFrame implements ActionListener {
    private final InputValidation inputValidation = new InputValidation(this);
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

    @Getter
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

    RegistrationPage(String text){
        super(text);

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
            if (inputValidation.invalidInputForRegistration()) return;

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
            new LandingPage().setVisible(true);
        }
    }
}
