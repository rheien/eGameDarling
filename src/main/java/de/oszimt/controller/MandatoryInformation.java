package de.oszimt.controller;

import de.oszimt.database.model.versand.Kunden;

public class MandatoryInformation {

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

    public boolean validPLZ(String plz) {
        try {
            Integer.parseInt(plz);
            return plz.length() == 5;
        } catch (Exception e) {
            System.out.printf("Die PLZ %s ist ungültig!%n", plz);
            return false;
        }
    }

    public Kunden validSetKunden(){
        return null;
    }
}
