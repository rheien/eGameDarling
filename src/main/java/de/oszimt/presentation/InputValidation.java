package de.oszimt.presentation;

import de.oszimt.controller.MandatoryInformation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.Serializable;

public class InputValidation implements Serializable {
    private RegistrationPage registrationPage;
    private InsertPage insertPage;

    public InputValidation(RegistrationPage registrationPage) {
        this.registrationPage = registrationPage;
    }
    public InputValidation(InsertPage insertPage) {
        this.insertPage = insertPage;
    }


    boolean invalidInputForRegistration() {
        MandatoryInformation register = new MandatoryInformation();
        if (register.validID(registrationPage.getKundennummerEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Kundennummer muss 6-stellig sein");
            registrationPage.getKundennummerEingabe().setText("");
            registrationPage.getKundennummerEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (register.validStatus(registrationPage.getStatusEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Status muss S, W oder G sein");
            registrationPage.getStatusEingabe().setText("");
            registrationPage.getStatusEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (register.validZahlung(registrationPage.getZahlungEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Zahlung muss N, B, R, V oder K sein");
            registrationPage.getZahlungEingabe().setText("");
            registrationPage.getZahlungEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getVnameEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vorname darf nicht leer sein");
            registrationPage.getVnameEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getNnameEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nachname darf nicht leer sein");
            registrationPage.getNnameEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getStrasseEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Straße darf nicht leer sein");
            registrationPage.getStrasseEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (register.validPLZ(registrationPage.getPlzEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "PLZ muss 5-stellig sein");
            registrationPage.getPlzEingabe().setText("");
            registrationPage.getPlzEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getOrtEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ort darf nicht leer sein");
            registrationPage.getOrtEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }
        return false;
    }

    boolean invalidInputNewUser() {
        MandatoryInformation register = new MandatoryInformation();
        if (register.validID(insertPage.getKundennummerEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Kundennummer muss 6-stellig sein");
            registrationPage.getKundennummerEingabe().setText("");
            registrationPage.getKundennummerEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (register.validStatus(registrationPage.getStatusEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Status muss S, W oder G sein");
            registrationPage.getStatusEingabe().setText("");
            registrationPage.getStatusEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (register.validZahlung(registrationPage.getZahlungEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Zahlung muss N, B, R, V oder K sein");
            registrationPage.getZahlungEingabe().setText("");
            registrationPage.getZahlungEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getVnameEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vorname darf nicht leer sein");
            registrationPage.getVnameEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getNnameEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nachname darf nicht leer sein");
            registrationPage.getNnameEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getStrasseEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Straße darf nicht leer sein");
            registrationPage.getStrasseEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (register.validPLZ(registrationPage.getPlzEingabe().getText()) == false) {
            JOptionPane.showMessageDialog(null, "PLZ muss 5-stellig sein");
            registrationPage.getPlzEingabe().setText("");
            registrationPage.getPlzEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }

        if (registrationPage.getOrtEingabe().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ort darf nicht leer sein");
            registrationPage.getOrtEingabe().setBorder(new LineBorder(Color.RED));
            return true;
        }
        return false;
    }
}