package de.oszimt.controller;

import de.oszimt.database.model.versand.Kunden;

import java.util.Scanner;

public class Input {
    public String values(String text, Scanner scanner) {
        System.out.println(text);
        return scanner.nextLine();
    }

    public boolean validID(String id) {
        try {
            Integer.parseInt(id);
            return true;
        } catch (Exception e) {
            System.out.printf("Die ID %s ist ungültig!%n", id);
            return false;
        }
    }

    public boolean validStatus(String status) {
        if (status.equals("S") || status.equals("W") || status.equals("G")) {
            return true;
        } else {
            System.out.printf("Der Status %s ist ungültig!%n", status);
            return false;
        }
    }

    public boolean validZahlung(String zahlung) {
        if (zahlung.equals("N") || zahlung.equals("B") || zahlung.equals("R") || zahlung.equals("V") || zahlung.equals("K")) {
            return true;
        } else {
            System.out.printf("Die Zahlung %s ist ungültig!%n", zahlung);
            return false;
        }
    }

    public boolean validPlz(String plz) {
        try {
            Integer.parseInt(plz);
            return plz.length() == 5;
        } catch (Exception e) {
            System.out.printf("Die PLZ %s ist ungültig!%n", plz);
            return false;
        }
    }

    public Kunden setKunden(Scanner scanner) {

        String p_kunden_nr;
        do {
            p_kunden_nr = values("Bitte geben Sie eine Kundennummer ein: ", scanner);
        } while (!validID(p_kunden_nr));

        String status;
        do {
            status = values("Bitte geben Sie einen Status S,W oder G ein: ", scanner);
        } while (!validStatus(status));

        String zahlung;
        do {
            zahlung = values("Bitte geben Sie eine Zahlung N, B, R, V oder K ein: ", scanner);
        } while (!validZahlung(zahlung));

        String vname;
        do {
            vname = values("Bitte geben Sie einen Vornamen ein: ", scanner);
        } while (vname.isEmpty());

        String nname;
        do {
            nname = values("Bitte geben Sie einen Nachnamen ein: ", scanner);
        } while (nname.isEmpty());

        String strasse;
        do {
            strasse = values("Bitte geben Sie eine Straße ein: ", scanner);
        } while (strasse.isEmpty());

        String plz;
        do {
            plz = values("Bitte geben Sie eine Postleitzahl ein: ", scanner);
        } while (!validPlz(plz));

        String ort;
        do {
            ort = values("Bitte geben Sie einen Ort ein: ", scanner);
        } while (ort.isEmpty());

        /*String letztebestellung;
        do {
            letztebestellung = values("Überspringen oder geben Sie bitte ein Datum im Format 2023-5-25 ein: ", scanner);
        } while (letztebestellung.isEmpty());*/

        return new Kunden(p_kunden_nr, status, zahlung, vname, nname, strasse, plz, ort);
    }
}
