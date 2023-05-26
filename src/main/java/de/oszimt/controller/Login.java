package de.oszimt.controller;

import de.oszimt.database.model.versand.Kunden;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    private ArrayList<String> List(String username, String password) {
        ArrayList<String> list = new ArrayList<>();
        list.add(username);
        list.add(password);
        return list;
    }

    public ArrayList<String> toAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihre Kundennummer ein: ");
        String kundennummer = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihren Nachnamen ein: ");
        String nachname = scanner.nextLine();
        return List(kundennummer,nachname);
    }

    public boolean checkingAccount(Statement statement, ArrayList<String> list) {
        try {
            var kunden = new Kunden();
            String query = "SELECT * FROM T_Kunden WHERE p_kunden_nr = '" + list.get(0) + "' AND nname = '" + list.get(1) + "';";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                return (resultSet.getString("p_kunden_nr").equals(list.get(0)) &&
                        resultSet.getString("nname").equals(list.get(1)));
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
